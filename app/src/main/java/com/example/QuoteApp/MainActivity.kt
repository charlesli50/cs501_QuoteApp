package com.example.QuoteApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.text.TextStyle
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
                        "Do or Do Not, \nthere is not try",
                        "Opportunities Don't Happen. \nYou Create Them.",
                        "If you change your mind, \nyou change your life.",
                        "Either you run your day, \nor your day runs you."
                        )

                    Greeting(
                        quotes = quotesArray,
                        modifier = Modifier.fillMaxSize()
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

    Column(modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            text = "${quotes[num % quotes.size]}",
            modifier =Modifier
                .wrapContentWidth()
                .wrapContentHeight(align = Alignment.CenterVertically),
//            background = Color.Black,
//            textAlign = TextAlign.Center

            style = TextStyle(
                fontWeight = FontWeight.Bold,
                color = Color.Cyan,
                background = Color.Black,
                fontSize = 36.sp,
                textAlign = TextAlign.Center
            )
        )

        Button(onClick = { num += 1 }) {
            Text("Click Me")
        }
    }
}

val quotesArray = arrayOf(
    "Do or Do Not, \nthere is not try",
//    "Opportunities Don't Happen. You Create Them.",
    "If you change your mind, \nyou change your life.",
    "Either you run your day, \nor your day runs you."
)

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuoteAppTheme {
        Greeting(quotesArray)
    }
}