package kmp.project.ktor

import android.app.Application
import data.di.KoinInitializer

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        KoinInitializer(applicationContext).init()
    }
}