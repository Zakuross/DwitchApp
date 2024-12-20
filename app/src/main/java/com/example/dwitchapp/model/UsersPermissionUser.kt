package com.example.dwitchapp.model

import com.squareup.moshi.JsonClass
import java.util.Date

@JsonClass(generateAdapter = true)
data class UsersPermissionsUser (
    val id: Long,
    val documentId: String,
    val username: String,
    val email: String,
    val provider: String,
    val confirmed: Boolean,
    val blocked: Boolean,
    val createdAt: Date,
    val updatedAt: Date,
    val publishedAt: Date
)