package com.example.QuoteApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.verticalArrangement
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.QuoteApp.ui.theme.QuoteAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuoteAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val quotesArray = arrayOf(
                        "Do or Do Not, there is not try",
                        "Opportunities Don't Happen. You Create Them.",
                        "If you can change your mind, you can change your life.",
                        "Either you run your day, or your day runs you."
                        )

                    Greeting(
                        quotes = quotesArray,
                        modifier = Modifier.padding(innerPadding),
//                        verticalArrangement = Alignment.CenterVertically
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(quotes: Array<String>, modifier: Modifier = Modifier) {

    var num by remember { mutableStateOf(0)}

    Column(modifier = modifier) {

        Text(
            text = "${quotes[num % quotes.size]}",
//            modifier =
        )

        Button(onClick = { num += 1 }) {
            Text("Click Me")
        }
    }

//    Button(onClick = { num += 1 }) {
//        Text("Click Me")
//    }
//
//    Text(
//        text = "${quotes[num%4]} \n $num",
//        modifier = modifier
//    )
}

val quotesArray = arrayOf(
    "Do or Do Not, there is not try",
    "Opportunities Don't Happen. You Create Them.",
    "If you can change your mind, you can change your life.",
    "Either you run your day, or your day runs you."
)

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuoteAppTheme {
        Greeting(quotesArray)
    }
}