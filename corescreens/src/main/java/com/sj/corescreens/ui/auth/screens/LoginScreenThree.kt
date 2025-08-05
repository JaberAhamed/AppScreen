package com.sj.corescreens.ui.auth.screens

import android.widget.Toast
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sj.corescreens.R
import com.sj.corescreens.ui.theme.CustomColor
import com.sj.corescreens.utils.AllPreview
import com.sj.corescreens.utils.toPx

@Composable
fun LoginScreenThree() {
    /**
     * Local context is use here for toast context
     */
    val context = LocalContext.current

    /**
     * username state is use for hold username, initially is empty
     */
    var userName by remember {
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

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            LoginScreenThreeBackground()

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    modifier =
                    Modifier.padding(
                        start = 16.dp,
                        top = 200.dp
                    ),
                    text = stringResource(R.string.welcome_back),
                    textAlign = TextAlign.Start,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black.copy(0.9f),
                    lineHeight = 28.sp
                )

                Text(
                    modifier =
                    Modifier.padding(
                        start = 16.dp,
                        top = 4.dp
                    ),
                    text = stringResource(R.string.enter_your_user_name_password),
                    textAlign = TextAlign.Start,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.scrim
                )

                UserNameInputField(
                    userName = userName,
                    onValueChange = {
                        userName = it
                    }
                )

                PasswordInputField(
                    password = password,
                    onValueChange = {
                        password = it
                    }
                )

                /**
                 * Here is screen signIn button
                 */
                val signInButtonClicked = stringResource(R.string.sign_in_btn_clicked)
                val validationError = stringResource(R.string.please_fill_all_fields)
                Button(
                    modifier =
                    Modifier
                        .padding(
                            top = 40.dp,
                            start = 16.dp,
                            end = 16.dp
                        )
                        .height(44.dp)
                        .fillMaxWidth(),
                    shape = ButtonDefaults.shape,
                    onClick = {
                        if (userName.text.isEmpty() || password.text.isEmpty()) {
                            Toast.makeText(context, validationError, Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(context, signInButtonClicked, Toast.LENGTH_SHORT).show()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black.copy(0.9f))
                ) {
                    Text(
                        text = stringResource(R.string.login),
                        color = Color.White
                    )
                }

                /**
                 * Forgot password text button
                 */
                val forgotButtonClicked = stringResource(R.string.forgot_password_btn_click)

                TextButton(
                    modifier =
                    Modifier.padding(
                        start = 16.dp,
                        top = 6.dp

                    ),
                    onClick = {
                        Toast.makeText(context, forgotButtonClicked, Toast.LENGTH_SHORT).show()
                    },
                    contentPadding = PaddingValues(top = 0.dp, bottom = 0.dp)
                ) {
                    Text(
                        modifier = Modifier,
                        text = stringResource(R.string.forgot_password),
                        color = MaterialTheme.colorScheme.outline
                    )
                }

                /**
                 * Sign up screen navigation section
                 */
                val gotoSignUpScreen = stringResource(R.string.goto_to_sign_up_screen)
                val text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(color = Color.Gray)
                    ) {
                        append(stringResource(R.string.do_not_have_account))
                    }
                    withStyle(
                        style = SpanStyle(color = Color.Black.copy(0.9f), fontWeight = FontWeight.SemiBold)
                    ) {
                        append(stringResource(R.string.sign_up))
                    }
                }

                Text(
                    text = text,
                    modifier = Modifier
                        .padding(
                            start = 16.dp
                        )
                        .clickable {
                            Toast.makeText(context, gotoSignUpScreen, Toast.LENGTH_SHORT).show()
                        }
                )

                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

/**
 * Here calculate oval box size base on screen size
 */
@Composable
fun LoginScreenThreeBackground(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    val colorStops = arrayOf(
        0.0f to CustomColor.lightBrown.copy(0.8f),
        0.5f to CustomColor.lightSky.copy(0.8f),
        1f to CustomColor.lightBrown.copy(0.8f)
    )
    val colorStops1 = arrayOf(
        0.0f to CustomColor.lightBrown,
        0.4f to CustomColor.blue.copy(0.6f),
        1f to CustomColor.lightBrown.copy(0.6f)
    )
    Box(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding()
    ) {
        val sizeOfOval = Size(
            width = screenWidth.toPx(context = context),
            height = screenWidth.toPx(context = context) - 100f
        )

        Canvas(
            modifier = Modifier
                .padding(top = screenHeight / 5.5f)
                .offset(x = -screenWidth / 4f)
                .fillMaxSize()
        ) {
            drawOval(
                brush = Brush.horizontalGradient(colorStops = colorStops),
                size = sizeOfOval
            )
        }

        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = screenHeight / 2.3f)
                .offset(x = screenWidth / 10.2f)

        ) {
            drawOval(
                brush = Brush.horizontalGradient(colorStops = colorStops1),
                size = Size(sizeOfOval.width * 1.2f, sizeOfOval.height * 1.1f)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun UserNameInputField(
    modifier: Modifier = Modifier,
    userName: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit
) {
    BasicTextField(
        value = userName,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                top = 60.dp,
                end = 16.dp
            ),
        visualTransformation = VisualTransformation.None,
        interactionSource = remember { MutableInteractionSource() },
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
            value = userName.text,
            placeholder = {
                Text(
                    text = stringResource(R.string.username),
                    color = MaterialTheme.colorScheme.outline
                )
            },
            visualTransformation = VisualTransformation.None,
            innerTextField = innerTextField,
            singleLine = true,
            enabled = true,
            interactionSource = remember { MutableInteractionSource() },
            contentPadding =
            PaddingValues(
                start = 0.dp,
                top = 8.dp,
                bottom = 8.dp,
                end = 0.dp
            ),
            colors =
            TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PasswordInputField(
    modifier: Modifier = Modifier,
    password: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit
) {
    BasicTextField(
        value = password,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 20.dp
            ),
        visualTransformation = PasswordVisualTransformation(),
        interactionSource = remember { MutableInteractionSource() },
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
            placeholder = {
                Text(
                    text = stringResource(R.string.password),
                    color = MaterialTheme.colorScheme.outline
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            innerTextField = innerTextField,
            singleLine = true,
            enabled = true,
            interactionSource = remember { MutableInteractionSource() },
            contentPadding =
            PaddingValues(
                start = 0.dp,
                top = 8.dp,
                bottom = 8.dp,
                end = 0.dp
            ),
            colors =
            TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            )
        )
    }
}

@AllPreview
@Composable
fun LoginScreenThreePreview() {
    MaterialTheme {
        Scaffold { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                LoginScreenThree()
            }
        }
    }
}
