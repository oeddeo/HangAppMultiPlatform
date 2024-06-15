package data.local.sqldelight

import app.cash.sqldelight.db.SqlDriver
import com.kmpktor.AppDatabase
import app.cash.sqldelight.driver.native.NativeSqliteDriver
class IOSDatabaseDriverFactory : DataBaseDriverFactory {
    override fun createDriver(): SqlDriver {
        return NativeSqliteDriver(AppDatabase.Schema, "ktorapp.db")
    }
}