package domain.model

import kotlinx.datetime.Instant
import org.jetbrains.compose.resources.DrawableResource

data class Country(
    val id: Long,
    val name: String,
    val flag: DrawableResource,
    val visitors: List<Visitor>
)


data class Visitor(
    val id: Long = 0,
    val name: String = "",
    val timeOfVisit: Instant? = null,
    val countryId: Long = 0
)
