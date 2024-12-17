package com.infogain.responsepayload

import kotlinx.serialization.Serializable

@Serializable
data class UserResponsePayload(
    val id: Int,
    val name: String,
    val email: String,
    val role: String,
    val createdAt: String,
    val updatedAt: String
)