package net.quiltservertools.ledger.databases

import com.github.quiltservertools.ledger.Ledger
import com.github.quiltservertools.ledger.api.DatabaseExtension
import com.github.quiltservertools.libs.com.uchuhimo.konf.ConfigSpec
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import net.minecraft.util.Identifier
import org.h2.jdbcx.JdbcDataSource
import org.sqlite.SQLiteDataSource
import java.nio.file.Path
import javax.sql.DataSource
import kotlin.io.path.pathString

class LedgerDatabaseExtension : DatabaseExtension {
    override fun getConfigSpecs(): List<ConfigSpec> = listOf(DatabaseExtensionSpec)

    override fun getDataSource(fileLocation: Path): DataSource {
        return when (Ledger.config[DatabaseExtensionSpec.database]) {
            Databases.SQLITE -> SQLiteDataSource().apply {
                url = "jdbc:sqlite:${fileLocation.resolve("ledger.sqlite").pathString}"
            }

            Databases.H2 -> JdbcDataSource().apply {
                setURL("jdbc:h2:${fileLocation.resolve("ledger.h2").pathString};MODE=MySQL")
            }

            Databases.MYSQL -> HikariDataSource(HikariConfig().apply {
                jdbcUrl = "jdbc:mysql://${Ledger.config[DatabaseExtensionSpec.url]}?rewriteBatchedStatements=true"
                username = Ledger.config[DatabaseExtensionSpec.userName]
                password = Ledger.config[DatabaseExtensionSpec.password]
                maximumPoolSize = Ledger.config[DatabaseExtensionSpec.maxPoolSize]
            })

            Databases.POSTGRESQL -> HikariDataSource(HikariConfig().apply {
                jdbcUrl = "jdbc:postgresql://${Ledger.config[DatabaseExtensionSpec.url]}?rewriteBatchedStatements=true"
                username = Ledger.config[DatabaseExtensionSpec.userName]
                password = Ledger.config[DatabaseExtensionSpec.password]
                maximumPoolSize = Ledger.config[DatabaseExtensionSpec.maxPoolSize]
            })
        }
    }

    override fun getIdentifier(): Identifier = when (Ledger.config[DatabaseExtensionSpec.database]) {
        Databases.MYSQL -> Ledger.identifier("mysql_extension")
        Databases.H2 -> Ledger.identifier("h2_extension")
        Databases.POSTGRESQL -> Ledger.identifier("postgresql_extension")
        else -> Ledger.identifier(Ledger.DEFAULT_DATABASE)
    }
}
