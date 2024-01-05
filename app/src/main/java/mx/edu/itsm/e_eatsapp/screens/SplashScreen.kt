package mx.edu.itsm.e_eatsapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import mx.edu.itsm.e_eatsapp.R
import mx.edu.itsm.e_eatsapp.navigation.AppScreens

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(key1 = true) {
        delay(1000)
        navController.popBackStack()
        navController.navigate(AppScreens.ScreenStart.route)
    }
    Splash()
}

@Composable
fun Splash() {

    val image = painterResource(id = R.drawable.surtido_piramides_alimentos_reales_1)

    Box {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = image,
            contentDescription = "Image de fondo de alimentos",
            contentScale = ContentScale.Crop,
            alpha = 0.92F
        )

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.e_eat),
                fontSize = 36.sp,
                fontFamily = FontFamily(Font(R.font.mochiy_pop_one_regular)),
                fontWeight = FontWeight(400),
                color = Color(0xFFFFFFFF),
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(R.string.una_vida_saludable),
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.rubik)),
                fontWeight = FontWeight(400),
                color = Color(0xFFFFFFFF),
                textAlign = TextAlign.Center,
                letterSpacing = 2.sp,
                modifier = Modifier
                    .padding(
                        start = 130.dp
                    )
            )/*
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.White)
                ) {
               Text(
                   text = "Empezar",
                   fontFamily = FontFamily(Font(R.font.rubik)),
                   fontSize = 16.sp,
                   fontWeight = FontWeight(400),
                   letterSpacing = 1.sp,
                   color = DarkGreen
               )
            }*/
        }
    }

}

@Preview(showBackground = true)
@Composable
fun SplashScreenViewPreview() {
    Splash()
}