package com.infogain.models

data class Product(
    val id: String,
    val name: String,
    val description: String,
    val categoryId: String,
    val price: Double,
    val stock: Int,
    val imageUrl: String?,
    val createdAt: String,
    val updatedAt: String
)
