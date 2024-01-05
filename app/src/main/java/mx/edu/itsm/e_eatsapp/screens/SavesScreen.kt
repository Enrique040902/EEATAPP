package mx.edu.itsm.e_eatsapp.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import mx.edu.itsm.e_eatsapp.R
import mx.edu.itsm.e_eatsapp.ui.theme.EEATSAPPTheme

@Composable
fun SavesScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {

        val colors = MaterialTheme.colorScheme

        MenuAndNotifications()

        Text(
            text = "Guardados",
            style = TextStyle(
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.rubik)),
                fontWeight = FontWeight(700),
                color = colors.tertiary
            )
        )

        ListOfSaves()
    }
}

@Composable
private fun ListOfSaves() {

    val colors = MaterialTheme.colorScheme
    val imageSalad = painterResource(id = R.drawable.ensalada_cesar)
    val imageJuice = painterResource(id = R.drawable.jugos)

    LazyColumn(
        modifier = Modifier
            .padding(
                top = 16.dp
            )
    ) {
        item {
            Text(
                text = "Ensaladas",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.rubik)),
                    fontWeight = FontWeight(500),
                    color = colors.tertiary
                ),
                modifier = Modifier
                    .padding(8.dp)
            )
        }
        items(5) {
            CardSaves(title = "Ensalada César", image = imageSalad, carbohydrates = "27.93g")
        }

        item {
            Text(
                text = "Jugos",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.rubik)),
                    fontWeight = FontWeight(500),
                    color = colors.tertiary
                ),
                modifier = Modifier
                    .padding(8.dp)
            )
        }

        items(5) {
            CardSaves(title = "Uva y Naranja", image = imageJuice, carbohydrates = "0.4g")
        }
    }
}

@Composable
private fun CardSaves(
    title: String,
    image: Painter,
    carbohydrates: String
) {
    val colors = MaterialTheme.colorScheme
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(98.dp)
            .padding(
                top = 8.dp
            )
            .border(
                color = colors.primary,
                width = 1.dp,
                shape = RoundedCornerShape(6.dp)
            )
            .padding(8.dp)
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 8.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.rubik)),
                    fontWeight = FontWeight(500),
                    color = colors.tertiary
                )
            )

            Text(
                text = "Carbohidratos",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.rubik)),
                    fontWeight = FontWeight(400),
                    color = colors.tertiary
                )
            )

            Text(
                text = carbohydrates,
                style = TextStyle(
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.rubik)),
                    fontWeight = FontWeight(400),
                    color = colors.primary
                )
            )

        }
    }
}

//@Preview(
//    name = "Card Saves Light Theme",
//    showBackground = true
//)
//@Preview(
//    name = "Card Saves Dark Theme",
//    uiMode = Configuration.UI_MODE_NIGHT_YES,
////    showBackground = true
//)
//@Composable
//fun CardSavesPreview() {
//    EEATSAPPTheme {
//        CardSaves("Ensalada César", painterResource(id = R.drawable.ensalada_cesar), "27.93g")
//    }
//}

//@Preview(
//    name = "Light Theme",
//    showBackground = true
//)
//@Preview(
//    name = "Dark Theme",
//    showBackground = true,
//    uiMode = Configuration.UI_MODE_NIGHT_YES
//)
//@Composable
//fun GuardadosScreenPreview() {
//    EEATSAPPTheme {
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {
//            SavesScreen()
//        }
//    }
//}