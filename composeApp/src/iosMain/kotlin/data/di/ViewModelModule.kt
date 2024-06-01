package data.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import viewModels.StartViewModel

actual val viewModelModule = module {
    singleOf(::StartViewModel)
}