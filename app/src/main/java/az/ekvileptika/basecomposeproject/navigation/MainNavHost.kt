package az.ekvileptika.basecomposeproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import az.ekvileptika.basecomposeproject.presentation.mainpage.MainPageScree
import az.ekvileptika.basecomposeproject.presentation.secondpage.SecondPageScree
import az.ekvileptika.basecomposeproject.presentation.thirdpage.ThirdPageScreen

@Composable
fun NavigationGraph(
    navHost: NavHostController
) {
    NavHost(
        navController = navHost,
        startDestination = MainNavigationMenu.MainPage.rote)
    {
        composable(MainNavigationMenu.MainPage.rote){
            MainPageScree()
        }
        composable(MainNavigationMenu.SecondPage.rote){
            SecondPageScree()
        }
        composable(MainNavigationMenu.ThirdPage.rote){
            ThirdPageScreen()
        }
        composable(MainNavigationMenu.AnotherPage.rote){
            MainPageScree()
        }
    }
}