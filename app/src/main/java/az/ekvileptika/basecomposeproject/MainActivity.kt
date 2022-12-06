package az.ekvileptika.basecomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import az.ekvileptika.basecomposeproject.navigation.*
import az.ekvileptika.basecomposeproject.ui.theme.BaseComposeProjectTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            BaseComposeProjectTheme {
                //app bar title
                val appbartitle = remember {
                    mutableStateOf("Main")
                }
                // A surface container using the 'background' color from the theme
                val drawerState = rememberDrawerState(DrawerValue.Closed)
                val scope = rememberCoroutineScope()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //left drawier menu
                    ModalDrawer(
                        drawerState = drawerState,
                        gesturesEnabled = drawerState.isOpen,
                        drawerContent = {
                            DrawierNavigation(
                                onDestinationClicked = { route ->
                                    scope.launch {
                                        drawerState.close()
                                    }

                                    appbartitle.value = route.title
                                    navController.navigate(route.rote) {
                                        popUpTo = navController.graph.startDestinationId
                                        launchSingleTop = true
                                    }
                                }
                            )
                        }
                    ){
                        Scaffold(
                            bottomBar = {
                                BottomNavigationMenu(navController)
                            },
                            topBar = {
                                TopBar(
                                    appbartitle.value,
                                    Icons.Filled.Menu,
                                ) {
                                    scope.launch {
                                        drawerState.open()
                                    }
                                }
                            }
                        ) {
                            //content
                            NavigationGraph(navController)
                        }
                    }

                }
            }
        }
    }
}