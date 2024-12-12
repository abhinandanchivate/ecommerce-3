package com.infogain.repo

import com.infogain.models.User
import org.jetbrains.exposed.sql.ResultRow

interface UserRepository {

    fun getAllUsers(): List<ResultRow>
    // List<Object>
    // while(rs.next) ==> rs ==> particular reffered row

    fun createuser(user: User): Int

}