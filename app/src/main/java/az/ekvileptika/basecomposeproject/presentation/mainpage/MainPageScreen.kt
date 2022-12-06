package az.ekvileptika.basecomposeproject.presentation.mainpage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import az.ekvileptika.basecomposeproject.R
import az.ekvileptika.basecomposeproject.data.characters.CharactersModel
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun MainPageScree(
    vm: MainPageViewModel = hiltViewModel()
) {
/*    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ){
        Text(
            text = "MainScreen",
            modifier = Modifier.align(Alignment.Center)
        )
    }*/

    vm.getAllCharacters()
    if(vm.uiModel.isLoading) {
        CircularProgressIndicator()
    }

    if(vm.uiModel.characterList.isNotEmpty()){
        DisplayCharacters(vm.uiModel.characterList)
    }
}

@Composable
fun DisplayCharacters(list: List<CharactersModel>) {
    LazyColumn{
        items(list.size){ position ->
            CharacterItem( list[position] )
        }
    }
}

@Composable
fun CharacterItem(character: CharactersModel) {
    Column {
        Text(text = character.name)

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(character.image)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "Character image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(CircleShape)
        )
    }
}