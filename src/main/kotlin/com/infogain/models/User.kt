package com.infogain.models

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val password: String,
    val role: String,
    val createdAt: String,
    val updatedAt: String
)

