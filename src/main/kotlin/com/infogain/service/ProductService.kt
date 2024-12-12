package com.infogain.service

import com.infogain.models.Product
import org.jetbrains.exposed.sql.ResultRow

interface ProductService {
    fun getAllProduct(): List<Product>
    // List<Object>
    // while(rs.next) ==> rs ==> particular reffered row

    fun createProduct(product: Product): String
}