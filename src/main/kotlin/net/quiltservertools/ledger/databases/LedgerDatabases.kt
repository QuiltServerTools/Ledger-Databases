package net.quiltservertools.ledger.databases

import com.github.quiltservertools.ledger.api.ExtensionManager
import net.fabricmc.api.DedicatedServerModInitializer
import net.minecraft.resources.Identifier

const val MOD_ID = "ledger-databases"

object LedgerDatabases : DedicatedServerModInitializer {

    override fun onInitializeServer() {
        ExtensionManager.registerExtension(LedgerDatabaseExtension())
    }

    fun identifier(path: String): Identifier = Identifier.fromNamespaceAndPath(MOD_ID, path)
}