package th.adventure.luckydog.ui.theme.scene

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import th.adventure.luckydog.R
import th.adventure.luckydog.ui.theme.DogScreens
import th.adventure.luckydog.ui.theme.DogViewModel

@Composable
fun PlayScene(nav: NavHostController){


    val dogViewModel = viewModel<DogViewModel>()
    val listOfState = dogViewModel.listOfElements.collectAsState()
    val scores = dogViewModel.scores.collectAsState()

    LaunchedEffect(Unit){
        dogViewModel.startElementsShow()
    }

    Box(modifier = Modifier
        .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg2),
            contentDescription = "lbg",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Image(
            painter = rememberVectorPainter(image = Icons.Default.Close),
            contentDescription = "btn close",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .size(64.dp)
                .padding(16.dp)
                .clickable {
                    nav.navigate(DogScreens.LaunchScene.target)
                }
        )

        Box(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.Center)
        ){
            Image(
                painter = painterResource(id = R.drawable.frame),
                contentDescription = "play frame",
                modifier = Modifier
                    .size(460.dp)
                    .align(Alignment.Center),
                contentScale = ContentScale.FillWidth
            )


            LazyVerticalGrid(
                modifier = Modifier
                    .padding(24.dp)
                    .align(Alignment.Center),
                columns = GridCells.Fixed(5),
                content = {
                    items(15) {

                        Image(
                            painter = painterResource(id = if (listOfState.value[it].isOpen) listOfState.value[it].picture else R.drawable.scene15),
                            contentDescription = "item",
                            modifier = Modifier
                                .clickable {
                                    dogViewModel.clickElement(it)
                                }
                        )
                    }
                }
            )
        }

        Box(modifier = Modifier
            .align(Alignment.TopCenter)
            .padding(top = 16.dp)
            .fillMaxWidth()
        ){

            Image(
                painter = painterResource(id = R.drawable.btn),
                contentDescription = "score back",
                modifier = Modifier
                    .align(Alignment.Center)
            )

            Text(
                text = "${scores.value} scores",
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
    }
}