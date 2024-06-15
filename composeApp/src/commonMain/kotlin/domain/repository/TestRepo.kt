//package domain.repository
//
//import com.kmpktor.AppDatabase
//import com.kmpktor.CountryDto
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.IO
//import kotlinx.coroutines.flow.Flow
//
//class TestRepo(database: AppDatabase): TestRepoInterface {
//    val query = database.appDatabaseQueries
//    override fun getAllCountries(): Flow<List<CountryDto>> {
//        query.selectAllCountriesDto()
//            .asFlow()
//            .mapToList(Dispatchers.IO)
//    }
//}