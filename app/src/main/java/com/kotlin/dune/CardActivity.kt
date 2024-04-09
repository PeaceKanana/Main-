package com.kotlin.dune

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kotlin.dune.ui.theme.DuneTheme

class CardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DuneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  //  Greeting("Android")
                }
            }
        }
    }
}

// Data model for our items
data class Item(val title: String, val description: String)

// Sample list of items
val items = listOf(
    Item("Title 1", "Description 1"),
    Item("Title 2", "Description 2"),
    Item("Title 3", "Description 3"),
    // Add more items as needed
)

@Composable
fun CardList() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items) { item ->
            CardItem(item)
        }
    }
}

@Composable
fun CardItem(item: Item) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        color = Color.Red

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column {
                Text(text = item.title, style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = item.description, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Preview
@Composable
fun PreviewCardList() {
    MaterialTheme {
        CardList()
    }
}