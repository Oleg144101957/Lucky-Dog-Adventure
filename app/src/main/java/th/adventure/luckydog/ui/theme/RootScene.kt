package th.adventure.luckydog.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import th.adventure.luckydog.ui.theme.scene.HelpScene
import th.adventure.luckydog.ui.theme.scene.LaunchScene
import th.adventure.luckydog.ui.theme.scene.PlayScene
import th.adventure.luckydog.ui.theme.scene.StartScene


@Composable
fun RootScene(){

    val nav = rememberNavController()

    NavHost(navController = nav, startDestination = DogScreens.StartScene.target){
        composable(route = DogScreens.StartScene.target){
            StartScene(nav = nav)
        }

        composable(route = DogScreens.LaunchScene.target){
            LaunchScene(nav = nav)
        }

        composable(route = DogScreens.PlayScene.target){
            PlayScene(nav = nav)
        }

        composable(route = DogScreens.HelpScene.target){
            HelpScene(nav = nav)
        }
    }
}