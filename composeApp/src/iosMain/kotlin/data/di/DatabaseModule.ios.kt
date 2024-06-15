package data.di

import com.kmpktor.AppDatabase
import data.local.sqldelight.IOSDatabaseDriverFactory
import domain.repository.CountryRepository
import org.koin.core.module.Module
import org.koin.dsl.module

actual val databaseModule: Module = module {
    single { IOSDatabaseDriverFactory().createDriver() }
    single { AppDatabase(get()) }
    single { CountryRepository(get()) }
}
