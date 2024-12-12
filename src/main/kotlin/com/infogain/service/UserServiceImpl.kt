package com.infogain.service

import com.infogain.models.User
import com.infogain.repo.UserRepository
import com.infogain.tables.UsersTable
import org.jetbrains.exposed.sql.ResultRow

class UserServiceImpl(private val userRepository: UserRepository) : UserService {
    override fun getAllUsers(): List<User> {
        return userRepository.getAllUsers().map {
            User(
                id = it[UsersTable .id],
                name = it[UsersTable.name],
                email = it[UsersTable.email],
                password = it[UsersTable.password],
                role = it[UsersTable.role],
                createdAt = it[UsersTable.createdAt],
                updatedAt = it[UsersTable.updatedAt]
            )
        }
    }

    override fun createuser(user: User): Int {
        return userRepository.createuser(user)
    }
}