package com.infogain.service

import com.infogain.models.User
import org.jetbrains.exposed.sql.ResultRow

interface UserService {
    fun getAllUsers(): List<User>
    // List<Object>
    // while(rs.next) ==> rs ==> particular reffered row

    fun createuser(user: User): Int
}