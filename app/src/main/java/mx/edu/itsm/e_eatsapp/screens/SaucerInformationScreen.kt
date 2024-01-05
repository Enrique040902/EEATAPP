package mx.edu.itsm.e_eatsapp.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FiberManualRecord
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import mx.edu.itsm.e_eatsapp.R
import mx.edu.itsm.e_eatsapp.ui.theme.EEATSAPPTheme

@Composable
fun SaucerInformationScreen(navController: NavHostController) {

    val image = painterResource(id = R.drawable.ensalada_fondo)
    val colors = MaterialTheme.colorScheme

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(260.dp)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
                    .alpha(0.5f),
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            IconButton(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Icon(
                    modifier = Modifier
                        .size(28.dp),
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }

        Text(
            modifier = Modifier
                .padding(16.dp),
            text = "Ensalada Griega",
            style = TextStyle(
                fontSize = 22.sp,
                fontFamily = FontFamily(Font(R.font.rubik)),
                fontWeight = FontWeight(600),
                color = colors.tertiary
            )
        )
        Text(
            modifier = Modifier.padding(8.dp),
            text = "La ensalada original está elaborada de tomate, pepino, pimiento y cebolla roja, " +
                    "todo ello con sal, pimienta negra y orégano y aliñada con aceite de oliva. " +
                    "A todo ello se le añaden trozos de queso feta, alcaparras y aceitunas kalamata. ",
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.rubik)),
                fontWeight = FontWeight(400),
                color = colors.tertiary
            )
        )

        Text(
            modifier = Modifier
                .padding(16.dp),
            text = "Ingredientes",
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.rubik)),
                fontWeight = FontWeight(600),
                color = colors.tertiary
            )
        )

        val ingredients = listOf(
            "Tomate",
            "Pepino",
            "Cebolla",
            "Aceitunas negras",
            "Queso feta",
            "Oregón",
            "Aceite",
            "Vinagre de vino tinto",
            "Sal",
            "Miel"
        )

        ListOfIngredients(ingredients)

        Text(
            modifier = Modifier
                .padding(16.dp),
            text = "Carbohidratos",
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.rubik)),
                fontWeight = FontWeight(600),
                color = colors.tertiary
            )
        )

        Row(
            modifier = Modifier
                .padding(
                    all = 16.dp
                )
        ) {
            Text(
                text = "Número total:",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.rubik)),
                    fontWeight = FontWeight(400),
                    color = colors.tertiary
                )
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "347 kcal",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.rubik)),
                    fontWeight = FontWeight(400),
                    color = colors.primary,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}

@Composable
private fun ListOfIngredients(ingredients: List<String>) {

    val colors = MaterialTheme.colorScheme

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(
                start = 16.dp,
                end = 16.dp
            )
            .shadow(
                elevation = 3.5.dp,
                shape = RoundedCornerShape(10.dp),
                spotColor = colors.primary,
                ambientColor = colors.primary
            )
            .clip(shape = RoundedCornerShape(10.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(ingredients.count()) { index ->
            IngredientRow(ingredient = ingredients[index])
        }
    }
}

@Composable
private fun IngredientRow(ingredient: String) {

    val colors = MaterialTheme.colorScheme

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                end = 16.dp
            )
    ) {
        Icon(
            imageVector = Icons.Filled.FiberManualRecord,
            contentDescription = null,
            tint = colors.primary
        )
        Text(
            text = ingredient,
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.rubik)),
                fontWeight = FontWeight(400),
                color = colors.tertiary
            )
        )
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
//fun SaucerInformationScreenPreview() {
//    EEATSAPPTheme {
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {
//            SaucerInformationScreen(navController)
//        }
//    }
//}