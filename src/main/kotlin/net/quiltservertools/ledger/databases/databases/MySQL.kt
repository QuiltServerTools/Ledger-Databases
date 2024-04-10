package net.quiltservertools.ledger.databases.databases

import com.github.quiltservertools.ledger.Ledger
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import net.quiltservertools.ledger.databases.DatabaseExtensionSpec
import net.quiltservertools.ledger.databases.LedgerDatabases
import java.nio.file.Path
import javax.sql.DataSource

object MySQL : LedgerDatabase {
    override fun getDataSource(savePath: Path): DataSource = HikariDataSource(HikariConfig().apply {
        jdbcUrl = "jdbc:mysql://${Ledger.config[DatabaseExtensionSpec.url]}"
        username = Ledger.config[DatabaseExtensionSpec.userName]
        password = Ledger.config[DatabaseExtensionSpec.password]
        maximumPoolSize = Ledger.config[DatabaseExtensionSpec.maxPoolSize]
        connectionTimeout = Ledger.config[DatabaseExtensionSpec.connectionTimeout]
        addDataSourceProperty("rewriteBatchedStatements", "true")
        addDataSourceProperty("cachePrepStmts", true)
        addDataSourceProperty("prepStmtCacheSize", 250)
        addDataSourceProperty("prepStmtCacheSqlLimit", 2048)
        addDataSourceProperty("useServerPrepStmts", true)
        addDataSourceProperty("cacheCallableStmts", true)
        addDataSourceProperty("cacheResultSetMetadata", true)
        addDataSourceProperty("cacheServerConfiguration", true)
        addDataSourceProperty("useLocalSessionState", true)
        addDataSourceProperty("elideSetAutoCommits", true)
        addDataSourceProperty("alwaysSendSetIsolation", false)
        for ((key, value) in Ledger.config[DatabaseExtensionSpec.properties]) {
            addDataSourceProperty(key, value)
        }
    })

    override fun getDatabaseIdentifier() = LedgerDatabases.identifier("mysql")
}
