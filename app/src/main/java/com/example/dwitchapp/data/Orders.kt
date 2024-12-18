package com.example.dwitchapp.data

import android.icu.text.SimpleDateFormat
import com.example.dwitchapp.model.Ingredient
import com.example.dwitchapp.model.IngredientKind
import com.example.dwitchapp.model.Order
import com.example.dwitchapp.model.Store
import com.example.dwitchapp.model.UsersPermissionsUser
import java.util.Date

val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")

fun parseDate(dateStr: String): Date {
    return dateFormat.parse(dateStr)
}

val mockOrders = listOf(
    Order(
        id = 1,
        documentID = "doc123",
        placedAt = parseDate("2024-12-16T12:00:00"),
        receivedAt = parseDate("2024-12-16T12:45:00"),
        cookMessage = "Bien cuit, avec supplément de sauce",
        price = 1500L,
        progress = 70L,
        ingredients = listOf(
            Ingredient(
                id = 1,
                documentID = "ingredient1",
                name = "Tomates",
                description = "Tomates fraîches",
                isVegan = true,
                isSpicy = false,
                kind = IngredientKind.TOPPING
            ),
            Ingredient(
                id = 2,
                documentID = "ingredient2",
                name = "Poulet",
                description = "Poulet rôti",
                isVegan = false,
                isSpicy = true,
                kind = IngredientKind.MAIN
            ),
            Ingredient(
                id = 3,
                documentID = "ingredient2",
                name = "Pain",
                description = "Pain aux graines",
                isVegan = false,
                isSpicy = true,
                kind = IngredientKind.BREAD
            ),
            Ingredient(
                id = 4,
                documentID = "ingredient2",
                name = "Mayonnaise",
                description = "Mayonnaire",
                isVegan = false,
                isSpicy = true,
                kind = IngredientKind.SAUCE
            ),
            Ingredient(
                id = 5,
                documentID = "ingredient2",
                name = "Cornichons",
                description = "Cornichons",
                isVegan = false,
                isSpicy = true,
                kind = IngredientKind.TOPPING
            )
        ),
        usersPermissionsUser = UsersPermissionsUser(
            id = 101,
            documentID = "user101",
            username = "johndoe",
            email = "johndoe@example.com",
            provider = "email",
            confirmed = true,
            blocked = false
        ),
        store = Store(
            id = 10,
            documentID = "store10",
            name = "Restaurant Paris",
            isOpen = true,
            city = "Paris",
            zipCode = "75001"
        )
    ),
    Order(
        id = 2,
        documentID = "doc124",
        placedAt = parseDate("2024-12-16T13:00:00"),
        receivedAt = parseDate("2024-12-16T13:30:00"),
        cookMessage = "Avec sauce piquante",
        price = 1200L,
        progress = 50L,
        ingredients = listOf(
            Ingredient(
                id = 3,
                documentID = "ingredient3",
                name = "Avocat",
                description = "Avocat frais et crémeux",
                isVegan = true,
                isSpicy = false,
                kind = IngredientKind.TOPPING
            ),
            Ingredient(
                id = 4,
                documentID = "ingredient4",
                name = "Bœuf",
                description = "Bœuf tendre",
                isVegan = false,
                isSpicy = true,
                kind = IngredientKind.MAIN
            )
        ),
        usersPermissionsUser = UsersPermissionsUser(
            id = 102,
            documentID = "user102",
            username = "janedoe",
            email = "janedoe@example.com",
            provider = "google",
            confirmed = true,
            blocked = false
        ),
        store = Store(
            id = 11,
            documentID = "store11",
            name = "Restaurant Lyon",
            isOpen = false,
            city = "Lyon",
            zipCode = "69001"
        )
    ),
    Order(
        id = 3,
        documentID = "doc125",
        placedAt = parseDate("2024-12-16T14:00:00"),
        receivedAt = parseDate("2024-12-16T14:20:00"),
        cookMessage = "Cuit à point, sans oignons",
        price = 1800L,
        progress = 90L,
        ingredients = listOf(
            Ingredient(
                id = 5,
                documentID = "ingredient5",
                name = "Salade",
                description = "Salade fraîchement coupée",
                isVegan = true,
                isSpicy = false,
                kind = IngredientKind.TOPPING
            ),
            Ingredient(
                id = 6,
                documentID = "ingredient6",
                name = "Fromage",
                description = "Fromage cheddar",
                isVegan = false,
                isSpicy = false,
                kind = IngredientKind.TOPPING
            )
        ),
        usersPermissionsUser = UsersPermissionsUser(
            id = 103,
            documentID = "user103",
            username = "michael",
            email = "michael@example.com",
            provider = "facebook",
            confirmed = true,
            blocked = false
        ),
        store = Store(
            id = 12,
            documentID = "store12",
            name = "Restaurant Marseille",
            isOpen = true,
            city = "Marseille",
            zipCode = "13001"
        )
    ),
    Order(
        id = 4,
        documentID = "doc125",
        placedAt = parseDate("2024-12-16T14:00:00"),
        receivedAt = parseDate("2024-12-16T14:20:00"),
        cookMessage = "Cuit à point, sans oignons",
        price = 1800L,
        progress = 90L,
        ingredients = listOf(
            Ingredient(
                id = 14,
                documentID = "ingredient5",
                name = "Salade",
                description = "Salade fraîchement coupée",
                isVegan = true,
                isSpicy = false,
                kind = IngredientKind.TOPPING
            ),
            Ingredient(
                id = 29,
                documentID = "ingredient6",
                name = "Fromage",
                description = "Fromage cheddar",
                isVegan = false,
                isSpicy = false,
                kind = IngredientKind.TOPPING
            )
        ),
        usersPermissionsUser = UsersPermissionsUser(
            id = 104,
            documentID = "user103",
            username = "michael",
            email = "michael@example.com",
            provider = "facebook",
            confirmed = true,
            blocked = false
        ),
        store = Store(
            id = 12,
            documentID = "store12",
            name = "Restaurant Marseille",
            isOpen = true,
            city = "Marseille",
            zipCode = "13001"
        )
    ),
    Order(
        id = 5,
        documentID = "doc125",
        placedAt = parseDate("2024-12-16T14:00:00"),
        receivedAt = parseDate("2024-12-16T14:20:00"),
        cookMessage = "Cuit à point, sans oignons",
        price = 1800L,
        progress = 90L,
        ingredients = listOf(
            Ingredient(
                id = 42,
                documentID = "ingredient5",
                name = "Agneau",
                description = "filet d'agneau",
                isVegan = true,
                isSpicy = false,
                kind = IngredientKind.MAIN
            ),
            Ingredient(
                id = 6,
                documentID = "ingredient6",
                name = "Fromage",
                description = "Fromage cheddar",
                isVegan = false,
                isSpicy = false,
                kind = IngredientKind.TOPPING
            ),
            Ingredient(
                id = 6,
                documentID = "ingredient6",
                name = "Barbecue",
                description = "Sauce barbecue",
                isVegan = false,
                isSpicy = false,
                kind = IngredientKind.SAUCE
            )
        ),
        usersPermissionsUser = UsersPermissionsUser(
            id = 105,
            documentID = "user103",
            username = "michael",
            email = "michael@example.com",
            provider = "facebook",
            confirmed = true,
            blocked = false
        ),
        store = Store(
            id = 12,
            documentID = "store12",
            name = "Restaurant Marseille",
            isOpen = true,
            city = "Marseille",
            zipCode = "13001"
        )
    )
)