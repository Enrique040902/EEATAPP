package mx.edu.itsm.e_eatsapp.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import mx.edu.itsm.e_eatsapp.R
import mx.edu.itsm.e_eatsapp.navigation.AppScreens

@Composable
fun LoginScreen(navController: NavController) {

    val colors = MaterialTheme.colorScheme // Colores de la app

    Column {
        val email = rememberSaveable {
            mutableStateOf("")
        }
        val password = rememberSaveable {
            mutableStateOf("")
        }
        val passVisible = rememberSaveable {
            mutableStateOf(false)
        }
        val contextToast = LocalContext.current.applicationContext

        Spacer(modifier = Modifier.height(30.dp))
        Text(
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
                .align(Alignment.CenterHorizontally),
            text = stringResource(id = R.string.e_eat),
            style = TextStyle(
                fontSize = 36.sp,
                fontFamily = FontFamily(Font(R.font.mochiy_pop_one_regular)),
                color = colors.primary,
                textAlign = TextAlign.Justify,
                fontWeight = FontWeight(400)
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier
                .padding(
                    start = 20.dp,
                    bottom = 16.dp
                ),
            text = "Login",
            style = TextStyle(
                fontSize = 32.sp,
                fontFamily = FontFamily(Font(R.font.rubik)),
                fontWeight = FontWeight(700),
                color = colors.primary
            )
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(
                    start = 20.dp,
                    end = 20.dp
                )
                .fillMaxWidth(),
            value = email.value,
            onValueChange = { email.value = it },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            label = {
                Text(
                    text = stringResource(R.string.correo_eletronico),
                    color = colors.primary,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.rubik)),
                        color = colors.primary
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

        val visualTransformation = if (passVisible.value) VisualTransformation.None else PasswordVisualTransformation()
        OutlinedTextField(
            modifier = Modifier
                .padding(
                    top = 18.dp,
                    start = 20.dp,
                    end = 20.dp
                )
                .fillMaxWidth(),
            value = password.value,
            onValueChange = { password.value = it },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            label = {
                Text(
                    stringResource(R.string.password),
                    color = colors.primary,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.rubik)),
                        color = colors.primary
                    )
                )
            },
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colors.primary,
                unfocusedBorderColor = colors.primary,
            ),
            shape = RoundedCornerShape(20.dp),
            visualTransformation = visualTransformation,
            trailingIcon = {
                if (password.value.isNotBlank()) {
                    PasswordVisibleIcon(passVisible)
                } else null
            }
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(
                        start = 20.dp,
                        end = 20.dp
                    )
                    .fillMaxWidth(),
                onClick = {
                    navController.navigate(AppScreens.HomeScreen.route)
                }
            ) {
                Text(
                    text = "Ingresar",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.rubik)),
                        color = Color.White
                    )
                )
            }
//        Spacer(modifier = Modifier.height(35.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "¿Olvidaste tu contraseña?",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.rubik)),
                        fontSize = 14.sp
                    )
                )
                ClickableText(
                    modifier = Modifier
                        .padding(start = 5.dp),
                    text = AnnotatedString("Ingresa aquí"),
                    onClick = {
                        Toast.makeText(contextToast, "Recuperando contraseña...", Toast.LENGTH_SHORT)
                            .show()
                    },
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.rubik)),
                        fontWeight = FontWeight(750),
                        color = colors.primary
                    )
                )
            }
            Canvas(modifier = Modifier.fillMaxWidth()) {
                drawLine(
                    start = Offset(x = 70.dp.toPx(), y = 0f),
                    end = Offset(x = 325.dp.toPx(), y = 0f),
                    color = Color.Gray,
                    strokeWidth = 2.dp.toPx()
                )
            }
            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                text = "¿Aún no tienes cuenta?",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.rubik)),
                    fontSize = 14.sp
                )
            )
            OutlinedButton(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(
                        start = 20.dp,
                        end = 20.dp
                    )
                    .fillMaxWidth(),
                border = BorderStroke(1.5.dp, colors.primary),
                onClick = {
                    navController.navigate(AppScreens.RegisterScreen.route)
                }
            ) {
                Text(
                    text = "Registrate",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.rubik)),
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight(550)
                    )
                )
            }

        }
        Spacer(modifier = Modifier.height(32.dp))

        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.4f)
        ) {
            drawArc(
                startAngle = 180f,
                sweepAngle = 180f,
                useCenter = true,
                color = colors.primary,
                size = Size(size.width,240.dp.toPx())
            )
        }
    }
}

@Composable
fun PasswordVisibleIcon(passVisible: MutableState<Boolean>) {
    val colors = MaterialTheme.colorScheme // Colores de la app
    val icon = if (passVisible.value) Icons.Default.Visibility else Icons.Outlined.Visibility

    IconButton(onClick = {
        passVisible.value = !passVisible.value
    }) {
        Icon(
            imageVector = icon,
            contentDescription = "",
            tint = colors.primary
        )
    }
}

//@Preview(
//    name = "Light Mode",
//    showBackground = true
//)
//@Preview(
//    uiMode = Configuration.UI_MODE_NIGHT_YES,
////    showBackground = true,
//    name = "Dark Mode"
//)
//@Composable
//fun LoginScreenPreview() {
//    EEATSAPPTheme {
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {
//            LoginScreen(navController)
//        }
//    }
//}