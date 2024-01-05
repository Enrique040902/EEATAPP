package mx.edu.itsm.e_eatsapp.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import mx.edu.itsm.e_eatsapp.R
import mx.edu.itsm.e_eatsapp.navigation.AppScreens

@Composable
fun RegisterScreen(navController: NavHostController) {
    val colors = MaterialTheme.colorScheme
    val icon = Icons.Default.ArrowBack

    Column(
        modifier = Modifier
            .fillMaxHeight(1F)
            .fillMaxWidth(1F)
            .padding(
                top = 16.dp,
                start = 16.dp,
                end = 16.dp
            )
    ) {
        val name = rememberSaveable {
            mutableStateOf("")
        }
        val apellido = rememberSaveable {
            mutableStateOf("")
        }
        val email = rememberSaveable {
            mutableStateOf("")
        }
        val password = rememberSaveable {
            mutableStateOf("")
        }
        val passVisible = rememberSaveable {
            mutableStateOf(false)
        }
        val passwordConfirmation = rememberSaveable {
            mutableStateOf("")
        }
        val passConfirmationVisible = rememberSaveable {
            mutableStateOf(false)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            IconButton(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Icon(
                    modifier = Modifier
                        .size(28.dp),
                    imageVector = icon,
                    contentDescription = null,
                    tint = colors.primary
                )
            }
            Text(
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 16.dp
                    )
                    .align(Alignment.CenterVertically),
                text = "Registro",
                style = TextStyle(
                    fontSize = 36.sp,
                    fontFamily = FontFamily(Font(R.font.rubik)),
                    color = colors.primary,
                    fontWeight = FontWeight(400)
                )
            )
        }

        // Nombre
        OutlinedTextField(
            modifier = Modifier
                .padding(
                    top = 18.dp
                )
                .fillMaxWidth(),
            value = name.value,
            onValueChange = { name.value = it },
            label = {
                Text(
                    text = "Nombre",
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

        // Apellido
        OutlinedTextField(
            modifier = Modifier
                .padding(
                    top = 18.dp
                )
                .fillMaxWidth(),
            value = apellido.value,
            onValueChange = { apellido.value = it },
            label = {
                Text(
                    text = "Apellido",
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

        // Email
        OutlinedTextField(
            modifier = Modifier
                .padding(
                    top = 18.dp
                )
                .fillMaxWidth(),
            value = email.value,
            onValueChange = { email.value = it },
            label = {
                Text(
                    text = stringResource(id = R.string.correo_eletronico),
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

        // Contraseña
        val visualTransformation = if (passVisible.value) VisualTransformation.None else PasswordVisualTransformation()
        OutlinedTextField(
            modifier = Modifier
                .padding(
                    top = 18.dp
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

        // Confirmar contraseña
        // Contraseña
        val visualConfirmationTransformation = if (passConfirmationVisible.value) VisualTransformation.None else PasswordVisualTransformation()
        OutlinedTextField(
            modifier = Modifier
                .padding(
                    top = 18.dp
                )
                .fillMaxWidth(),
            value = passwordConfirmation.value,
            onValueChange = { passwordConfirmation.value = it },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            label = {
                Text(
                    text = "Confirmar contaseña",
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
            visualTransformation = visualConfirmationTransformation,
            trailingIcon = {
                if (passwordConfirmation.value.isNotBlank()) {
                    PasswordConfirmationVisibleIcon(passConfirmationVisible)
                } else null
            }
        )

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(
                    top = 18.dp
                )
                .fillMaxWidth(),
            onClick = {
                navController.navigate(AppScreens.HomeScreen.route)
            }
        ) {
            Text(
                text = "Registrarme",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.rubik)),
                    color = Color.White
                )
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "¿Ya tienes cuenta?",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.rubik)),
                    fontSize = 14.sp
                )
            )
            val contextToast = LocalContext.current.applicationContext
            ClickableText(
                modifier = Modifier
                    .padding(start = 5.dp),
                text = AnnotatedString("Inicia seción"),
                onClick = {
                    navController.navigate(AppScreens.LoginScreen.route)
                },
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.rubik)),
                    fontWeight = FontWeight(750),
                    color = colors.primary
                )
            )
        }
//        Spacer(modifier = Modifier.height(120.dp))
    }

    Box(
        contentAlignment = Alignment.BottomCenter
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxHeight(0.12F)
                .fillMaxWidth()
                .alpha(0.4f)
        ) {
            drawArc(
                startAngle = 180f,
                sweepAngle = 180f,
                useCenter = false,
                color = colors.primary,
                size = Size(size.width, 240.dp.toPx())
            )
        }
    }

}

@Composable
fun PasswordConfirmationVisibleIcon(passConfirmationVisible: MutableState<Boolean>) {

    val colors = MaterialTheme.colorScheme // Colores de la app
    val icon = if (passConfirmationVisible.value) Icons.Default.Visibility else Icons.Outlined.Visibility

    IconButton(onClick = {
        passConfirmationVisible.value = !passConfirmationVisible.value
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
//    showBackground = true,
//    name = "Dark Mode"
//)
//@Composable
//fun RegisterScreenPreview() {
//    EEATSAPPTheme {
//        // A surface container using the 'background' color from the theme
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {
//            RegisterScreen(navController)
//        }
//    }
//}