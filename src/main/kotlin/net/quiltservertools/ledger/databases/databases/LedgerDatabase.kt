package net.quiltservertools.ledger.databases.databases

import net.minecraft.server.MinecraftServer
import net.minecraft.util.Identifier
import org.jetbrains.exposed.sql.Database

interface LedgerDatabase {
    fun getDatabase(server: MinecraftServer): Database
    fun getDatabaseIdentifier(): Identifier
}