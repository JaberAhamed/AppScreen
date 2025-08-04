package com.sj.corescreens.ui.auth.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.mj.appscreens.R
import org.mj.appscreens.ui.theme.AppScreensTheme

@Composable
fun LoginScreenNine() {
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(171.dp)
                    .background(color = MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ) {
                /**
                 * Screen logo section
                 */
                Text(
                    text = "LifeLog",
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.W700

                )
            }

            Text(
                text = "Sign in to LifeLog",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 24.sp,
                fontWeight = FontWeight.W700,
                modifier = Modifier.padding(top = 24.dp)
            )

            Text(
                text = "LifeLog helps you to find good friend.",
                color = MaterialTheme.colorScheme.outline,
                fontSize = 14.sp,
                fontWeight = FontWeight.W400,
                modifier = Modifier.padding(top = 12.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(
                        color = MaterialTheme.colorScheme.background,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(
                        start = 20.dp,
                        end = 20.dp,
                        top = 16.dp
                    )
                    .shadow(
                        elevation = 2.dp,
                        spotColor = MaterialTheme.colorScheme.onSurface,
                        ambientColor = MaterialTheme.colorScheme.surface,
                        shape = RoundedCornerShape(12.dp)
                    )

            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(bottom = 16.dp)
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                start = 16.dp,
                                top = 16.dp,
                                end = 16.dp
                            ),
                        text = "Email",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.W500
                    )

                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                start = 16.dp,
                                top = 6.dp,
                                end = 16.dp
                            ),
                        value = email,

                        onValueChange = { email = it },
                        placeholder = {
                            Text(text = "example@gmail.com")
                        },
                        shape = RoundedCornerShape(6.dp),
                        textStyle = TextStyle(fontSize = 14.sp),
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
                        fontSize = 15.sp,
                        fontWeight = FontWeight.W500
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
                        shape = RoundedCornerShape(6.dp),
                        textStyle = TextStyle(fontSize = 14.sp),
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
                            fontWeight = FontWeight.W500,
                            fontSize = 14.sp
                        )
                    }

                    /**
                     * Here is screen signIn button
                     */
                    Button(
                        modifier =
                        Modifier
                            .height(48.dp)
                            .fillMaxWidth()
                            .padding(
                                start = 16.dp,
                                end = 16.dp
                            ),

                        shape = RoundedCornerShape(6.dp),
                        onClick = {}
                    ) {
                        Text(
                            text = "SIGN IN"
                        )
                    }
                }
            }

            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = "Or continue with social account",
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 14.sp
            )

            /**
             * Social sign up section
             */
            Row(
                modifier = Modifier.padding(
                    start = 16.dp,
                    top = 12.dp,
                    end = 16.dp
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedButton(
                    modifier = Modifier
                        .weight(1f)
                        .height(58.dp)
                        .padding(
                            top = 8.dp,
                            end = 6.dp
                        ),
                    shape = RoundedCornerShape(
                        size = 6.dp

                    ),
                    onClick = { }
                ) {
                    Image(
                        modifier = Modifier.size(26.dp),
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "Description"
                    )

                    Spacer(modifier = Modifier.width(2.dp))

                    Text(
                        text = "Google",
                        color = MaterialTheme.colorScheme.primary
                    )
                }

                OutlinedButton(
                    modifier = Modifier
                        .height(58.dp)
                        .weight(1f)
                        .padding(
                            start = 6.dp,
                            top = 8.dp
                        ),
                    shape = RoundedCornerShape(
                        size = 6.dp

                    ),
                    onClick = { }
                ) {
                    Icon(
                        modifier = Modifier.size(26.dp),
                        painter = painterResource(id = R.drawable.facebook),
                        contentDescription = "Description",
                        tint = Color.Blue.copy(0.6f)
                    )

                    Spacer(modifier = Modifier.width(2.dp))

                    Text(
                        text = "Facebook",
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
fun LoginScreenNinePreview() {
    AppScreensTheme {
        Scaffold { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                LoginScreenNine()
            }
        }
    }
}
