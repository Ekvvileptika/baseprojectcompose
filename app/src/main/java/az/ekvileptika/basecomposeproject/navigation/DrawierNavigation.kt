package az.ekvileptika.basecomposeproject.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import az.ekvileptika.basecomposeproject.R

@Composable
fun DrawierNavigation(
    modifier: Modifier = Modifier,
    onDestinationClicked: (route: MainNavigationMenu) -> Unit
) {
    val items = listOf(
        MainNavigationMenu.MainPage,
        MainNavigationMenu.SecondPage,
        MainNavigationMenu.AnotherPage,
        MainNavigationMenu.ThirdPage
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 24.dp, top = 48.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "App icon"
        )
        items.forEach { screen ->
            Spacer(Modifier.height(24.dp))
            Text(
                text = screen.title,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.clickable {
                    onDestinationClicked(screen)
                }
            )
        }
    }
}