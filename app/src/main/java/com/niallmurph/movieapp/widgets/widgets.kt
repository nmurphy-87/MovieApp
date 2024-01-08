package com.niallmurph.movieapp.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.niallmurph.movieapp.models.MovieModel
import com.niallmurph.movieapp.models.getMovies

@Composable
fun MovieRow(
    movie: MovieModel = getMovies()[0],
    onClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(120.dp)
            .clickable {
                onClick(movie.id)
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
                Image(
                    painter = rememberImagePainter(data = movie.images[0]),
                    contentDescription = "Film image"
                )
            }
            Column(
                modifier = Modifier
                    .padding(4.dp)
            ) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = "Director : ${movie.director}",
                    style = MaterialTheme.typography.caption
                )
                Text(
                    text = "Year : ${movie.year}",
                    style = MaterialTheme.typography.caption
                )

            }

        }

    }
}

@Preview
@Composable
fun MovieRowPreview() {

    MovieRow(
        movie = getMovies()[0]
    ) {

    }

}