# Ledger Databases

Adds support for MySQL and H2 databases in Ledger

## Use

## Common

For both MySQL and H2, you will need to place Ledger Databases in your mods folder along with Ledger 1.1.0 or newer

## H2

Add the following to the bottom of your Ledger config file:

```toml
[database_extensions]
database = "H2"
```

## MySQL

Add the following to the bottom of your Ledger config file:

```toml
[database_extensions]
database = "MYSQL"
url = ""
username = ""
password = ""
properties = []
```

`url`: Must be URL of database with `/<database_name>` appended. An example URL would be `localhost/ledger`. You can optionally add port information such as `localhost:3000/ledger`

## PostgreSQL

```toml
[database_extensions]
database = "MYSQL"
url = ""
username = ""
password = ""
properties = []
```

## Connector properties

For some databases, such as MySQL, you can provide properties to the database connector. For each property, add a string entry to the `properties` array.

```toml
properties = ["useJDBCCompliantTimezoneShift=true", "useLegacyDatetimeCode=false", "serverTimezone=UTC"]
```
