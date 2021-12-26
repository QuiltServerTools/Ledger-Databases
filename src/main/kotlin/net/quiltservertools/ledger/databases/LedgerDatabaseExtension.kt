package net.quiltservertools.ledger.databases

import com.github.quiltservertools.ledger.Ledger
import com.github.quiltservertools.ledger.api.DatabaseExtension
import com.github.quiltservertools.libs.com.uchuhimo.konf.ConfigSpec
import net.minecraft.server.MinecraftServer
import net.minecraft.util.Identifier
import org.jetbrains.exposed.sql.Database

class LedgerDatabaseExtension : DatabaseExtension {
    override fun getConfigSpecs(): List<ConfigSpec> = listOf(DatabaseExtensionSpec)

    override fun getDatabase(server: MinecraftServer): Database {
        return Ledger.config[DatabaseExtensionSpec.database].database.getDatabase(server)
    }

    override fun getIdentifier(): Identifier = Ledger.config[DatabaseExtensionSpec.database].database.getDatabaseIdentifier()
}
