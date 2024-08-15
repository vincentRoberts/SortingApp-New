import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ui.SearchScreen
import ui.SortScreen
import ui.components.TabButton
import ui.theme.AppTheme
import androidx.compose.material3.MaterialTheme

@Composable
fun App(currentScreen: MutableState<MenuItem>) {

    Column {
        TabRow(selectedTabIndex = currentScreen.value.ordinal) {

            TabButton(text = "Search",
                selected = currentScreen.value == MenuItem.Search,
                onClick = { currentScreen.value = MenuItem.Search })

            TabButton(text = "Sort",
                selected = currentScreen.value == MenuItem.Sort,
                onClick = { currentScreen.value = MenuItem.Sort })
        }

        Box {
            when (currentScreen.value) {
                MenuItem.Search -> SearchScreen()
                MenuItem.Sort -> SortScreen()
            }
        }
    }
}

fun main() = application {

    Window(
        onCloseRequest = ::exitApplication,
        title = "Searching and Sorting App"
    ) {
        AppTheme() {
            val currentScreen = remember { mutableStateOf(MenuItem.Search) }
            App(currentScreen)
        }
    }
}
