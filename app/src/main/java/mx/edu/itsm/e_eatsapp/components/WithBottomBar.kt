package mx.edu.itsm.e_eatsapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun WithBottomBar(navController: NavHostController, content: @Composable () -> Unit) {
    Scaffold(
        bottomBar = { NavegacionInferior(navController) }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
        ) {
            content()
        }
    }
}