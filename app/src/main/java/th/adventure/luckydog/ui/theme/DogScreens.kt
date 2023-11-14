package th.adventure.luckydog.ui.theme



sealed class DogScreens(val target: String){

    object StartScene : DogScreens("start")
    object LaunchScene : DogScreens("launch")
    object PlayScene : DogScreens("play")
    object HelpScene : DogScreens("help")

}