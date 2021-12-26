package net.quiltservertools.ledger.databases.databases

import com.github.quiltservertools.ledger.Ledger
import net.minecraft.server.MinecraftServer
import net.minecraft.util.WorldSavePath
import org.jetbrains.exposed.sql.Database

object H2Database : LedgerDatabase {
    override fun getDatabase(server: MinecraftServer) = Database.connect(
        url = "jdbc:h2:${server.getSavePath(WorldSavePath.ROOT).resolve("ledger.h2").toFile()};MODE=MySQL"
    )

    override fun getDatabaseIdentifier() = Ledger.identifier("h2")
}
