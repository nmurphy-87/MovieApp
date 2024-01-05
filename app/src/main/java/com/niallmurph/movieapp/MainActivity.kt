package com.niallmurph.movieapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    content : @Composable () -> Unit
){
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
fun MainContent(){
    Surface(
        color = MaterialTheme.colors.background
    ){
        Text(text = "Main Content")
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    MyApp {
        MainContent()
    }
}