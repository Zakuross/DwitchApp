package com.example.dwitchapp

import android.icu.text.SimpleDateFormat
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dwitchapp.data.mockOrders
import com.example.dwitchapp.model.Ingredient
import com.example.dwitchapp.model.IngredientKind
import com.example.dwitchapp.model.Order
import com.example.dwitchapp.model.getColorForIngredientKind
import com.example.dwitchapp.model.getEmojiForIngredientKind
import com.example.dwitchapp.service.ApiClient
import com.example.dwitchapp.ui.theme.DwitchAppTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import timber.log.Timber
import java.util.Date
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            DwitchAppTheme {
//                GreetingPreview()
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
            }
        }
    }
}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

@Preview(showBackground = true)
@Composable
fun OrderScreen(){
    var orders by remember { mutableStateOf<List<Order>>(emptyList()) }
    var error by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        try {
            val token = "Bearer 49b70f996ffbb654be996f8604d118bfca7624ced27749df6f4fdcac30b7009da1ba63ef7d6b91c8ca814baf88955daba2804396ab3b8cd2c03b50a1f96ff330032d2fbc2238338b4f7e25bff9e852b002c26ecca02fbf1e8e261cf6e0cdb00c042e35b33f64dda3522c3178ba1edb22b9daba42b51c1c8355309fd475b5d92b"
            val response = withContext(Dispatchers.IO) {
                ApiClient.apiService.getOrders(token)
            }
            orders = response.data
        } catch (e: HttpException)  {
            Timber.d("Error Parcho: ${e.message}")
            error = e.message
        }

    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            if (error != null) {
                Text(text = "Error: $error", style = MaterialTheme.typography.bodyLarge)
            } else {
                orders.forEach { order ->
                    Text(text = "Order ID: ${order.id}", style = MaterialTheme.typography.bodyLarge)
                    // Ajoutez d'autres informations sur la commande si nécessaire
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DwitchAppTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFF007BFF),
//                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = Color(0xFFffffff),
                    ),
                    title = {
                        Row (
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            IconButton(onClick =  { /* Handle Navigation */ }) {
                                Icon(
                                    imageVector = Icons.Default.ArrowBack,
                                    contentDescription = "Back"

                                )
                            }
                            Spacer(modifier = Modifier.weight(0.5f))
                            Text("Mes Commandes")
                            Spacer(modifier = Modifier.weight(1f))

                        }
                    },
                    actions = {
                            IconButton(onClick = { /* Handle Search */ }) {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "Search"
                                )
                            }
                            IconButton(onClick = { /* Handle Navigation */ }) {
                                Icon(
                                    painter = painterResource(R.drawable.baseline_add_shopping_cart_24),
                                    contentDescription = "Orders"
                                )
                            }

                    }
                )
            },
        ) { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                items(mockOrders) { order ->
                    Card {

                        Row(
                            modifier = Modifier
                                .fillMaxSize()
//                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("le " + order.placedAt?.dateTimeToString()?.first)
                            Text(" à " + order.placedAt?.dateTimeToString()?.second)
                            Spacer(modifier = Modifier.width(150.dp))
                            Text(text = order.price.toString() + "€")

                        }

                        Text(text = order.cookMessage ?: "")
                        // Utiliser LazyRow pour afficher les ingrédients
                        LazyRow(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            item {
                                Text("Ingredients : ")
                            }
                            items(order.ingredients ?: emptyList()) { ingredient ->
                                val color = getColorForIngredientKind(ingredient.kind ?: IngredientKind.BREAD)
                                val emoji = getEmojiForIngredientKind(ingredient.kind ?: IngredientKind.BREAD)

                                Column (
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(8.dp))
                                        .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                                        .background(color)
//                                        .drawBehind {
//                                            drawRect(color = Color.Red)
////                                            drawRect(color = Color.LightGray)
//                                        }
                                        .padding(3.dp)
                                ){
                                    Text(text = (emoji + " " + (ingredient.name)) ?: "")
//                                    Text(text = ingredient.kind?.name ?: "")
                                }
                            }
                        }
                        Row {
                            Icon(
                                painter = painterResource(R.drawable.baseline_storefront_24),
                                contentDescription = "Store Icon"
                            )
                            Text(text = order.store?.name ?: "")
                        }
                        Row {
                            LinearProgressIndicator(
                                progress = {(order.progress?.toFloat() ?: 0F)/100F}
                            )
                        }
                    }

                }
            }
        }

    }
}



//fun items(items: List<Ingredient>?, itemContent: @Composable() (LazyItemScope.(item: Ingredient) -> Unit)) {
//    TODO("Not yet implemented")
//}


@Composable
fun ScrollContent(innerPadding: PaddingValues) {
    TODO("Not yet implemented")
}

fun Date.dateTimeToString() : Pair<String, String>? {
    return try {
        val dateFormat = SimpleDateFormat("dd/HH/yyyy", Locale.FRANCE)
        val hourFormat = SimpleDateFormat("HH:mm", Locale.FRANCE)
        return Pair(dateFormat.format(this), hourFormat.format(this))
    } catch (e: Exception) {
        timber.log.Timber.d(e.toString())
        null
    }
}