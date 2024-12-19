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
import org.jetbrains.exposed.sql.transactions.transaction

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

        post {
            val requestPayload = call.receive<UserRequestPayload>()

            // If `createdAt` and `updatedAt` are generated, do it here:
            val currentTime = System.currentTimeMillis().toString()

            // Create the user object to pass to the repository
            val userToCreate = requestPayload.toUser(
                createdAt = currentTime,
                updatedAt = currentTime
            )

            // Call the repository to create the user
            val createdUser = userService.createUser(userToCreate)

            // Check if the user was created successfully
            if (createdUser != null) {
                // If createdUser is not null, respond with the created user details
                call.respond(HttpStatusCode.Created, createdUser)
            } else {
                // If createdUser is null, return an error response
                call.respond(HttpStatusCode.InternalServerError, "User creation failed.")
            }
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


















