package me.tadebois.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
                    QuadrantApp()
                }
            }
        }
    }
}

@Composable
fun QuadrantApp() {
    Row(Modifier.fillMaxWidth()) {
        Column(Modifier.weight(1f)) {
            Quadrant(
                title = stringResource(R.string.text_composable_title),
                body = stringResource(R.string.text_composable_body),
                colorResource(id = R.color.quadrant_one),
                modifier = Modifier.weight(1f)
            )
            Quadrant(
                title = stringResource(R.string.row_composable_title),
                body = stringResource(R.string.row_composable_body),
                colorResource(id = R.color.quadrant_three),
                modifier = Modifier.weight(1f)
            )
        }
        Column(Modifier.weight(1f)) {
            Quadrant(
                title = stringResource(R.string.image_composable_title),
                body = stringResource(R.string.image_composable_body),
                colorResource(id = R.color.quadrant_two),
                modifier = Modifier.weight(1f)
            )
            Quadrant(
                title = stringResource(R.string.column_composable_title),
                body = stringResource(R.string.column_composable_body),
                colorResource(id = R.color.quadrant_four),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun QuadrantAppPreview() {
    ComposeQuadrantTheme {
        QuadrantApp()
    }
}

@Composable
fun Quadrant(
    title: String,
    body: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
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
