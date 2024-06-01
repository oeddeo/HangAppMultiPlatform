package data.di

import org.koin.core.module.Module
import org.koin.dsl.module

val appModule = module {
    single { "Koin test string" }
}

