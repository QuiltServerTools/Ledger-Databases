package net.quiltservertools.ledger.databases

import net.quiltservertools.ledger.databases.databases.*

enum class Databases(val database: LedgerDatabase) {
    SQLITE(SQLite),
    MYSQL(MySQL),
    H2(H2Database),
    POSTGRESQL(PostgreSQL)
}