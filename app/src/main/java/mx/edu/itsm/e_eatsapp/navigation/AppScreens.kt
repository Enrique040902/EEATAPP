package mx.edu.itsm.e_eatsapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search

sealed class AppScreens(
    val route: String,
    val title: String,
) {
    object SplashScreen: AppScreens(route = "splash_screen", title = "Splash Screen")
    object ScreenStart: AppScreens(route = "screen_start", title = "Screen Start")
    object Slide1: AppScreens(route = "slide_1", title = "Slide 1")
    object Slide2: AppScreens(route = "slide_2", title = "Slide 2")
    object Slide3: AppScreens(route = "slide_3", title = "Slide 3")
    object LoginScreen: AppScreens(route = "login_screen", title = "Login Screen")
    object RegisterScreen: AppScreens(route = "register_screen", title = "Register Screen")
    object HomeScreen: ItemsBottomNav(route = "home_screen", icon = Icons.Outlined.Home, title = "Inicio")
    object SearchScreen: ItemsBottomNav(route = "search_screen",  icon = Icons.Outlined.Search, title = "Buscar")
    object SavesScreen: ItemsBottomNav(route = "saves_screen", icon = Icons.Outlined.Bookmark, title = "Guardados")
    object SaucerInformationScreen: AppScreens(route = "saucer_information_screen", title = "Saucer Information Screen")
}