package com.infogain

import com.infogain.config.DatabaseConfig
import com.infogain.config.DatabaseConfig2
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.routing.route
import io.ktor.server.routing.routing
import org.jetbrains.exposed.sql.Database
import rootRoutes

fun main(args: Array<String>) {
    io.ktor.server.tomcat.jakarta.EngineMain.main(args)
}

fun Application.module() {
    // Initialize the database connection

    DatabaseConfig2.init()

    // Install Content Negotiation with JSON serialization
    install(ContentNegotiation) {
        json()
    }

    // Define routing for the application
    routing {
        rootRoutes()  // Assuming rootRoutes() defines your API routes
    }
}
