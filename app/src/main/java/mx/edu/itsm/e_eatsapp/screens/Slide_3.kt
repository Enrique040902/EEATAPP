package mx.edu.itsm.e_eatsapp.screens


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.scale
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

@Composable
fun Slide_3(navController: NavController) {

    val image = painterResource(id = R.drawable.elote_1)

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
                    color = MaterialTheme.colorScheme.primary
                )
            )
            Text(
                text = "Lorem Ipsum is simply dummy text of the\\nprinting and typesetting industry.",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.rubik)),
                    fontWeight = FontWeight(400),
                    color = MaterialTheme.colorScheme.tertiary,
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
        Canvas(
            modifier = Modifier
                .width(40.dp)
                .height(14.dp)
        ) {
            scale(
                scale = 2f
            ) {
                drawCircle(
                    DarkGreen,
                    radius = 3.dp.toPx()
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
//fun Slide_3Preview() {
//    EEATSAPPTheme {
//        // A surface container using the 'background' color from the theme
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {
//            Slide_3(navController)
//        }
//    }
//}