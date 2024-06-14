package screens.secondscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.repository.CountryRepository
import domain.model.Visitor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SecondScreenViewModel(private val repository: CountryRepository): ViewModel() {
    private val _uiState = MutableStateFlow(SecondState())
    val uiState: StateFlow<SecondState> = _uiState.asStateFlow()


    fun loadVisitors(countryName: String) {
        viewModelScope.launch {
            val country = repository.getCountryByName(countryName)
            val visitors = repository.getAllVisitorsByCountry(country!!.id)
            _uiState.value = _uiState.value.copy(visitors =visitors)
        }
    }
}

data class SecondState(
    val visitors: List<Visitor>? = null,
    val visitor: Visitor? = null,
    val countryRepository: CountryRepository? = null
)