package com.jcaique.dialetus.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.jcaique.dialetus.domain.models.Dialect
import com.jcaique.dialetus.presentation.ui.DialetusTheme

private val items by lazy {
    (0..10).map { index ->
        Dialect(
            slug = "slug-$index",
            dialect = "Dialect $index",
            examples = listOf("Example 1", "Example 2", "Example 3"),
            meanings = listOf("Meaning 1", "Meaning 2")
        )
    }
}

class DialetusActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    DialetusTheme {
        Scaffold(
            topBar = {
                AppTop()
            },
            bodyContent = {
                AppContent()
            },
            bottomBar = {
                AppBottom()
            }
        )
    }
}

@Composable
fun AppTop() {
    Column {
        TopAppBar(
            title = {
                Text(text = "Baianes")
            },
            backgroundColor = Color.White,
            elevation = 0.dp
        )

        SearchField(
            onValueChange = { value ->
                // TODO filter dialects
            }
        )

        AppDivider()
    }
}

@Composable
fun AppContent() {
    LazyColumnFor(
        items = items,
        modifier = Modifier.background(Color.LightGray.copy(alpha = .1f))
    ) { item ->
        Spacer(modifier = Modifier.height(8.dp))
        DialectCard(item)
    }
}

@Composable
fun DialectCard(dialect: Dialect) {
    Card(
        elevation = 2.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = dialect.dialect,
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp)
            )
            DialectSection(title = "Significado", items = dialect.meanings)
            DialectSection(title = "Exemplos", items = dialect.examples)

            AppDivider()

            Icon(
                asset = Icons.Filled.Share,
                tint = Color.DarkGray,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(16.dp)
                    .clickable(onClick = { Log.d("SHARE", dialect.dialect) })
            )
        }
    }
}

@Composable
fun DialectSection(title: String, items: List<String>) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(
            text = title.toUpperCase(),
            style = MaterialTheme.typography.caption,
            color = Color.Gray,
            modifier = Modifier.padding(top = 8.dp)
        )
        items.forEach { example ->
            Text(
                text = example,
                style = MaterialTheme.typography.body1
            )
        }
    }
}

@Composable
fun AppDivider() {
    Divider(
        color = Color.LightGray.copy(alpha = .4f),
        thickness = 1.dp,
        modifier = Modifier.padding(top = 16.dp)
    )
}

@Composable
fun AppBottom() {
    // TODO
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    App()
}
