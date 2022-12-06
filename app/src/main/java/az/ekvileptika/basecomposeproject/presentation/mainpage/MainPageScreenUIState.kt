package az.ekvileptika.basecomposeproject.presentation.mainpage

import az.ekvileptika.basecomposeproject.data.characters.CharactersModel

data class MainPageScreenUIState (
    val isLoading: Boolean = false,
    var characterList: List<CharactersModel> = listOf(),
    val message: String = ""
)