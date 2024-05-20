package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.MyRoutineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyRoutineTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                    ) {
                        GreetingImage(
                            stringResource(R.string.name_text),
                            stringResource(R.string.signature_text)
                        )
                        GreetingText(
                            listOf(stringResource(R.string.signature_text), stringResource(R.string.list), stringResource(R.string.text_part)),
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun GreetingText(messages: List<String>, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        messages.forEach { message ->
            Text(
                text = message,
                fontSize = 24.sp,
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    Box(modifier) {
        Box(
            modifier = Modifier
                .size(200.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.unicaplogo2),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }

    Text(
        text = message,
        fontSize = 30.sp,
        lineHeight = 116.sp,
        textAlign = TextAlign.Start,
        modifier = Modifier.padding(top = 35.dp)
    )

    Box(modifier) {
        Box(
            modifier = Modifier
                .size(180.dp)
                .offset(x = 10.dp, y = 20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.foto),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
private fun MyRoutine() {
    MyRoutineTheme {
        GreetingImage(
            stringResource(R.string.name_text),
            stringResource(R.string.signature_text),
        )
    }
}
