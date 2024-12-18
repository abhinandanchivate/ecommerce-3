package com.infogain.repo

import com.infogain.models.User
import com.infogain.responsepayload.UserResponsePayload
import org.jetbrains.exposed.sql.ResultRow

interface UserRepository {

    fun getAllUsers(): List<User>
    // List<Object>
    // while(rs.next) ==> rs ==> particular reffered row
    fun getUserById(i: Int): User?
    fun createuser(user: User): Int

}