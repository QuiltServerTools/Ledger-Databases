package net.quiltservertools.ledger.databases

import com.github.quiltservertools.ledger.Ledger
import com.github.quiltservertools.ledger.api.DatabaseExtension
import com.github.quiltservertools.libs.com.uchuhimo.konf.ConfigSpec
import net.minecraft.server.MinecraftServer
import net.minecraft.util.Identifier
import net.minecraft.util.WorldSavePath
import org.jetbrains.exposed.sql.Database
import kotlin.io.path.pathString

class LedgerDatabaseExtension : DatabaseExtension {
    override fun getConfigSpecs(): List<ConfigSpec> = listOf(DatabaseExtensionSpec)

    override fun getDatabase(server: MinecraftServer): Database {
        return when (Ledger.config[DatabaseExtensionSpec.database]) {
            Databases.SQLITE -> Database.connect(
                url = "jdbc:sqlite:${server.getSavePath(WorldSavePath.ROOT).resolve("ledger.sqlite").pathString}",
            )
            Databases.H2 -> Database.connect(
                url = "jdbc:h2:${server.getSavePath(WorldSavePath.ROOT).resolve("ledger.h2").toFile()};MODE=MySQL"
            )
            Databases.MYSQL -> Database.connect(
                url = "jdbc:mysql://${Ledger.config[DatabaseExtensionSpec.url]}?rewriteBatchedStatements=true",
                user = Ledger.config[DatabaseExtensionSpec.userName],
                password = Ledger.config[DatabaseExtensionSpec.password]
            )
            Databases.POSTGRESQL -> Database.connect(
                url = "jdbc:postgresql://${Ledger.config[DatabaseExtensionSpec.url]}?rewriteBatchedStatements=true",
                user = Ledger.config[DatabaseExtensionSpec.userName],
                password = Ledger.config[DatabaseExtensionSpec.password]
            )
        }
    }

    override fun getIdentifier(): Identifier = when (Ledger.config[DatabaseExtensionSpec.database]) {
        Databases.MYSQL -> Ledger.identifier("mysql_extension")
        Databases.H2 -> Ledger.identifier("h2_extension")
        Databases.POSTGRESQL -> Ledger.identifier("postgresql_extension")
        else -> Ledger.identifier(Ledger.DEFAULT_DATABASE)
    }
}
