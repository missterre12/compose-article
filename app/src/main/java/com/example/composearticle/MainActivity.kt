package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArticleImage(
                        title = stringResource(R.string.article_title_text),
                        contentOne = stringResource(R.string.article_content_one_text),
                        contentTwo = stringResource(R.string.article_content_two_text),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ArticleContent(title: String, contentOne: String, contentTwo: String, modifier: Modifier = Modifier) {
    Column (
        modifier = Modifier
    ) {
        Spacer(modifier = Modifier.height(120.dp))
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = contentOne,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = contentTwo,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

@Composable
fun ArticleImage(title: String, contentOne: String, contentTwo: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        ArticleContent(
            title = title,
            contentOne = contentOne,
            contentTwo = contentTwo
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            ArticleImage(
                title = stringResource(R.string.article_title_text),
                contentOne = stringResource(R.string.article_content_one_text),
                contentTwo = stringResource(R.string.article_content_two_text),
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}