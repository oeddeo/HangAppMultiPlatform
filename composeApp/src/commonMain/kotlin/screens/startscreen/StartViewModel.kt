package screens.startscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kmpktor.CountryDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import domain.repository.CountryRepository
import domain.extensions.toCountry
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant


class StartViewModel(private val repository: CountryRepository, val injectedString: String) : ViewModel() {

    private val _uiState = MutableStateFlow(StartState())
    val uiState: StateFlow<StartState> = _uiState.asStateFlow()


    init {
        viewModelScope.launch {
            val countries = repository.getAllCountries()
            if (countries.isEmpty()) {
                insertInitialCountries()
            } else {
                val domainCountries = countries.map { it.toCountry() }
                _uiState.value = _uiState.value.copy(countries = domainCountries)
                _uiState.value = _uiState.value.copy(currentCountry = domainCountries.first())
            }
        }
    }

    private fun insertInitialCountries() {
        viewModelScope.launch {
            val initialCountries = listOf(
                CountryDto(0, "Japan", "jp"),
                CountryDto(0, "France", "fr"),
                CountryDto(0, "Mexico", "mx"),
                CountryDto(0, "Indonesia", "id"),
                CountryDto(0, "Egypt", "eg"),
                CountryDto(0, "Sweden", "se")
            )

            initialCountries.forEach {
                repository.insertCountry(it.name, it.flagName)
            }

            val countries = repository.getAllCountries()
            val domainCountries = countries.map { it.toCountry() }
            _uiState.value = _uiState.value.copy(countries = domainCountries)
            _uiState.value = _uiState.value.copy(currentCountry = domainCountries.first())
        }
    }

    fun selectCountry(selectedCountryName: String) {
        val selectedCountry = _uiState.value.countries.find { it.name == selectedCountryName }
        _uiState.value = selectedCountry?.let { _uiState.value.copy(currentCountry = it) }!!

    }

    fun saveVisitToCountry(){
        viewModelScope.launch {
            val currentTime: Instant = Clock.System.now()
            val visitor = _uiState.value.visitor.copy(
                timeOfVisit = currentTime,
                countryId = _uiState.value.currentCountry.id
            )
            repository.insertVisitor(visitor)
        }
    }
    fun onVisitorNameInput(userName: String) {
        val visitor = _uiState.value.visitor.copy(name = userName)
        _uiState.value = _uiState.value.copy(visitor = visitor)
    }
}


