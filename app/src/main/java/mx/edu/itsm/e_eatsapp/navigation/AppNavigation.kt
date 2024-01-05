package mx.edu.itsm.e_eatsapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mx.edu.itsm.e_eatsapp.components.SliderNavigationScreen
import mx.edu.itsm.e_eatsapp.components.WithBottomBar
import mx.edu.itsm.e_eatsapp.screens.HomeScreen
import mx.edu.itsm.e_eatsapp.screens.LoginScreen
import mx.edu.itsm.e_eatsapp.screens.RegisterScreen
import mx.edu.itsm.e_eatsapp.screens.SaucerInformationScreen
import mx.edu.itsm.e_eatsapp.screens.SavesScreen
import mx.edu.itsm.e_eatsapp.screens.ScreenStart
import mx.edu.itsm.e_eatsapp.screens.SearchScreen
import mx.edu.itsm.e_eatsapp.screens.Slide_2
import mx.edu.itsm.e_eatsapp.screens.Slide_3
import mx.edu.itsm.e_eatsapp.screens.SplashScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreens.SplashScreen.route
    ) {
        composable(route = AppScreens.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(route = AppScreens.ScreenStart.route) {
            ScreenStart(navController)
        }
        composable(route = AppScreens.Slide1.route) {
            SliderNavigationScreen(navController)
        }
        composable(route = AppScreens.Slide2.route) {
            Slide_2(navController)
        }
        composable(route = AppScreens.Slide3.route) {
            Slide_3(navController)
        }
        composable(route = AppScreens.HomeScreen.route) {
            WithBottomBar(navController) {
                HomeScreen(navController)
            }
        }
        composable(route = AppScreens.SavesScreen.route) {
            WithBottomBar(navController) {
                SavesScreen(navController)
            }
        }
        composable(route = AppScreens.SearchScreen.route) {
            WithBottomBar(navController) {
                SearchScreen(navController)
            }
        }
        composable(route = AppScreens.RegisterScreen.route) {
            RegisterScreen(navController)
        }
        composable(route = AppScreens.SaucerInformationScreen.route) {
            WithBottomBar(navController) {
                SaucerInformationScreen(navController)
            }
        }
        composable(route = AppScreens.LoginScreen.route) {
            LoginScreen(navController)
        }

    }

}