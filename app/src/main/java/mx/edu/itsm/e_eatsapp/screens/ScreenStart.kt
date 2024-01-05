package mx.edu.itsm.e_eatsapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import mx.edu.itsm.e_eatsapp.R
import mx.edu.itsm.e_eatsapp.navigation.AppScreens
import mx.edu.itsm.e_eatsapp.ui.theme.DarkGreen

@Composable
fun ScreenStart(navController: NavController) {

    val image = painterResource(id = R.drawable.gran_conjunto_verduras_aisladas_sobre_fondo_blanco_1__1_)

    Column(
        modifier = Modifier
            .fillMaxHeight(1F)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight(0.5F)
                .fillMaxWidth(1F),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.e_eat),
                style = TextStyle(
                    fontSize = 36.sp,
                    fontFamily = FontFamily(Font(R.font.mochiy_pop_one_regular)),
                    fontWeight = FontWeight(400),
                    color = MaterialTheme.colorScheme.primary
                )
            )
            Text(
                text = stringResource(R.string.una_vida_saludable),
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.rubik)),
                fontWeight = FontWeight(400),
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                letterSpacing = 2.sp,
                modifier = Modifier
                    .padding(
                        start = 110.dp
                    )
            )
        }
        Box {
            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
            Button(
                onClick = {
                    navController.navigate(route = AppScreens.Slide1.route)
                },
                colors = ButtonDefaults.buttonColors(DarkGreen),
                modifier = Modifier
                    .align(Alignment.Center)
                    .width(176.dp)
                    .height(47.dp)
            ) {
                Text(
                    text = "Empezar",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.rubik)),
                        color = Color.White
                    )
                )
            }
        }
    }
}

//@Preview(
//    name = "Light Mode",
//    showBackground = true
//)
//@Preview(
//    uiMode = Configuration.UI_MODE_NIGHT_YES,
//    showBackground = true,
//    name = "Dark Mode"
//)
//@Composable
//fun StartScreenPreview() {
//    EEATSAPPTheme {
//        // A surface container using the 'background' color from the theme
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {
//            ScreenStart()
//        }
//    }
//}