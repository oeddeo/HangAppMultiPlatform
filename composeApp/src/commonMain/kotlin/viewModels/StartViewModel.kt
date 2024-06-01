package viewModels

import androidx.lifecycle.ViewModel
import data.Country
import data.StartState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import me.sample.library.resources.Res
import me.sample.library.resources.eg
import me.sample.library.resources.fr
import me.sample.library.resources.id
import me.sample.library.resources.jp
import me.sample.library.resources.mx
import me.sample.library.resources.se

class StartViewModel(val injectedString: String) : ViewModel() {

    private val _uisState = MutableStateFlow(StartState())
    val uiState: StateFlow<StartState> = _uisState.asStateFlow()

    fun selectCountry(selectedCountryName: String) {
        val selectedCountry = _uisState.value.currentCountry.copy(name = selectedCountryName)
        _uisState.value = _uisState.value.copy(currentCountry = selectedCountry)
    }

    fun countries() = listOf(
        Country("Japan", Res.drawable.jp),
        Country("France", Res.drawable.fr),
        Country("Mexico",  Res.drawable.mx),
        Country("Indonesia", Res.drawable.id),
        Country("Egypt", Res.drawable.eg),
        Country("Sweden", Res.drawable.se)
    )

}
