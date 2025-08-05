package com.sj.corescreens.ui.auth.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sj.corescreens.ui.theme.AppScreensTheme
import com.sj.corescreens.ui.theme.CustomColor
import com.sj.corescreens.utils.AllPreview


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreenSix() {
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
            0.1f to CustomColor.purple_200,
            0.5f to CustomColor.purple_600,
            1f to CustomColor.purple_400
        )

        val textFiledColorStops = arrayOf(
            0.1f to CustomColor.purple_70,
            0.5f to CustomColor.purple_80,
            1f to CustomColor.purple_50
        )

        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Brush.verticalGradient(colorStops = colorStops))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                /**
                 * Screen logo section
                 */
                Text(
                    modifier = Modifier
                        .padding(
                            start = 16.dp,
                            top = 50.dp
                        ),
                    text = "MindFulMe",
                    color = Color.White,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    modifier = Modifier
                        .padding(
                            start = 16.dp,
                            top = 50.dp
                        ),
                    text = "Welcome Back!",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    modifier = Modifier
                        .padding(
                            start = 16.dp,
                            top = 12.dp
                        ),
                    text = "Login to your account",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400
                )

                // Email Text Field

                val interactionSourceEmail = remember { MutableInteractionSource() }

                BasicTextField(
                    value = email,
                    onValueChange = { email = it },
                    modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 26.dp,
                            top = 54.dp,
                            end = 26.dp
                        )
                        .background(
                            brush = Brush.horizontalGradient(colorStops = textFiledColorStops),
                            shape = RoundedCornerShape(12.dp)
                        )
                        .border(
                            width = 0.1.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(12.dp)
                        ),
                    visualTransformation = VisualTransformation.None,
                    interactionSource = interactionSourceEmail,
                    enabled = true,
                    singleLine = true,
                    textStyle = LocalTextStyle.current,
                    keyboardOptions =
                    KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    )
                ) { innerTextField ->
                    TextFieldDefaults.DecorationBox(
                        value = email.text,
                        shape = RoundedCornerShape(12.dp),
                        placeholder = { Text(text = "Email", color = Color.White) },
                        visualTransformation = VisualTransformation.None,
                        innerTextField = innerTextField,
                        singleLine = true,
                        enabled = true,
                        interactionSource = interactionSourceEmail,
                        contentPadding =
                        PaddingValues(
                            start = 20.dp,
                            top = 12.dp,
                            bottom = 12.dp,
                            end = 0.dp
                        ),
                        colors =
                        TextFieldDefaults.colors(
                            focusedTextColor = Color.White.copy(0.9f),
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        )
                    )
                }

                // Password Text Field

                val interactionSourcePassword = remember { MutableInteractionSource() }

                BasicTextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 26.dp,
                            end = 26.dp,
                            top = 16.dp
                        )
                        .background(
                            brush = Brush.horizontalGradient(colorStops = textFiledColorStops),
                            shape = RoundedCornerShape(12.dp)
                        )
                        .border(
                            width = 0.1.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(12.dp)
                        ),
                    visualTransformation = PasswordVisualTransformation(),
                    interactionSource = interactionSourcePassword,
                    enabled = true,
                    singleLine = true,
                    textStyle = LocalTextStyle.current,
                    keyboardOptions =
                    KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    )
                ) { innerTextField ->
                    TextFieldDefaults.DecorationBox(
                        value = password.text,
                        shape = RoundedCornerShape(12),
                        placeholder = { Text(text = "Password", color = Color.White) },
                        visualTransformation = PasswordVisualTransformation(),
                        innerTextField = innerTextField,
                        singleLine = true,
                        enabled = true,
                        interactionSource = interactionSourcePassword,
                        contentPadding =
                        PaddingValues(
                            start = 20.dp,
                            top = 12.dp,
                            bottom = 12.dp,
                            end = 0.dp
                        ),
                        colors =
                        TextFieldDefaults.colors(
                            focusedTextColor = Color.White,
                            focusedContainerColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        )
                    )
                }

                /**
                 * Forgot password text button
                 */
                TextButton(
                    modifier =
                    Modifier
                        .padding(
                            top = 4.dp,
                            start = 26.dp
                        )
                        .align(Alignment.Start),
                    onClick = { },
                    contentPadding = PaddingValues(
                        top = 6.dp,
                        bottom = 0.dp
                    )
                ) {
                    Text(
                        text = "Forgot your Password ?",
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
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
                            top = 240.dp,
                            start = 26.dp,
                            end = 26.dp
                        )
                        .shadow(
                            elevation = 2.dp,
                            shape = RoundedCornerShape(12.dp),
                            ambientColor = Color.Blue.copy(0.7f),
                            spotColor = Color.Blue.copy(0.7f)
                        )
                        .background(
                            color = CustomColor.purple_600,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .height(48.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
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
                        style = SpanStyle(color = Color.White.copy(0.8f))
                    ) {
                        append("Don't have an account?")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color.White.copy(0.9f),
                            fontWeight = FontWeight.SemiBold
                        )
                    ) {
                        append("  Sign Up")
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

                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@AllPreview
@Composable
fun LoginScreenSixPreview() {
    AppScreensTheme {
        Scaffold { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                LoginScreenSix()
            }
        }
    }
}
