package net.quiltservertools.ledger.databases.databases

import com.github.quiltservertools.ledger.Ledger
import org.sqlite.SQLiteDataSource
import java.nio.file.Path

object SQLite : LedgerDatabase {
    override fun getDataSource(savePath: Path) = SQLiteDataSource().apply {
        url = "jdbc:sqlite:$savePath"
    }

    override fun getDatabaseIdentifier() = Ledger.identifier(Ledger.DEFAULT_DATABASE)
}
