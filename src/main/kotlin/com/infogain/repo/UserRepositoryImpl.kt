package com.infogain.repo

import com.infogain.models.User
import com.infogain.tables.UsersTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class UserRepositoryImpl : UserRepository {
    override fun getAllUsers(): List<ResultRow> =
        transaction {
        UsersTable.selectAll().toList()
    }

    override fun createuser(user: User):Int = transaction{
        UsersTable.insert { it[name] = user.name
        it[email] = user.email
        it[password] = user.password
        it[role] = user.role
        it[createdAt] = user.createdAt
        it[updatedAt] = user.updatedAt
        }[UsersTable.id]
    }
}