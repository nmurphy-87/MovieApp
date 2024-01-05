package com.niallmurph.movieapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.niallmurph.movieapp.ui.theme.MovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MainContent()
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MyApp(
    content: @Composable () -> Unit
) {
    MovieAppTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    backgroundColor = Color.Magenta,
                    elevation = 6.dp
                ) {
                    Text("Movies")
                }
            }
        ) {
            MainContent()
        }
    }
}

@Composable
fun MainContent(
    movieList: List<String> = listOf(
        "Avatar",
        "300",
        "Harry Potter",
        "Lord of the Rings",
        "Watchmen",
        "Star Wars",
        "The Usual Suspects",
        "Life"
    )
) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(items = movieList) {
                MovieRow(it) { movie ->
                    Log.d("MOVIE", "$movie")

                }
            }
        }
    }
}

@Composable
fun MovieRow(
    movie: String,
    onClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(120.dp)
            .clickable {
               onClick(movie)
            },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 6.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(96.dp),
                shape = RectangleShape,
                elevation = 4.dp
            ) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Movie Image")
            }
            Text(text = movie)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MainContent()
    }
}