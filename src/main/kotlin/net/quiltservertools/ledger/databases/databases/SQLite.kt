package net.quiltservertools.ledger.databases.databases

import com.github.quiltservertools.ledger.Ledger
import net.minecraft.server.MinecraftServer
import net.minecraft.util.WorldSavePath
import org.jetbrains.exposed.sql.Database
import kotlin.io.path.pathString

object SQLite : LedgerDatabase {
    override fun getDatabase(server: MinecraftServer) = Database.connect(
        url = "jdbc:sqlite:${server.getSavePath(WorldSavePath.ROOT).resolve("ledger.sqlite").pathString}"
    )

    override fun getDatabaseIdentifier() = Ledger.identifier(Ledger.DEFAULT_DATABASE)
}
