package mx.edu.itsm.e_eatsapp.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import mx.edu.itsm.e_eatsapp.R
import mx.edu.itsm.e_eatsapp.ui.theme.DarkGreen
import mx.edu.itsm.e_eatsapp.ui.theme.LightGray

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Slide_1(navController: NavController) {

    val image = painterResource(id = R.drawable.ensalada_1)

    Column {
        ImageSlide(image)
        Column(
            modifier = Modifier
                .fillMaxHeight(.5F)
                .fillMaxWidth(1F),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Lorem Ipsum",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.rubik)),
                    fontWeight = FontWeight(700),
                    color = colorScheme.primary
                )
            )
            Text(
                text = "Lorem Ipsum is simply dummy text of the\\nprinting and typesetting industry.",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.rubik)),
                    fontWeight = FontWeight(400),
                    color = colorScheme.tertiary,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier
                    .width(268.dp)
                    .height(34.dp)
            )
            LoadingPoints()
        }
    }
}

@Composable
private fun LoadingPoints() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Canvas(
            modifier = Modifier
                .width(40.dp)
                .height(14.dp)
        ) {
            scale(
                scale = 2f
            ) {
                drawCircle(
                    color = DarkGreen,
                    radius = 3.dp.toPx()
                )
            }
        }
        Canvas(
            modifier = Modifier
                .width(40.dp)
                .height(14.dp)
        ) {
            scale(
                scale = 2f
            ) {
                drawCircle(
                    LightGray,
                    radius = 3.dp.toPx()
                )
            }
        }
        Canvas(
            modifier = Modifier
                .width(40.dp)
                .height(14.dp)
        ) {
            scale(
                scale = 2f
            ) {
                drawCircle(
                    LightGray,
                    radius = 3.dp.toPx()
                )
            }
        }
    }
}

@Composable
fun ImageSlide(image: Painter) {

    Column(
        modifier = Modifier
            .fillMaxHeight(.5F)
            .fillMaxWidth(1F),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            Canvas(
                modifier = Modifier
                    .fillMaxSize()
                    .blur(
                        radius = 80.dp
                    )
            ) {
                scale(
                    scale = 5f
                ) {
                    drawCircle(
                        Color(0xFF66C0B3),
                        radius = 10.dp.toPx()
                    )
                }
            }
            Image(
                painter = image,
                contentDescription = "Esalada",
                modifier = Modifier
                    .width(177.dp)
                    .height(177.dp)
                    .align(Alignment.Center)
            )
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
//fun Slide_1Preview() {
//    EEATSAPPTheme {
//        // A surface container using the 'background' color from the theme
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = colorScheme.background
//        ) {
//            Slide_1()
//        }
//    }
//}