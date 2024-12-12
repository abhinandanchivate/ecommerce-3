package com.infogain.repo

import com.infogain.models.Product
import com.infogain.tables.ProductsTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class ProductRepositoryImpl: ProductRepository {
    override fun getAllProduct(): List<ResultRow> = transaction {

           ProductsTable.selectAll().toList()
        }


    override fun createProduct(product: Product): String = transaction {
        ProductsTable.insert {
            it[id] = product.id
            it[name] = product.name
            it[description] = product.description
            it[categoryId] = product.categoryId
            it[price] = product.price
            it[stock] = product.stock
            it[imageUrl] = product.imageUrl
            it[createdAt] = product.createdAt
            it[updatedAt] = product.updatedAt
        }[ProductsTable.id]
    }
}