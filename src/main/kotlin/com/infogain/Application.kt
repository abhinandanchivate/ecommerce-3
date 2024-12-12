package com.infogain

import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.tomcat.jakarta.EngineMain.main(args)
}

fun Application.module() {
    configureRouting()
}
