package az.ekvileptika.basecomposeproject.navigation

import az.ekvileptika.basecomposeproject.R

sealed class MainNavigationMenu(
    val title: String,
    val icon: Int,
    val rote: String
) {
    object MainPage: MainNavigationMenu("Home", R.drawable.ic_launcher_foreground, "home")
    object SecondPage: MainNavigationMenu("Second", R.drawable.ic_launcher_foreground, "second")
    object AnotherPage: MainNavigationMenu("Another", R.drawable.ic_launcher_foreground, "another")
    object ThirdPage: MainNavigationMenu("Third", R.drawable.ic_launcher_foreground, "third")
}
