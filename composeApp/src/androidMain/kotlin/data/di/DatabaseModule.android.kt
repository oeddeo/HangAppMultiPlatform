package data.di

import org.koin.dsl.module
import data.local.sqldelight.AndroidDatabaseDriverFactory
import com.kmpktor.AppDatabase
import domain.repository.CountryRepository
import org.koin.core.module.Module

actual val databaseModule: Module = module {
    single { AndroidDatabaseDriverFactory(get()).createDriver() }
    single { AppDatabase(get()) }
    single { CountryRepository(get()) }
}