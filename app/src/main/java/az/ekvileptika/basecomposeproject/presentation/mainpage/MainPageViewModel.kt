package az.ekvileptika.basecomposeproject.presentation.mainpage

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import az.ekvileptika.basecomposeproject.utils.ResponseResources
import az.ekvileptika.basecomposeproject.domain.CharactersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainPageViewModel @Inject constructor(
    val characterRepo: CharactersRepository
): ViewModel() {
    var uiModel by mutableStateOf(MainPageScreenUIState())

    val cException = CoroutineExceptionHandler{ context, thowable ->
        uiModel = uiModel.copy(isLoading = false, message = thowable.message.toString())
    }

    fun getAllCharacters() = viewModelScope.launch(cException){
        val resp = characterRepo.getAllCharacters()

        when(resp){
            is ResponseResources.Success -> {
               // uiModel.copy(isLoading = false, characterList = resp.data!!.results)
                uiModel = uiModel.copy(characterList = resp.data!!.results)
            }

            is ResponseResources.Failure -> {
                uiModel = uiModel.copy(isLoading = false, message = resp.message.toString())
            }
        }
    }
}