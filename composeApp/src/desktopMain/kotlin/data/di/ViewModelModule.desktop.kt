package data.di


import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import screens.secondscreen.SecondScreenViewModel
import screens.startscreen.StartViewModel


actual val viewModelModule = module {
    singleOf(::StartViewModel)
    singleOf(::SecondScreenViewModel)
}