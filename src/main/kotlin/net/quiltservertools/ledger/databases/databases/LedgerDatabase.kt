package net.quiltservertools.ledger.databases.databases

import net.minecraft.util.Identifier
import java.nio.file.Path
import javax.sql.DataSource

interface LedgerDatabase {
    fun getDataSource(savePath: Path): DataSource
    fun getDatabaseIdentifier(): Identifier
}