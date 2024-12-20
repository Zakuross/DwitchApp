package com.example.dwitchapp.model

import com.squareup.moshi.JsonClass
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@JsonClass(generateAdapter = true)
data class Order (
    val id: Int,
    val documentId: String?,
    val placedAt: Date?,
    val receivedAt: Date?,
    val cookMessage: String?,
    val price: Int,
    val progress: Int,
    val createdAt: Date,
    val updatedAt: Date,
    val publishedAt: Date,

    val ingredients: List<Ingredient>,

    val users_permissions_user: UsersPermissionsUser?,
    val store: Store?
)

fun Date.dateTimeToString(): Pair<String, String>? { //Pair permet d afficher au choix une des 2 valeurs
    return try {
        val dateFormat = SimpleDateFormat("dd/HH/yyyy", Locale.FRANCE)
        val hourFormat = SimpleDateFormat("HH:mm", Locale.FRANCE)
        return Pair(dateFormat.format(this), hourFormat.format(this))
    } catch (e: Exception) {
        Timber.d(e.toString())
        null
    }
}