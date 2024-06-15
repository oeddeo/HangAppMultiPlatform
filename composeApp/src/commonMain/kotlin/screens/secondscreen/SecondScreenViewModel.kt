package screens.secondscreen

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.repository.CountryRepository
import domain.model.Visitor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class SecondScreenViewModel(private val repository: CountryRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(SecondState())
    val uiState: StateFlow<SecondState> = _uiState.asStateFlow()

    fun loadVisitors(countryName: String) {
        viewModelScope.launch() {
            try {
                val country = repository.getCountryByName(countryName)
                val visitors = country?.let { repository.getAllVisitorsByCountry(it.id) }.orEmpty()
                _uiState.value = _uiState.value.copy(visitors = visitors)
            } catch (e: Exception) {
                println("Exception in loadVisitors: ${e.message}")
            }
        }
    }
}

data class SecondState(
    val visitors: List<Visitor>? = null,
    val visitor: Visitor? = null,
    val countryRepository: CountryRepository? = null
)