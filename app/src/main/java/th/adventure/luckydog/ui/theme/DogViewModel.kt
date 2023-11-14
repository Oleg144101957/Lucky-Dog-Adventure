package th.adventure.luckydog.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import th.adventure.luckydog.R
import th.adventure.luckydog.domain.Elem

class DogViewModel : ViewModel() {

    var previousChoicePicture: Int? = null
    var previousChoicePosition: Int? = null

    val scores: MutableStateFlow<Int> = MutableStateFlow(0)

    val listOfElements: MutableStateFlow<List<Elem>> = MutableStateFlow(listOf(
        Elem(id = 0, picture = R.drawable.scene1, "element", isOpen = false),
        Elem(id = 1, picture = R.drawable.scene2, "element", isOpen = false),
        Elem(id = 2, picture = R.drawable.scene5, "element", isOpen = false),
        Elem(id = 3, picture = R.drawable.scene6, "element", isOpen = false),
        Elem(id = 4, picture = R.drawable.scene7, "element", isOpen = false),
        Elem(id = 5, picture = R.drawable.scene8, "element", isOpen = false),
        Elem(id = 6, picture = R.drawable.scene9, "element", isOpen = false),
        Elem(id = 7, picture = R.drawable.scene10, "element", isOpen = false),
        Elem(id = 8, picture = R.drawable.scene1, "element", isOpen = false),
        Elem(id = 9, picture = R.drawable.scene2, "element", isOpen = false),
        Elem(id = 10, picture = R.drawable.scene5, "element", isOpen = false),
        Elem(id = 11, picture = R.drawable.scene6, "element", isOpen = false),
        Elem(id = 12, picture = R.drawable.scene7, "element", isOpen = false),
        Elem(id = 13, picture = R.drawable.scene8, "element", isOpen = false),
        Elem(id = 14, picture = R.drawable.scene9, "element", isOpen = false)
    ))


    fun clickElement(elementPosition: Int){
        val newList = listOfElements.value.toMutableList()
        newList[elementPosition] = newList[elementPosition].copy(isOpen = true)
        listOfElements.value = newList
        checkElement(elementPosition)
    }

    suspend fun startElementsShow(){
        delay(800)
        val newList = listOfElements.value.map { it.copy(isOpen = true) }
        listOfElements.value = newList
        delay(1400)
        val newList2 = listOfElements.value.map { it.copy(isOpen = false) }
        listOfElements.value = newList2
    }

    fun checkElement(elementPosition: Int){
        viewModelScope.launch {
            if (previousChoicePicture == null){
                previousChoicePicture = listOfElements.value[elementPosition].picture
                previousChoicePosition = elementPosition
            } else {
                if (previousChoicePicture != listOfElements.value[elementPosition].picture){
                    val newList = listOfElements.value.toMutableList()
                    newList[previousChoicePosition!!] = newList[previousChoicePosition!!].copy(isOpen = false)
                    newList[elementPosition!!] = newList[elementPosition!!].copy(isOpen = false)
                    delay(750)
                    listOfElements.value = newList
                } else {
                    increaseScores()
                }

                previousChoicePicture = null
                previousChoicePosition = null
            }
        }
    }

    private fun increaseScores() {
        val newScore = scores.value + 1
        scores.value = newScore
    }

}