package data.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import screens.secondscreen.SecondScreenViewModel
import screens.startscreen.StartViewModel

actual val viewModelModule = module {
    viewModelOf(::StartViewModel)
    viewModelOf(::SecondScreenViewModel)
}