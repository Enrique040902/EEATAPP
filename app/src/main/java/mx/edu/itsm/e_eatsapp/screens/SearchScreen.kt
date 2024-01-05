package mx.edu.itsm.e_eatsapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import mx.edu.itsm.e_eatsapp.R
import mx.edu.itsm.e_eatsapp.navigation.AppScreens


@Composable
fun SearchScreen(navController: NavHostController) {

    val colors = MaterialTheme.colorScheme
    val search = rememberSaveable {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(
                    modifier = Modifier
                        .size(28.dp),
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = colors.primary
                )
            }
            OutlinedTextField(
                modifier = Modifier
                    .height(36.dp),
                value = search.value,
                onValueChange = { search.value },
                label = {
                    Text(
                        text = "Buscar",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.rubik)),
                            color = colors.tertiary
                        )
                    )
                },
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = colors.primary,
                    unfocusedBorderColor = colors.primary,
                ),
                shape = RoundedCornerShape(20.dp)
            )

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    modifier = Modifier
                        .size(28.dp),
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = colors.primary
                )
            }
        }

        LazyColumn(modifier = Modifier.padding(top = 8.dp)) {
            item {
                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text = "Resultados",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.rubik)),
                        fontWeight = FontWeight(500),
                        color = colors.tertiary
                    )
                )
            }

            items(25) {
                ResultButton(navController)
            }
        }

    }

}

@Composable
fun ResultButton(navController: NavHostController) {

    val colors = MaterialTheme.colorScheme

    TextButton(
        onClick = {
            navController.navigate(AppScreens.SaucerInformationScreen.route)
        },
        modifier = Modifier
            .height(60.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ensalada_cesar),
                contentDescription = null,
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
            )
            Column(
                modifier = Modifier
                    .padding(
                        start = 8.dp
                    )
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "Ensalada César",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.rubik)),
                        fontWeight = FontWeight(500),
                        color = colors.tertiary
                    )
                )
                Text(
                    text = "Carbohidratos: 27.93g",
                    style = TextStyle(
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.rubik)),
                        fontWeight = FontWeight(400),
                        color = colors.tertiary
                    )
                )
            }
        }
    }
}

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
//fun SearchScreenPreview() {
//    EEATSAPPTheme {
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {
//            SearchScreen(navController)
//        }
//    }
//}