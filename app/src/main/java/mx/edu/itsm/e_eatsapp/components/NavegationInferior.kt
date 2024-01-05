package mx.edu.itsm.e_eatsapp.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import mx.edu.itsm.e_eatsapp.navigation.AppScreens.*
import mx.edu.itsm.e_eatsapp.navigation.currentRoute

@Composable
fun NavegacionInferior(navHostController: NavHostController) {

    val menuItem = listOf(
        HomeScreen,
        SearchScreen,
        SavesScreen
    )

    BottomAppBar {
        NavigationBar(
            modifier = Modifier
                .clip(
                    shape = RoundedCornerShape(5.dp)
                )
        ) {
            menuItem.forEach { item ->

                val selected = currentRoute(navController = navHostController) == item.route

                NavigationBarItem(
                    selected = selected,
                    onClick = {
                        navHostController.navigate(item.route)
                    },
                    icon = {
                        Icon(
                            modifier = Modifier
                                .size(28.dp),
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    },
                    label = {
                        Text(text = item.title)
                    }
                )

            }
        }
    }

}