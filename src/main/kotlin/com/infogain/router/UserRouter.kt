package com.infogain.router

// @RestController







import com.infogain.extension.toUser
import com.infogain.extension.toResponsePayload

import com.infogain.repo.UserRepository
import com.infogain.service.UserService
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import io.ktor.http.*

fun Route.userRoutes(userService: UserService) {
    route("/users") {
    }
}
