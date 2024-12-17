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
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
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
import com.example.dwitchapp.model.getColorForIngredientKind
import com.example.dwitchapp.ui.theme.DwitchAppTheme
import java.util.Date
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            DwitchAppTheme {
                GreetingPreview()
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

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DwitchAppTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        Text("Top App Bar")
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
                                    Text(text = (ingredient.name) ?: "")
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