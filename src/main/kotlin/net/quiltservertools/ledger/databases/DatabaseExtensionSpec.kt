package net.quiltservertools.ledger.databases

import com.uchuhimo.konf.ConfigSpec

object DatabaseExtensionSpec : ConfigSpec("database_extensions") {
    val database by required<Databases>("database")
    val userName by optional("root", "username")
    val password by optional("", "password")
    val url by optional("localhost", "url")
    val properties by optional(mapOf<String, String>(), "properties")
    val maxPoolSize by optional(10, "maxPoolSize")
    val connectionTimeout by optional(60000L, "connectionTimeout")
}
