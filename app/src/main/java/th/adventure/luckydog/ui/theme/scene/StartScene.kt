package th.adventure.luckydog.ui.theme.scene

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import th.adventure.luckydog.R
import th.adventure.luckydog.ui.theme.DogScreens


@Composable
fun StartScene(nav: NavHostController){


    val angle = remember {
        Animatable(0f)
    }

    LaunchedEffect(Unit){
        delay(2500)
        nav.navigate(DogScreens.LaunchScene.target)
    }

    LaunchedEffect(Unit){
        angle.animateTo(
            targetValue = 360f,
            animationSpec = infiniteRepeatable(tween(
                durationMillis = 1000,
                easing = LinearEasing
            ), repeatMode = RepeatMode.Restart)
        )
    }

    Box(modifier = Modifier.fillMaxSize()){

        Image(
            painter = painterResource(id = R.drawable.bg1),
            contentDescription = "lbg",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        
        Image(
            painter = painterResource(id = R.drawable.scene4),
            contentDescription = "rotation object",
            modifier = Modifier
                .align(Alignment.Center)
                .size(256.dp)
                .rotate(angle.value)
        )


        Text(
            text = "Loading scene ...",
            color = Color.White,
            fontSize = 32.sp,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
        )

    }
}