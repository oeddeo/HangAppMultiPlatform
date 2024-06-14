package domain.repository

import com.kmpktor.AppDatabase
import domain.extensions.toCountry
import domain.extensions.toVisitor
import domain.model.Country
import domain.model.Visitor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow


class CountryRepository(private val database: AppDatabase) {
    private val query = database.appDatabaseQueries
    fun getAllCountries() = query.selectAllCountriesDto().executeAsList()

    fun insertCountry(name: String, flagName: String) {
        query.insertCountryDto(name, flagName)
    }

    fun getAllVisitorsByCountry(countryId: Long): List<Visitor> {
        return query.selectVisitorsByCountryDto(countryId)
            .executeAsList()
            .map { it.toVisitor() }
    }
    fun insertVisitor(visitor: Visitor){
        query.insertVisitorDto(
            visitor.name,
            visitor.timeOfVisit.toString(),
            visitor.countryId)

    }
    fun getCountryByName(countryName: String): Country? {
        return query.selectCountryByName(countryName)
            .executeAsOneOrNull()
            ?.toCountry()
    }
}
