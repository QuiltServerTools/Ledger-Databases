package net.quiltservertools.ledger.databases.databases

import com.github.quiltservertools.ledger.Ledger
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import net.quiltservertools.ledger.databases.DatabaseExtensionSpec
import net.quiltservertools.ledger.databases.LedgerDatabases
import java.nio.file.Path
import javax.sql.DataSource

object PostgreSQL : LedgerDatabase {
    override fun getDataSource(savePath: Path): DataSource = HikariDataSource(HikariConfig().apply {
        jdbcUrl = "jdbc:postgresql://${Ledger.config[DatabaseExtensionSpec.url]}"
        username = Ledger.config[DatabaseExtensionSpec.userName]
        password = Ledger.config[DatabaseExtensionSpec.password]
        maximumPoolSize = Ledger.config[DatabaseExtensionSpec.maxPoolSize]
        addDataSourceProperty("reWriteBatchedInserts", "true")
        for ((key, value) in Ledger.config[DatabaseExtensionSpec.properties]) {
            addDataSourceProperty(key, value)
        }
    })

    override fun getDatabaseIdentifier() = LedgerDatabases.identifier("postgresql")
}
