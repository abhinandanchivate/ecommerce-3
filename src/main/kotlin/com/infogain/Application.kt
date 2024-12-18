package com.infogain

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
// load our db
    com.infogain.config.DatabaseConfig.init()


    //
    install(ContentNegotiation){
        json()
    }

    // root Rou    have to hook it here. routing {

        rootRoutes()
    }
}
