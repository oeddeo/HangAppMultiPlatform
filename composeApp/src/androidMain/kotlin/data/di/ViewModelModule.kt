package data.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import viewModels.StartViewModel

actual val viewModelModule = module {
    viewModelOf(::StartViewModel)
}