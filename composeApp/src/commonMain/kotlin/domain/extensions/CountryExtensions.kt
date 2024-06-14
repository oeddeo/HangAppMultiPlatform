package domain.extensions

import com.kmpktor.CountryDto
import domain.model.Country
import me.sample.library.resources.Res
import me.sample.library.resources.eg
import me.sample.library.resources.fr
import me.sample.library.resources.id
import me.sample.library.resources.jp
import me.sample.library.resources.mx
import me.sample.library.resources.se

fun CountryDto.toCountry(): Country {
    val flagResource = when (this.flagName) {
        "jp" -> Res.drawable.jp
        "fr" -> Res.drawable.fr
        "mx" -> Res.drawable.mx
        "id" -> Res.drawable.id
        "eg" -> Res.drawable.eg
        else -> Res.drawable.se
    }
    return Country(id = this.id, name = this.name, flag = flagResource, visitors = listOf())
}


fun Country.toDto(): CountryDto {
    val flagName = when (this.flag) {
        Res.drawable.jp -> "jp"
        Res.drawable.fr -> "fr"
        Res.drawable.mx -> "mx"
        Res.drawable.id -> "id"
        Res.drawable.eg -> "eg"
        else -> "se"
    }
    return CountryDto(id = this.id, name = this.name, flagName = flagName)
}