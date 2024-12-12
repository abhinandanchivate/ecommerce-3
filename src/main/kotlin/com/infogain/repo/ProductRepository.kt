package com.infogain.repo

import com.infogain.models.Product
import com.infogain.models.User
import org.jetbrains.exposed.sql.ResultRow

interface ProductRepository {

    fun getAllProduct(): List<ResultRow>
    // List<Object>
    // while(rs.next) ==> rs ==> particular reffered row

    fun createProduct(product: Product): String

}