package org.mj.appscreens.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.mj.appscreens.ui.theme.AppScreensTheme
import org.mj.appscreens.ui.theme.CustomColor
import org.mj.appscreens.utils.AllPreview

@Composable
fun LoginScreenSeven() {
    /**
     * email state is use for hold email address, initially is empty
     */
    var email by remember {
        mutableStateOf(
            TextFieldValue(
                text = ""
            )
        )
    }

    /**
     * password state is uee for hold password, initially is empty
     */
    var password by remember {
        mutableStateOf(
            TextFieldValue(
                text = ""
            )
        )
    }

    Scaffold(
        modifier = Modifier
            .navigationBarsPadding()
            .imePadding()
    ) { innerPadding ->
        val colorStops = arrayOf(
            0.2f to CustomColor.crayon_500.copy(0.8f),
            0.5f to CustomColor.crayon_600.copy(0.7f)
        )

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(
                        Brush.verticalGradient(
                            colorStops = colorStops
                        )
                    )

            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    /**
                     * Screen Top section
                     */
                    Text(
                        modifier = Modifier.padding(
                            start = 16.dp,
                            top = 80.dp
                        ),
                        text = "Hello.",
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Yellow.copy(0.6f),
                        fontSize = 36.sp
                    )

                    Text(
                        modifier = Modifier.padding(
                            start = 16.dp,
                            top = 12.dp
                        ),
                        text = "Welcome Back!",
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        fontSize = 36.sp
                    )

                    Box(
                        modifier = Modifier
                            .padding(top = 50.dp)
                            .background(
                                color = MaterialTheme.colorScheme.onSecondary,
                                shape = RoundedCornerShape(
                                    topStart = 40.dp,
                                    topEnd = 40.dp
                                )
                            )
                            .fillMaxSize()

                    ) {
                        Column {
                            Text(
                                modifier = Modifier
                                    .padding(top = 20.dp)
                                    .fillMaxWidth(),
                                text = "Login",
                                color = MaterialTheme.colorScheme.onSurface,
                                fontSize = 30.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        start = 16.dp,
                                        top = 20.dp,
                                        end = 16.dp
                                    ),
                                text = "Email",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.W500,
                                color = MaterialTheme.colorScheme.onSurface
                            )

                            OutlinedTextField(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        start = 16.dp,
                                        top = 8.dp,
                                        end = 16.dp
                                    ),
                                value = email,

                                onValueChange = { email = it },
                                placeholder = {
                                    Text(text = "example@gmail.com")
                                },
                                shape = RoundedCornerShape(20.dp),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                            )

                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        start = 16.dp,
                                        top = 16.dp,
                                        end = 16.dp
                                    ),
                                text = "Password",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.W500,
                                color = MaterialTheme.colorScheme.onSurface
                            )

                            OutlinedTextField(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        start = 16.dp,
                                        top = 8.dp,
                                        end = 16.dp
                                    ),
                                value = password,
                                onValueChange = { password = it },
                                placeholder = {
                                    Text(text = "password")
                                },
                                visualTransformation = PasswordVisualTransformation(),
                                shape = RoundedCornerShape(20.dp),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                            )

                            /**
                             * Forgot password text button
                             */
                            TextButton(
                                modifier =
                                Modifier
                                    .padding(
                                        top = 4.dp,
                                        end = 16.dp
                                    )
                                    .align(Alignment.End),
                                onClick = { },
                                contentPadding = PaddingValues(
                                    top = 0.dp,
                                    bottom = 0.dp
                                )
                            ) {
                                Text(
                                    text = "Forgot your Password ?",
                                    fontWeight = FontWeight.SemiBold,
                                    color = MaterialTheme.colorScheme.onSurface,
                                    fontSize = 14.sp
                                )
                            }

                            /**
                             * Here is screen signIn button
                             */
                            TextButton(
                                modifier =
                                Modifier
                                    .padding(
                                        top = 16.dp,
                                        start = 16.dp,
                                        end = 16.dp
                                    )
                                    .shadow(
                                        elevation = 6.dp,
                                        shape = RoundedCornerShape(10.dp),
                                        ambientColor = Color.Blue.copy(0.7f),
                                        spotColor = Color.Blue.copy(0.7f)
                                    )
                                    .background(
                                        Brush.linearGradient(
                                            colors = listOf(
                                                CustomColor.crayon_500,
                                                CustomColor.purple_500
                                            )
                                        ),
                                        shape = RoundedCornerShape(20.dp)
                                    )
                                    .height(44.dp)
                                    .fillMaxWidth(),
                                shape = RoundedCornerShape(20.dp),
                                onClick = { }

                            ) {
                                Text(
                                    text = "Login",
                                    color = Color.White,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }

                            /**
                             * Sign up screen navigation section
                             */
                            val text = buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(color = MaterialTheme.colorScheme.outline)
                                ) {
                                    append("Don't have an account?")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        color = MaterialTheme.colorScheme.onSurface,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                ) {
                                    append(" Sign Up")
                                }
                            }

                            Text(
                                text = text,
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally)
                                    .padding(
                                        top = 24.dp,
                                        start = 16.dp
                                    )
                                    .clickable {
                                    }
                            )

                            Spacer(modifier = Modifier.height(200.dp))
                        }
                    }
                }
            }
        }
    }
}

@AllPreview
@Composable
fun LoginScreenSevenPreview() {
    AppScreensTheme {
        Scaffold { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                LoginScreenSeven()
            }
        }
    }
}
