package data.local.sqldelight

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.kmpktor.AppDatabase
import java.io.File

class DesktopDatabaseDriverFactory : DataBaseDriverFactory {
    override fun createDriver(): SqlDriver {
        val dbFilePath: String = getPath(isDebug = false)
        val driver: SqlDriver = JdbcSqliteDriver("jdbc:sqlite:$dbFilePath")

        if (!File(dbFilePath).exists()) {
            AppDatabase.Schema.create(driver)
        }
        return driver
    }

    private fun getPath(isDebug: Boolean): String {
        val propertyKey = if (isDebug) "java.io.tmpdir" else "user.home"
        val parentFolderPath = System.getProperty(propertyKey) + "/SqlDelightDemo"
        val parentFolder = File(parentFolderPath)
        if (!parentFolder.exists()) {
            parentFolder.mkdirs()
        }
        val databasePath = File(parentFolderPath, "ktorapp.db")
        return databasePath.absolutePath
    }
}

