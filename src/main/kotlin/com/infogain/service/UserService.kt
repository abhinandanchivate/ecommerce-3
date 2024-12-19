package com.infogain.service

import com.infogain.models.User
import com.infogain.responsepayload.UserResponsePayload
import org.jetbrains.exposed.sql.ResultRow

interface UserService {
    fun getAllUsers(): List<User>
    // List<Object>
    // while(rs.next) ==> rs ==> particular reffered row

    fun createUser(user: User): UserResponsePayload
    fun getUserById(i: Int): UserResponsePayload

}