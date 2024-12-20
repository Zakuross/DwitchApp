package com.example.dwitchapp.model


import androidx.compose.ui.graphics.Color
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.Date

@JsonClass(generateAdapter = true)
data class Ingredient (
    val id: Long,
    val documentId: String,
    val name: String,
    val description: String,
    val isVegan: Boolean? = null,
    val isSpicy: Boolean? = null,
//    val kind: String? = null  //remplacer par l'enum
    val kind: IngredientKind,
    val createdAt: Date,
    val updatedAt: Date,
    val publishedAt: Date
)

enum class IngredientKind {
    @Json(name = "bread") BREAD,
    @Json(name = "main") MAIN,
    @Json(name = "topping") TOPPING,
    @Json(name = "sauce") SAUCE,
}


fun getColorForIngredientKind(kind: IngredientKind): androidx.compose.ui.graphics.Color {
    return when (kind) {
        IngredientKind.BREAD -> Color(0xFF87CEEB) // Light Blue
        IngredientKind.MAIN -> Color(0xFF3CB371) // Medium Sea Green
        IngredientKind.TOPPING -> Color(0xFF8A2BE2) // Blue Violet
        IngredientKind.SAUCE -> Color(0xFF00CED1) // Dark Turquoise
    }
}

fun getEmojiForIngredientKind(kind: IngredientKind): String {
    return when (kind) {
        IngredientKind.BREAD -> "🍞"
        IngredientKind.MAIN -> "🍔"
        IngredientKind.TOPPING -> "🧀"
        IngredientKind.SAUCE -> "🍲"
    }
}