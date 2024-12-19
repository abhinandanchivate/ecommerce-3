package com.infogain.config

import com.infogain.tables.ProductsTable
import com.infogain.tables.UsersTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import net.mamoe.yamlkt.Yaml
import kotlinx.serialization.decodeFromString
import java.io.InputStream

// Define data classes for deserialization
@kotlinx.serialization.Serializable
data class DatabaseConfig(
    val jdbcUrl: String,
    val username: String,
    val password: String,
    val driverClassName: String
)

@kotlinx.serialization.Serializable
data class AppConfig(val database: DatabaseConfig)

object DatabaseConfig2 {
    private lateinit var dbUrl: String
    private lateinit var dbUser: String
    private lateinit var dbPassword: String
    private lateinit var dbDriver: String

    fun init() {
        // First, read the YAML configuration
       // readYAML()

        // Connect to the database using the loaded configuration
        dbConnect()

        // Run any database schema creation or migration tasks
        transaction {
            SchemaUtils.create(UsersTable)
            SchemaUtils.create(ProductsTable)
        }
    }

    /**
     * Reads the YAML configuration file and loads database settings.
     */
    fun readYAML() {
        val inputStream: InputStream = this::class.java.getResourceAsStream("/application.yaml")
            ?: throw IllegalArgumentException("application.yaml not found")

        // Create an instance of the YAML parser
        val yaml = Yaml()

        // Deserialize the YAML file into the AppConfig data class
        val yamlString = inputStream.bufferedReader().use { it.readText() } // Convert InputStream to String
        val config: AppConfig = yaml.decodeFromString(yamlString)

        // Extract the database section from the AppConfig
        val dbConfig = config.database
        dbUrl = dbConfig.jdbcUrl
        dbUser = dbConfig.username
        dbPassword = dbConfig.password
        dbDriver = dbConfig.driverClassName
    }

    /**
     * Connects to the database using the loaded configuration.
     */
    fun dbConnect() {
        Database.connect(
            url = "jdbc:postgresql://localhost:5440/test",
            driver = "org.postgresql.Driver",
            user = "root",
            password = "root"
        )
    }
}
