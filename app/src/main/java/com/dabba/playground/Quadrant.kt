package com.dabba.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dabba.playground.ui.theme.PlaygroundTheme

class Quadrant : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaygroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    QuadrantView()
                }
            }
        }
    }
}

@Composable
fun QuadrantView() {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Row (
            modifier = Modifier.weight(1f),
        ) {
            Cell(
                titleStringId = R.string.text_composable,
                contentStringId = R.string.text_composable_content,
                color = Color.Green,
                modifier = Modifier.weight(1f),
            )
            Cell(
                titleStringId = R.string.image_composable,
                contentStringId = R.string.image_composable_content,
                color = Color.Yellow,
                modifier = Modifier.weight(1f),
            )
        }
        Row (
            modifier = Modifier.weight(1f),
        ) {
            Cell(
                titleStringId = R.string.row_composable,
                contentStringId = R.string.row_composable_content,
                color = Color.Cyan,
                modifier = Modifier.weight(1f),
            )
            Cell(
                titleStringId = R.string.column_composable,
                contentStringId = R.string.column_composable_content,
                color = Color.LightGray,
                modifier = Modifier.weight(1f),
            )
        }
    }
}

@Composable
fun Cell(
    titleStringId: Int,
    contentStringId: Int,
    color: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(id = titleStringId),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = stringResource(id = contentStringId),
            textAlign = TextAlign.Justify,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun QuadrantDefaultPreview() {
    PlaygroundTheme {
        QuadrantView()
    }
}