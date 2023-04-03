package com.dabba.birthdaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dabba.birthdaycard.ui.theme.BirthdayCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdayCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BirthdayGreetingWithImage(name = "Juno", from = "Girish")
                }
            }
        }
    }
}

@Composable
fun BirthdayGreeting(name: String, from: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Happy birthday, $name!",
            fontSize = 36.sp,
            modifier = Modifier.padding(
                top = 16.dp,
            ),
        )
        Text(
            text = "- $from",
            fontSize = 18.sp,
            modifier = Modifier.padding(
                top = 16.dp,
                end = 16.dp,
            ).align(alignment = End),
        )
    }
}

@Composable
fun BirthdayGreetingWithImage(name: String, from: String) {
    Box {
        Image(
            painter = painterResource(R.drawable.birthday),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        BirthdayGreeting(name, from)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BirthdayCardTheme {
        BirthdayGreetingWithImage(name = "Juno", from = "Girish")
    }
}