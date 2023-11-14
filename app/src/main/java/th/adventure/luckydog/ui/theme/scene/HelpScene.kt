package th.adventure.luckydog.ui.theme.scene
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import th.adventure.luckydog.R
import th.adventure.luckydog.ui.theme.DogScreens


@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun HelpScene(nav: NavHostController) {

    val customFont = FontFamily(Font(R.font.angella_demo))

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.bg1),
            contentDescription = "lbg",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Text(
            text = stringResource(id = R.string.app_name),
            color = Color.Black,
            fontFamily = customFont,
            fontSize = 24.sp,
            modifier = Modifier
                .align(Alignment.Center)
        )

        Image(
            painter = rememberVectorPainter(image = Icons.Default.Close),
            contentDescription = "btn close",
            modifier = Modifier
                .align(Alignment.TopStart)
                .size(64.dp)
                .padding(16.dp)
                .clickable {
                    nav.navigate(DogScreens.LaunchScene.target)
                }
        )

        Image(
            painter = painterResource(id = R.drawable.animals),
            contentDescription = "animals",
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}