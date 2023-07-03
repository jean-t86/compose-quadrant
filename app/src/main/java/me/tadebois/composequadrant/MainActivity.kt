package me.tadebois.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.tadebois.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Quadrant(
                        title = stringResource(R.string.text_composable_title),
                        body = stringResource(R.string.text_composable_body),
                        colorResource(id = R.color.quadrant_one)
                    )
                }
            }
        }
    }
}

@Composable
fun Quadrant(title: String, body: String, color: Color, modifier: Modifier = Modifier) {
    Surface(
        color = color,
        modifier = modifier
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = body,
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun QuadrantPreview() {
    ComposeQuadrantTheme {
        Quadrant(
            title = stringResource(R.string.text_composable_title),
            body = stringResource(R.string.text_composable_body),
            colorResource(id = R.color.quadrant_one)
        )
    }
}
