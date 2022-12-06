package az.ekvileptika.basecomposeproject.presentation.secondpage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import az.ekvileptika.basecomposeproject.presentation.secondpage.SecondPageUiState.Success
import az.ekvileptika.basecomposeproject.domain.CharactersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SecondPageViewModel @Inject constructor(
    val characterRepo: CharactersRepository
): ViewModel() {
    fun result() {
        viewModelScope.launch {
            characterRepo
                .charactersListFlow()
                .map { it.data?.results }
                .map(::Success)
                .stateIn(
                    viewModelScope,
                    SharingStarted.WhileSubscribed(5000),
                    SecondPageUiState.Loading
                )
        }
    }
}