package com.infogain.repo

import com.infogain.extension.toResponsePayload
import com.infogain.models.User
import com.infogain.responsepayload.UserResponsePayload
import com.infogain.tables.UsersTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.insert

class UserRepositoryImpl : UserRepository {
    override fun getAllUsers(): List<User> = transaction {
        UsersTable.selectAll().map {
            it.toUser()
        }
    }

    // Function to get user by ID
    override fun getUserById(id: Int): UserResponsePayload? = transaction {
        UsersTable.select(UsersTable.id eq id).map { it.toUser().toResponsePayload() }.singleOrNull()
    }
    private fun ResultRow.toUser() = User(
        id = this[UsersTable.id],
        name = this[UsersTable.name],
        email = this[UsersTable.email],
        password = this[UsersTable.password],
        role = this[UsersTable.role],
        createdAt = this[UsersTable.createdAt],
        updatedAt = this[UsersTable.updatedAt]
    )

    override fun createuser(user: User): UserResponsePayload = transaction {
        val userId = UsersTable.insert {
            it[name] = user.name
            it[email] = user.email
            it[password] = user.password
            it[role] = user.role
            it[createdAt] = System.currentTimeMillis().toString()
            it[updatedAt] = System.currentTimeMillis().toString()
        }

        // Retrieve the created user and return the response payload
        getUserById(userId.toString().toInt()) ?: throw Exception("User creation failed.")    }}