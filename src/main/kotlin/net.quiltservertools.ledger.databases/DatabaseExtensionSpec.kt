package net.quiltservertools.ledger.databases

import com.github.quiltservertools.libs.com.uchuhimo.konf.ConfigSpec

object DatabaseExtensionSpec : ConfigSpec("database_extensions") {
    val database by optional(Databases.SQLITE, "database")
    val userName by optional("root", "username")
    val password by optional("", "password")
    val url by optional("localhost", "url")
}