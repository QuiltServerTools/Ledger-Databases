package net.quiltservertools.ledger.databases

import com.github.quiltservertools.ledger.api.ExtensionManager
import net.fabricmc.api.DedicatedServerModInitializer

class LedgerDatabases : DedicatedServerModInitializer {
    override fun onInitializeServer() {
        ExtensionManager.registerExtension(LedgerDatabaseExtension())
    }
}