package az.ekvileptika.basecomposeproject.presentation.thirdpage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ThirdPageScreen(
    vm: ThirdPageViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ){
        Text(
            text = "SecondScreen",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}