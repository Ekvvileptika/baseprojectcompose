package az.ekvileptika.basecomposeproject.navigation

import android.graphics.Color
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import az.ekvileptika.basecomposeproject.R

@Composable
fun BottomNavigationMenu(navController: NavHostController){
    val items = listOf(
        MainNavigationMenu.MainPage,
        MainNavigationMenu.SecondPage,
        MainNavigationMenu.AnotherPage,
        MainNavigationMenu.ThirdPage
    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.teal_200),
        contentColor = Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title,
                    fontSize = 9.sp) },
                selectedContentColor = Black,
                unselectedContentColor = Black.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.rote,
                onClick = {
                    navController.navigate(item.rote) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}