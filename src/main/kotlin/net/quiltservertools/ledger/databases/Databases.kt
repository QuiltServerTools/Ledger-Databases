package net.quiltservertools.ledger.databases

import net.quiltservertools.ledger.databases.databases.H2Database
import net.quiltservertools.ledger.databases.databases.LedgerDatabase
import net.quiltservertools.ledger.databases.databases.MySQL
import net.quiltservertools.ledger.databases.databases.MariaDB
import net.quiltservertools.ledger.databases.databases.PostgreSQL
import net.quiltservertools.ledger.databases.databases.SQLite


enum class Databases(val database: LedgerDatabase) {
    MYSQL(MySQL),
    H2(H2Database),
    POSTGRESQL(PostgreSQL),
    SQLITE(SQLite),
    MARIADB(MariaDB)
}
