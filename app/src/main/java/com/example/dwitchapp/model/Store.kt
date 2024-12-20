package com.example.dwitchapp.model

import com.squareup.moshi.JsonClass
import java.util.Date

@JsonClass(generateAdapter = true)
data class Store (
    val id: Long,
    val documentId: String,
    val name: String,
    val isOpen: Boolean,
    val city: String,
    val zipCode: String,
    val createdAt: Date,
    val updatedAt: Date,
    val publishedAt: Date
)