package az.ekvileptika.basecomposeproject.presentation.mainpage

sealed class MainPageScreenEvents {
    data class ClickedWithData(val data: String) : MainPageScreenEvents()
    object SimpleAction: MainPageScreenEvents()
}
