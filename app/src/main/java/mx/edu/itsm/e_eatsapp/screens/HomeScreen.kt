package mx.edu.itsm.e_eatsapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import mx.edu.itsm.e_eatsapp.R
import mx.edu.itsm.e_eatsapp.components.NavegacionInferior
import mx.edu.itsm.e_eatsapp.navigation.AppNavigation

@Composable
fun HomeScreen(navController: NavHostController) {

    val colors = MaterialTheme.colorScheme

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {

        MenuAndNotifications()

        Text(
            modifier = Modifier
                .padding(8.dp),
            text = "¿Que hay de nuevo?",
            style = TextStyle(
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.rubik)),
                fontWeight = FontWeight(700),
                color = colors.tertiary
            )
        )
        CardSlider()


        TodaysMenu()
    }

}

@Composable
private fun TodaysMenu() {

    val colors = MaterialTheme.colorScheme

    LazyColumn(
        modifier = Modifier
            .padding(
                top = 28.dp
            )
    ) {
        item {
            Text(
                modifier = Modifier
                    .padding(
//                            top = 24.dp,
                        start = 16.dp
                    ),
                text = "Carta del día",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.rubik)),
                    fontWeight = FontWeight(700),
                    color = colors.tertiary
                )
            )
        }
        items(5) {
            CardFoodRow()
        }
    }
}

@Composable
private fun CardSlider() {
    Box(
        modifier = Modifier
            .width(398.dp)
            .height(168.dp)
            .padding(8.dp)
            .background(
                color = Color.Black,
                shape = RoundedCornerShape(11.dp)
            )
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0x75000000),
                    shape = RoundedCornerShape(11.dp)
                )
                .alpha(0.5f)
                .clip(RoundedCornerShape(11.dp)),
            painter = painterResource(id = R.drawable.ensalada_fondo),
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Column(
            modifier = Modifier
                .padding(
                    start = 24.dp,
                    top = 24.dp
                )
        ) {
            Text(
                text = "Ensalda griega",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.rubik)),
                    fontWeight = FontWeight(600),
                    color = Color.White
                )
            )
            Text(
                text = "Especialidad de la casa",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.rubik)),
                    fontWeight = FontWeight(400),
                    color = Color.White
                )
            )
        }
    }
}

@Composable
fun MenuAndNotifications() {

    val colors = MaterialTheme.colorScheme

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Rounded.Menu,
                contentDescription = "Menú",
                tint = colors.primary
            )
        }

        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = "Notificaciones",
                tint = colors.primary
            )
        }
    }
}

@Composable
private fun CardFoodRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 16.dp
            ),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        CardFood()
        CardFood()
    }
}

@Composable
private fun CardFood() {

    val colors = MaterialTheme.colorScheme

    Column(
        modifier = Modifier
            .width(174.dp)
            .height(184.dp)
            .background(
                color = colors.background,
                RoundedCornerShape(10.dp)
            )
            .border(
                width = 2.dp,
                color = colors.primary,
                RoundedCornerShape(10.dp)
            )
            .padding(8.dp)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .clip(RoundedCornerShape(10.dp)),
            painter = painterResource(id = R.drawable.ensalada_cesar),
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Column(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = "Ensalda César",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.rubik)),
                    fontWeight = FontWeight(500),
                    color = colors.tertiary
                )
            )

            Text(
                text = "Carboidratos",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.rubik)),
                    fontWeight = FontWeight(500),
                    color = colors.tertiary
                )
            )

            Text(
                text = "27.92 g",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.rubik)),
                    fontWeight = FontWeight(500),
                    color = colors.primary
                )
            )
        }

    }
}


//@Preview(
//    name = "Card Food Light Theme",
//    showBackground = true
//)
//@Preview(
//    name = "Card Food Dark Theme",
//    uiMode = Configuration.UI_MODE_NIGHT_YES,
////    showBackground = true
//)
//@Composable
//fun CardFoodPreview() {
//    EEATSAPPTheme {
//        CardFoodRow()
//    }
//}
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
//fun HomeScreenPreview() {
//    EEATSAPPTheme {
//        // A surface container using the 'background' color from the theme
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {
//            HomeScreen(navController)
//        }
//    }
//}