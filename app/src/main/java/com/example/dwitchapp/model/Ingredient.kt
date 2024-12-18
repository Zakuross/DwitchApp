package com.example.dwitchapp.model


import androidx.compose.ui.graphics.Color

data class Ingredient (
    val id: Long? = null,
    val documentID: String? = null,
    val name: String? = null,
    val description: String? = null,
    val isVegan: Boolean? = null,
    val isSpicy: Boolean? = null,
    val kind: IngredientKind? = null,

)

enum class IngredientKind {
    BREAD,
    MAIN,
    TOPPING,
    SAUCE
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