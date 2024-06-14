package domain.repository

import com.kmpktor.CountryDto
import kotlinx.coroutines.flow.Flow

interface commonDataSourceInterface {

    fun getAllCountries(): Flow<List<CountryDto>>
    suspend fun insertCountry(name: String, flagName: String)
    suspend fun getCountryByName(name: String): CountryDto?



}
