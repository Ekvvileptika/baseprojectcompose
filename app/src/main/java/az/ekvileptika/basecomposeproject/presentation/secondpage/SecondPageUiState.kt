package az.ekvileptika.basecomposeproject.presentation.secondpage

import az.ekvileptika.basecomposeproject.data.characters.CharactersModel
import az.ekvileptika.basecomposeproject.presentation.mainpage.MainPageScreenUIState
import az.ekvileptika.basecomposeproject.utils.ResponseResources

sealed interface SecondPageUiState {
    object Loading : SecondPageUiState
    data class Error(val throwable: Throwable) : SecondPageUiState
    data class Success(val data: List<CharactersModel>?) : SecondPageUiState
}