package net.quiltservertools.ledger.databases

import com.github.quiltservertools.ledger.Ledger
import com.github.quiltservertools.ledger.api.DatabaseExtension
import com.uchuhimo.konf.ConfigSpec
import net.minecraft.util.Identifier
import java.nio.file.Path
import javax.sql.DataSource

class LedgerDatabaseExtension : DatabaseExtension {
    override fun getConfigSpecs(): List<ConfigSpec> = listOf(DatabaseExtensionSpec)

    override fun getDataSource(savePath: Path): DataSource {
        return Ledger.config[DatabaseExtensionSpec.database].database.getDataSource(savePath)
    }

    override fun getIdentifier(): Identifier = 
        Ledger.config[DatabaseExtensionSpec.database].database.getDatabaseIdentifier()
}
