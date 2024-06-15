package data.local.sqldelight


import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.kmpktor.AppDatabase

class AndroidDatabaseDriverFactory(private val context: Context) : DataBaseDriverFactory {
    override fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(AppDatabase.Schema, context, "ktorapp.db")
    }
}