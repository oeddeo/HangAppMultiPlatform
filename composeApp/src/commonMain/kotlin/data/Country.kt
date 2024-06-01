package data

import me.sample.library.resources.Res
import me.sample.library.resources.se
import org.jetbrains.compose.resources.DrawableResource

data class Country(
    val name: String = "Sweden",
    val flag: DrawableResource = Res.drawable.se)