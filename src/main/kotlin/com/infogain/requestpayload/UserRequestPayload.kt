package com.infogain.requestpayload;

import kotlinx.serialization.Serializable

@Serializable
data class UserRequestPayload(
    val name: String,
    val email: String,
    val password: String,
    val role: String
)