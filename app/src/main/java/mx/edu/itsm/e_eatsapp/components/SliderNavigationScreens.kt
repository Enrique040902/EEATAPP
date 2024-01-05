@file:OptIn(ExperimentalFoundationApi::class)

package mx.edu.itsm.e_eatsapp.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import mx.edu.itsm.e_eatsapp.navigation.AppScreens.Slide1
import mx.edu.itsm.e_eatsapp.navigation.AppScreens.Slide2
import mx.edu.itsm.e_eatsapp.navigation.AppScreens.Slide3
import mx.edu.itsm.e_eatsapp.navigation.AppScreens.LoginScreen
import mx.edu.itsm.e_eatsapp.screens.Slide_1
import mx.edu.itsm.e_eatsapp.screens.Slide_2
import mx.edu.itsm.e_eatsapp.screens.Slide_3
import mx.edu.itsm.e_eatsapp.screens.LoginScreen

@Composable
fun SliderNavigationScreen(navController: NavController) {

    val screens = listOf(
        Slide1,
        Slide2,
        Slide3,
        LoginScreen
    )
    val pagerState = rememberPagerState(pageCount = {
        screens.size
    })

    Box(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            state = pagerState,
            userScrollEnabled = pagerState.currentPage != screens.lastIndex
        ) { screen ->
            when (screen) {
                0 -> Slide_1(navController)
                1 -> Slide_2(navController)
                2 -> Slide_3(navController)
                3 -> LoginScreen(navController)
            }
        }
    }
}