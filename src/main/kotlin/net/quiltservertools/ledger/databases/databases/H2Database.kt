package net.quiltservertools.ledger.databases.databases

import net.quiltservertools.ledger.databases.LedgerDatabases
import org.h2.jdbcx.JdbcDataSource
import java.nio.file.Path
import javax.sql.DataSource
import kotlin.io.path.pathString

object H2Database : LedgerDatabase {
    override fun getDataSource(savePath: Path): DataSource = JdbcDataSource().apply {
        setURL("jdbc:h2:${savePath.pathString};MODE=MySQL")
    }

    override fun getDatabaseIdentifier() = LedgerDatabases.identifier("h2")
}
