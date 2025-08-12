//package com.sj.corescreens.ui.auth.screens.loginScreenOne
//
//import android.widget.Toast
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.interaction.MutableInteractionSource
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.imePadding
//import androidx.compose.foundation.layout.navigationBarsPadding
//import androidx.compose.foundation.layout.offset
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.text.BasicTextField
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.LocalTextStyle
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextFieldDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalConfiguration
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.input.ImeAction
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.text.input.PasswordVisualTransformation
//import androidx.compose.ui.text.input.TextFieldValue
//import androidx.compose.ui.text.input.VisualTransformation
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.PreviewLightDark
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.sj.corescreens.R
//import com.sj.corescreens.ui.theme.AppScreensTheme
//import com.sj.corescreens.ui.theme.CustomColor
//
//
//@Composable
//fun SignupScreenOne() {
//    /**
//     * Local context is use here for toast context
//     */
//    val context = LocalContext.current
//
//    /**
//     * email state is use for hold email address, initially is empty
//     */
//    var name by remember {
//        mutableStateOf(
//            TextFieldValue(
//                text = ""
//            )
//        )
//    }
//
//    var username by remember {
//        mutableStateOf(
//            TextFieldValue(
//                text = ""
//            )
//        )
//    }
//
//    var confirmPassword by remember {
//        mutableStateOf(
//            TextFieldValue(
//                text = ""
//            )
//        )
//    }
//
//    var email by remember {
//        mutableStateOf(
//            TextFieldValue(
//                text = ""
//            )
//        )
//    }
//
//    /**
//     * password state is uee for hold password, initially is empty
//     */
//    var password by remember {
//        mutableStateOf(
//            TextFieldValue(
//                text = ""
//            )
//        )
//    }
//
//    Scaffold(
//        modifier = Modifier
//            .navigationBarsPadding()
//            .imePadding()
//    ) { innerPadding ->
//        Column(
//            modifier =
//                Modifier
//                    .fillMaxSize()
//                    .padding(innerPadding)
//                    .verticalScroll(rememberScrollState())
//        ) {
//            /**
//             * Here is screen's top bar
//             */
//            SignupScreenOneTopBackground()
//
//            NameInputField(
//                name = name,
//                onValueChange = { name = it }
//            )
//
//            UsernameInputField(
//                username = username,
//                onValueChange = { username = it }
//            )
//
//            EmailInputField(
//                email = email,
//                onValueChange = { email = it }
//            )
//
//            PasswordInputField(
//                password = password,
//                onValueChange = { password = it }
//            )
//
//            ConfirmPasswordInputField(
//                confirmPassword = confirmPassword,
//                onValueChange = { confirmPassword = it }
//            )
//
//
//            Spacer(modifier = Modifier.height(48.dp))
//
//            /**
//             * Here is screen signUp button
//             */
//            val signUpButtonClicked = stringResource(R.string.sign_up_btn_clicked)
//            val validationError = stringResource(R.string.please_fill_all_fields)
//            val passwordMismatch = stringResource(R.string.password_mismatch)
//
//            Button(
//                modifier = Modifier
//                    .height(48.dp)
//                    .fillMaxWidth()
//                    .padding(start = 16.dp, end = 16.dp),
//                shape = RoundedCornerShape(8.dp),
//                onClick = {
//                    if (
//                        name.text.isBlank() ||
//                        username.text.isBlank() ||
//                        email.text.isBlank() ||
//                        password.text.isBlank() ||
//                        confirmPassword.text.isBlank()
//                    ) {
//                        Toast.makeText(context, validationError, Toast.LENGTH_SHORT).show()
//                    } else if (password.text != confirmPassword.text) {
//                        Toast.makeText(context, passwordMismatch, Toast.LENGTH_SHORT).show()
//                    } else {
//                        Toast.makeText(context, signUpButtonClicked, Toast.LENGTH_SHORT).show()
//                        // You can also trigger API call here or navigate to the next screen
//                    }
//                },
//                colors = ButtonDefaults.buttonColors(containerColor = CustomColor.deepGray)
//            ) {
//                Text(
//                    text = stringResource(R.string.sign_up),
//                    color = Color.White
//                )
//            }
//
//
//            Row(
//                modifier =
//                    Modifier
//                        .fillMaxWidth()
//                        .padding(
//                            start = 16.dp,
//                            top = 32.dp,
//                            end = 16.dp,
//                            bottom = 20.dp
//                        ),
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                val facebookButtonClicked = stringResource()
//                Button(
//                    modifier =
//                        Modifier
//                            .height(52.dp)
//                            .weight(1f),
//                    shape = RoundedCornerShape(8.dp),
//                    onClick = {
//                        Toast.makeText(context, facebookButtonClicked, Toast.LENGTH_SHORT).show()
//                    },
//                    colors = ButtonDefaults
//                        .buttonColors(containerColor = Color.Gray.copy(0.4f))
//                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.facebook),
//                        contentDescription = "Sign in with Facebook"
//                    )
//                }
//
//                Spacer(modifier = Modifier.width(40.dp))
//
//                val gmailButtonClicked = stringResource(R.string.gmail_btn_clicked)
//                Button(
//                    modifier =
//                        Modifier
//                            .height(52.dp)
//                            .weight(1f),
//                    shape = RoundedCornerShape(8.dp),
//                    onClick = {
//                        Toast.makeText(context, gmailButtonClicked, Toast.LENGTH_SHORT).show()
//                    },
//                    colors = ButtonDefaults
//                        .buttonColors(containerColor = Color.Gray.copy(0.4f))
//                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.gmail),
//                        contentDescription = "Sign in with Google"
//
//                    )
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun SignupScreenOneTopBackground(
//    modifier: Modifier = Modifier
//) {
//    /**
//     * Give the local device information
//     */
//    val configuration = LocalConfiguration.current
//
//    val width = configuration.screenWidthDp
//
//    /**
//     * Calculate the box width base on configuration width
//     * here 1.5f is working all devices
//     */
//    val topBoxCircleWidth = width / 1.5f
//
//    Box(
//        modifier = modifier.fillMaxWidth()
//    ) {
//        /**
//         * Left side box calculate base @tobBoxCircleWidth
//         */
//
//        Box(
//            modifier = Modifier
//                .offset(
//                    x = 0.dp,
//                    y = (-20).dp
//                )
//                .width(topBoxCircleWidth.dp)
//                .height(320.dp)
//                .background(
//                    color = CustomColor.purple_600,
//                    shape = RoundedCornerShape(
//                        topStart = 0.dp,
//                        topEnd = 0.dp,
//                        bottomStart = 0.dp,
//                        bottomEnd = 250.dp
//                    )
//                )
//        ) {
//            Text(
//                modifier = Modifier
//                    .padding(
//                        start = 16.dp,
//                        top = 120.dp
//                    ),
//                text = stringResource(R.string.create_acount),
//                textAlign = TextAlign.Start,
//                fontSize = 38.sp,
//                fontWeight = FontWeight.Bold,
//                color = Color.White,
//                lineHeight = 36.sp
//            )
//        }
//
//        /**
//         * Right side box calculate base @tobBoxCircleWidth
//         */
//        Box(
//            modifier = Modifier
//                .offset(
//                    x = topBoxCircleWidth.dp - 55.dp,
//                    y = (-32).dp
//                )
//                .width(topBoxCircleWidth.dp)
//                .height(300.dp)
//                .background(
//                    color = CustomColor.deepGray,
//                    shape = CircleShape
//                )
//        )
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//private fun NameInputField(
//    modifier: Modifier = Modifier,
//    name: TextFieldValue,
//    onValueChange: (TextFieldValue) -> Unit
//) {
//    BasicTextField(
//        value = name,
//        onValueChange = onValueChange,
//        modifier = modifier
//            .fillMaxWidth()
//            .padding(start = 16.dp, top = 16.dp, end = 16.dp),
//        visualTransformation = VisualTransformation.None,
//        interactionSource = remember { MutableInteractionSource() },
//        enabled = true,
//        singleLine = true,
//        textStyle = LocalTextStyle.current,
//        keyboardOptions = KeyboardOptions(
//            keyboardType = KeyboardType.Text,
//            imeAction = ImeAction.Next
//        )
//    ) { innerTextField ->
//        TextFieldDefaults.DecorationBox(
//            value = name.text,
//            placeholder = {
//                Text(text = stringResource(R.string.name))
//            },
//            visualTransformation = VisualTransformation.None,
//            innerTextField = innerTextField,
//            singleLine = true,
//            enabled = true,
//            interactionSource = remember { MutableInteractionSource() },
//            contentPadding = PaddingValues(start = 0.dp, top = 8.dp, bottom = 8.dp, end = 0.dp),
//            colors = TextFieldDefaults.colors(
//                focusedContainerColor = Color.Blue,
//                unfocusedContainerColor = Color.Transparent
//            )
//        )
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//private fun UsernameInputField(
//    modifier: Modifier = Modifier,
//    username: TextFieldValue,
//    onValueChange: (TextFieldValue) -> Unit
//) {
//    BasicTextField(
//        value = username,
//        onValueChange = onValueChange,
//        modifier = modifier
//            .fillMaxWidth()
//            .padding(start = 16.dp, top = 16.dp, end = 16.dp),
//        visualTransformation = VisualTransformation.None,
//        interactionSource = remember { MutableInteractionSource() },
//        enabled = true,
//        singleLine = true,
//        textStyle = LocalTextStyle.current,
//        keyboardOptions = KeyboardOptions(
//            keyboardType = KeyboardType.Text,
//            imeAction = ImeAction.Next
//        )
//    ) { innerTextField ->
//        TextFieldDefaults.DecorationBox(
//            value = username.text,
//            placeholder = {
//                Text(text = stringResource(R.string.username))
//            },
//            visualTransformation = VisualTransformation.None,
//            innerTextField = innerTextField,
//            singleLine = true,
//            enabled = true,
//            interactionSource = remember { MutableInteractionSource() },
//            contentPadding = PaddingValues(start = 0.dp, top = 8.dp, bottom = 8.dp, end = 0.dp),
//            colors = TextFieldDefaults.colors(
//                focusedContainerColor = Color.Blue,
//                unfocusedContainerColor = Color.Transparent
//            )
//        )
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//private fun EmailInputField(
//    modifier: Modifier = Modifier,
//    email: TextFieldValue,
//    onValueChange: (TextFieldValue) -> Unit
//) {
//    BasicTextField(
//        value = email,
//        onValueChange = onValueChange,
//        modifier = modifier
//            .fillMaxWidth()
//            .padding(
//                start = 16.dp,
//                top = 16.dp,
//                end = 16.dp
//            ),
//        visualTransformation = VisualTransformation.None,
//        interactionSource = remember { MutableInteractionSource() },
//        enabled = true,
//        singleLine = true,
//        textStyle = LocalTextStyle.current,
//        keyboardOptions =
//            KeyboardOptions(
//                keyboardType = KeyboardType.Text,
//                imeAction = ImeAction.Next
//            )
//    ) { innerTextField ->
//        TextFieldDefaults.DecorationBox(
//            value = email.text,
//            placeholder = {
//                Text(text = stringResource(R.string.email))
//            },
//            visualTransformation = VisualTransformation.None,
//            innerTextField = innerTextField,
//            singleLine = true,
//            enabled = true,
//            interactionSource = remember { MutableInteractionSource() },
//            contentPadding =
//                PaddingValues(
//                    start = 0.dp,
//                    top = 8.dp,
//                    bottom = 8.dp,
//                    end = 0.dp
//                ),
//            colors = TextFieldDefaults.colors(
//                focusedContainerColor = Color.Blue,
//                unfocusedContainerColor = Color.Transparent
//            )
//        )
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//private fun PasswordInputField(
//    modifier: Modifier = Modifier,
//    password: TextFieldValue,
//    onValueChange: (TextFieldValue) -> Unit
//) {
//    BasicTextField(
//        value = password,
//        onValueChange = onValueChange,
//        modifier = modifier
//            .fillMaxWidth()
//            .padding(start = 16.dp, top = 16.dp, end = 16.dp),
//        visualTransformation = PasswordVisualTransformation(),
//        interactionSource = remember { MutableInteractionSource() },
//        enabled = true,
//        singleLine = true,
//        textStyle = LocalTextStyle.current,
//        keyboardOptions =
//            KeyboardOptions(
//                keyboardType = KeyboardType.Password,
//                imeAction = ImeAction.Done
//            )
//    ) { innerTextField ->
//        TextFieldDefaults.DecorationBox(
//            value = password.text,
//            placeholder = { Text(text = stringResource(R.string.password)) },
//            visualTransformation = PasswordVisualTransformation(),
//            innerTextField = innerTextField,
//            singleLine = true,
//            enabled = true,
//            interactionSource = remember { MutableInteractionSource() },
//            contentPadding =
//                PaddingValues(
//                    start = 0.dp,
//                    top = 8.dp,
//                    bottom = 8.dp,
//                    end = 0.dp
//                ),
//            colors = TextFieldDefaults.colors(
//                focusedContainerColor = Color.Transparent,
//                unfocusedContainerColor = Color.Transparent
//            )
//        )
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//private fun ConfirmPasswordInputField(
//    modifier: Modifier = Modifier,
//    confirmPassword: TextFieldValue,
//    onValueChange: (TextFieldValue) -> Unit
//) {
//    BasicTextField(
//        value = confirmPassword,
//        onValueChange = onValueChange,
//        modifier = modifier
//            .fillMaxWidth()
//            .padding(start = 16.dp, top = 16.dp, end = 16.dp),
//        visualTransformation = PasswordVisualTransformation(),
//        interactionSource = remember { MutableInteractionSource() },
//        enabled = true,
//        singleLine = true,
//        textStyle = LocalTextStyle.current,
//        keyboardOptions = KeyboardOptions(
//            keyboardType = KeyboardType.Password,
//            imeAction = ImeAction.Done
//        )
//    ) { innerTextField ->
//        TextFieldDefaults.DecorationBox(
//            value = confirmPassword.text,
//            placeholder = {
//                Text(text = stringResource(R.string.confirm_password))
//            },
//            visualTransformation = PasswordVisualTransformation(),
//            innerTextField = innerTextField,
//            singleLine = true,
//            enabled = true,
//            interactionSource = remember { MutableInteractionSource() },
//            contentPadding = PaddingValues(start = 0.dp, top = 8.dp, bottom = 8.dp, end = 0.dp),
//            colors = TextFieldDefaults.colors(
//                focusedContainerColor = Color.Blue,
//                unfocusedContainerColor = Color.Transparent
//            )
//        )
//    }
//}
//
///**
// * Signup Screen preview
// * here all preview is a custom preview that we have added
// */
//@PreviewLightDark
//@Composable
//fun SignupScreenOnePreview() {
//    AppScreensTheme {
//        Scaffold { innerPadding ->
//            Column(
//                modifier = Modifier
//                    .padding(innerPadding)
//            ) {
//                SignupScreenOne()
//            }
//        }
//    }
//}