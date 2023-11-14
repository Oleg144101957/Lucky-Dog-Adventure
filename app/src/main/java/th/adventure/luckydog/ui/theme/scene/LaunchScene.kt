package th.adventure.luckydog.ui.theme.scene

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import th.adventure.luckydog.R
import th.adventure.luckydog.ui.theme.DogScreens


@Composable
fun LaunchScene(nav: NavHostController){

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.bg1),
            contentDescription = "lbg",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Image(
            painter = painterResource(id = R.drawable.scoreback),
            contentDescription = "just decor",
            modifier = Modifier
                .align(Alignment.TopStart)
        )

        Column(modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(bottom = 64.dp)

        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.btn),
                    contentDescription = "btn screen",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .clickable {
                            nav.navigate(DogScreens.PlayScene.target)
                        }
                )

                Text(
                    text = "Play Dog Adventure",
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }

            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.btn),
                    contentDescription = "btn screen",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .clickable {
                            nav.navigate(DogScreens.HelpScene.target)
                        }
                )

                Text(
                    text = "Help Screen Dog Luck",
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        }
    }
}