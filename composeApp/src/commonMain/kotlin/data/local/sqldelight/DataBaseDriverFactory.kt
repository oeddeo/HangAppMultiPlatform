package data.local.sqldelight

import app.cash.sqldelight.db.SqlDriver

interface DataBaseDriverFactory {
    fun createDriver(): SqlDriver
}
