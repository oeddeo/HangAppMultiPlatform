package screens.startscreen

import domain.model.Country
import domain.model.Visitor
import me.sample.library.resources.Res
import me.sample.library.resources.se

data class StartState(
    val currentCountry: Country = Country(id = 0, name = "Sweden", flag = Res.drawable.se, visitors = listOf(Visitor())),
    val showContent: Boolean = false,
    val countries: List<Country> = emptyList(),
    val visitor: Visitor = Visitor()
)
