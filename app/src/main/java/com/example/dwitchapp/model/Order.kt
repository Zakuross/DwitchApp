package com.example.dwitchapp.model

import java.util.Date

data class Order(
    val id: Long? = null,
    val documentID: String? = null,
    val placedAt: Date? = null,
    val receivedAt: Date? = null,
    val cookMessage: String? = null,
    val price: Long? = null,
    val progress: Long? = null,
    val ingredients: List<Ingredient>? = null,
    val usersPermissionsUser: UsersPermissionsUser? = null,
    val store: Store? = null
)