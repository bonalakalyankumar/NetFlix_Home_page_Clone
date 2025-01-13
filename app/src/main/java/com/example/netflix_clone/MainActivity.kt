package com.example.netflix_clone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflix_clone.ui.theme.NetFlix_CloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .verticalScroll(rememberScrollState())
            ) {
                TopSectionOfApp()
                AppContentChoose()
                MainArea()
                TypeofMovies("Watched Movies")
                TypeofMovies("New Relase")
                TypeofMovies("Action Movies")
                TypeofMovies("Drama Movies")

            }


        }
    }

    @Composable

    fun TopSectionOfApp() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.netflixlogo),
                contentDescription = "netflix logo",
                modifier = Modifier.size(80.dp)
            )

            Row(
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_searchlogo),
                    contentDescription = "search logo",
                    modifier = Modifier
                        .size(75.dp)
                        .padding(10.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = "user profile",
                    modifier = Modifier
                        .size(75.dp)
                        .padding(6.dp)
                )
            }

        }
    }

    @Composable

    fun AppContentChoose() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "TV Shows", color = Color.White, fontSize = 20.sp)
            Text(text = "Movies", color = Color.White, fontSize = 20.sp)

            Row() {
                Text(text = "Categeries", color = Color.White, fontSize = 20.sp)
                Image(
                    painter = painterResource(id = R.drawable.ic_dropdown),
                    contentDescription = "drop down"
                )
            }

        }
    }

    @Composable

    fun MainArea() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.movie_3),
                contentDescription = "lion king",
                modifier = Modifier
                    .fillMaxWidth()
                    .size(300.dp)
                    .padding(top = 30.dp, bottom = 20.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Adventure", color = Color.White, fontSize = 20.sp)
                Text(text = "Thriller", color = Color.White, fontSize = 20.sp)
                Text(text = "Drama", color = Color.White, fontSize = 20.sp)
                Text(text = "Indian", color = Color.White, fontSize = 20.sp)
            }
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .padding(start = 50.dp, end = 50.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_add_24),
                        contentDescription = "addition",
                        modifier = Modifier.size(25.dp),
                    )
                    Text(text = "My List", color = Color.White, fontSize = 10.sp)

                }
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(Color.White),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(text = "Play", color = Color.Black)
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_info_24),
                        contentDescription = "info", modifier = Modifier.size(20.dp)
                    )
                    Text(text = "My List", color = Color.White, fontSize = 10.sp)

                }

            }

        }

    }

    @Composable

    fun TypeofMovies(MovieType:String) {

        Column(
            modifier = Modifier.background(color = Color.Black)
        ) {

            Text(
                text = MovieType, color = Color.White,
                modifier = Modifier.fillMaxWidth(), fontSize = 22.sp, fontWeight = FontWeight.Bold
            )
            LazyRow {
                itemsIndexed(TotalListOfMovies()) { index, item ->
                    ListofMoviesUI(Image = item.Imageres)

                }
            }


        }
    }
    fun TotalListOfMovies(): List<Listofmovies>{
        val MoviesList = mutableListOf<Listofmovies>()
        MoviesList.add(Listofmovies(R.drawable.movie_1))
        MoviesList.add(Listofmovies(R.drawable.movie_2))
        MoviesList.add(Listofmovies(R.drawable.movie_3))
        MoviesList.add(Listofmovies(R.drawable.movie_4_john))
        MoviesList.add(Listofmovies(R.drawable.movie_5_logan))
        MoviesList.add(Listofmovies(R.drawable.movie_6_marvel))
        MoviesList.add(Listofmovies(R.drawable.movie_7))

        MoviesList.shuffle()
        return MoviesList
    }

        @Composable
        fun ListofMoviesUI(
            Image: Int
        ) {
            Image(
                painter = painterResource(id = Image), contentDescription = "",
                modifier = Modifier
                    .height(200.dp)
                    .width(140.dp)
                    .padding(top = 10.dp)
            )
        }
    }
    data class Listofmovies(
        val Imageres:Int
    )


