package com.infogain.router

// @RestController







import com.infogain.extension.toUser
import com.infogain.extension.toResponsePayload

import com.infogain.repo.UserRepository
import com.infogain.repo.UserRepositoryImpl
import com.infogain.requestpayload.UserRequestPayload
import com.infogain.responsepayload.UserResponsePayload
import com.infogain.service.UserService
import com.infogain.service.UserServiceImpl
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import io.ktor.http.*

fun Route.userRoutes() {

    // Repo and Service will have singleton impl.

    // we need repo object
    val userRepository: UserRepository= UserRepositoryImpl()
    // we need service object
    val userService: UserService = UserServiceImpl(userRepository)

    route("/users") {

        // @GetMapping
        // api : /users
        // method : get
        // descript ion : gettign all the data

        get {
            val users = userService.getAllUsers()

            if (users.isEmpty()) {
                call.respond(HttpStatusCode.NoContent)
            } else
                call.respond(HttpStatusCode.OK, users)
        }

        // @GetMapping
        // api : /users/{id}
        // method : get
        // descript ion : gettign provided id's details

        get("{id}") {
            val id = call.parameters["id"]?.toIntOrNull()
            if (id == null) {
                call.respond(HttpStatusCode.BadRequest, "Invalid ID")
                return@get
            }
            val user = userService.getUserById(id)
            if (user == null) {
                call.respond(HttpStatusCode.NotFound, "User not found")
            } else {
                call.respond(user)
            }
        }

        fun createUser(request: UserRequestPayload): UserResponsePayload = transaction {
            // we need User model object
            val userObject = request.toUser()

             userService.createUser(userObject)

        }

//        fun updateUser(id: Int, request: UserRequestPayload): UserResponsePayload? = transaction {
//            val updatedRows = UserTable.update({ UserTable.id eq id }) {
//                it[name] = request.name
//                it[email] = request.email
//                it[password] = request.password
//                it[role] = request.role
//                it[updatedAt] = System.currentTimeMillis().toString()
//            }
//            if (updatedRows > 0) getUserById(id) else null
//        }
//
//        fun deleteUser(id: Int): Boolean = transaction {
//            UserTable.deleteWhere { UserTable.id eq id } > 0
//        }

    }

    }


















