package net.quiltservertools.ledger.databases.databases

import com.github.quiltservertools.ledger.Ledger
import net.minecraft.server.MinecraftServer
import net.quiltservertools.ledger.databases.DatabaseExtensionSpec
import org.jetbrains.exposed.sql.Database

object MySQL : LedgerDatabase {
    override fun getDatabase(server: MinecraftServer): Database {
        var url = "jdbc:mysql://${Ledger.config[DatabaseExtensionSpec.url]}?rewriteBatchedStatements=true"
        for (arg in Ledger.config[DatabaseExtensionSpec.properties]) {
            url = url.plus("&$arg")
        }
        return Database.connect(
            url = url,
            user = Ledger.config[DatabaseExtensionSpec.userName],
            password = Ledger.config[DatabaseExtensionSpec.password]
        )
    }

    override fun getDatabaseIdentifier() = Ledger.identifier("mysql")
}
