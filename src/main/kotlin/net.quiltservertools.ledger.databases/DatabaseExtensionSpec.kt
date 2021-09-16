package net.quiltservertools.ledger.databases

import com.github.quiltservertools.libs.com.uchuhimo.konf.ConfigSpec

object DatabaseExtensionSpec : ConfigSpec("database_extensions") {
    val h2 by optional(false, "h2")
    val mySql by optional(false, "mysql")
    val userName by optional("root", "username")
    val password by optional("", "password")
    val url by optional("localhost", "url")
}