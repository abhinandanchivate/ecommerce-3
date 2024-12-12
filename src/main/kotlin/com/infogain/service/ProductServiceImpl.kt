package com.infogain.service

import com.infogain.models.Product
import com.infogain.repo.ProductRepository
import com.infogain.tables.ProductsTable
import org.jetbrains.exposed.sql.ResultRow

class ProductServiceImpl(private val productRepository: ProductRepository): ProductService {
    override  fun getAllProduct(): List<Product> {
        return productRepository.getAllProduct().map {
            Product(
                id = it[ProductsTable.id],
                name = it[ProductsTable.name],
                description = it[ProductsTable.description],
                categoryId = it[ProductsTable.categoryId],
                price = it[ProductsTable.price],
                stock = it[ProductsTable.stock],
                imageUrl = it[ProductsTable.imageUrl],
                createdAt = it[ProductsTable.createdAt],
                updatedAt = it[ProductsTable.updatedAt]
            )
        }
    }

    override fun createProduct(product: Product): String {
       return productRepository.createProduct(product)
    }

}