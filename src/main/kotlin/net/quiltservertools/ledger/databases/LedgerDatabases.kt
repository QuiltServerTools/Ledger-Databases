package net.quiltservertools.ledger.databases

import com.github.quiltservertools.ledger.api.ExtensionManager
import net.fabricmc.api.DedicatedServerModInitializer
import net.minecraft.util.Identifier

const val MOD_ID = "ledger-databases"

object LedgerDatabases : DedicatedServerModInitializer {

    override fun onInitializeServer() {
        ExtensionManager.registerExtension(LedgerDatabaseExtension())
    }

    fun identifier(path: String) = Identifier(MOD_ID, path)
}