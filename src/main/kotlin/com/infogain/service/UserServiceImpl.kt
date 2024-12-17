package com.infogain.service

import com.infogain.models.User
import com.infogain.repo.UserRepository
import com.infogain.tables.UsersTable
import org.jetbrains.exposed.sql.ResultRow

class UserServiceImpl(private val userRepository: UserRepository) : UserService {
    override fun getAllUsers(): List<User> =userRepository.getAllUsers()
    // lambada expressions with direct return
    // ()-> return expression.


    override fun createUser(user: User): Int =userRepository.createuser(user)


}