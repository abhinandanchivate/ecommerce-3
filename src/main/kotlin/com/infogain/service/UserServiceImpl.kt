package com.infogain.service

import com.infogain.extension.toResponsePayload
import com.infogain.models.User
import com.infogain.repo.UserRepository
import com.infogain.responsepayload.UserResponsePayload
import com.infogain.tables.UsersTable
import org.jetbrains.exposed.sql.ResultRow

class UserServiceImpl(private val userRepository: UserRepository) : UserService {
    override fun getAllUsers(): List<User> =userRepository.getAllUsers()
    // lambada expressions with direct return
    // ()-> return expression.


    override fun createUser(user: User): Int =userRepository.createuser(user)
    override fun getUserById(i: Int): UserResponsePayload = userRepository.getUserById(i)!!.toResponsePayload()


}