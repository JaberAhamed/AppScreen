//package com.sj.corescreens.ui.auth.screens.loginScreenTwo
//
//import com.sj.corescreens.ui.theme.AppScreensTheme
//import android.widget.Toast
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.interaction.MutableInteractionSource
//import androidx.compose.foundation.interaction.collectIsFocusedAsState
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
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextButton
//import androidx.compose.material3.TextFieldDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.shadow
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
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
//
//
//@Composable
//fun SignupScreenTwo() {
//    /**
//     * Local context is use here for toast context
//     */
//    val context = LocalContext.current
//
//    /**
//     * fullName state is uee for hold fullName, initially is empty
//     */
//    var name by remember {
//        mutableStateOf(
//            TextFieldValue(
//                text = ""
//            )
//        )
//    }
//
//    /**
//     * username state is uee for hold username, initially is empty
//     */
//    var username by remember {
//        mutableStateOf(
//            TextFieldValue(
//                text = ""
//            )
//        )
//    }
//
//    /**
//     * email state is use for hold email address, initially is empty
//     */
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
//    /**
//     * confirmPassword state is uee for hold confirmPassword, initially is empty
//     */
//    var confirmPassword by remember {
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
//        Column(modifier = Modifier.padding(innerPadding)) {
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//            ) {
//                /**
//                 * Screen top background
//                 */
//                SignupScreenTwoBackground()
//
//                /**
//                 * Screen bottom image background
//                 */
//                Image(
//                    modifier = Modifier.align(Alignment.BottomStart),
//                    contentScale = ContentScale.Fit,
//                    painter = painterResource(id = R.drawable.bottom_line),
//                    contentDescription = "Screen background image"
//                )
//
//                Column(
//                    modifier =
//                        Modifier
//                            .fillMaxWidth()
//                            .verticalScroll(rememberScrollState()),
//                    horizontalAlignment = Alignment.CenterHorizontally
//
//                ) {
//                    Text(
//                        modifier = Modifier.padding(top = 97.dp),
//                        text = stringResource(R.string.signup_here),
//                        color = MaterialTheme.colorScheme.primary,
//                        fontSize = 30.sp,
//                        fontWeight = FontWeight.Bold
//                    )
//
//                    Spacer(modifier = Modifier.padding(top = 26.dp))
//
//                    Text(
//                        modifier = Modifier.padding(
//                            start = 98.dp,
//                            end = 98.dp
//                        ),
//                        text = stringResource(R.string.create_an_account),
//                        fontSize = 18.sp,
//                        fontWeight = FontWeight.SemiBold,
//                        textAlign = TextAlign.Center,
//                        color = MaterialTheme.colorScheme.onSecondaryContainer
//                    )
//
//                    NameInputField(
//                        name = name,
//                        onValueChange = {
//                            name = it
//                        }
//                    )
//
//                    UsernameInputField(
//                        username = username,
//                        onValueChange = {
//                            username = it
//                        }
//                    )
//
//                    EmailInputField(
//                        email = email,
//                        onValueChange = {
//                            email = it
//                        }
//                    )
//
//                    PasswordInputField(
//                        password = password,
//                        onValueChange = {
//                            password = it
//                        }
//                    )
//
//                    ConfirmPasswordInputField(
//                        confirmPassword = confirmPassword,
//                        onValueChange = {
//                            confirmPassword = it
//                        }
//                    )
//
//                    /**
//                     * Here is screen signIn button
//                     */
//                    val signUpButtonClicked = stringResource(R.string.sign_in_btn_clicked)
//                    val validationError = stringResource(R.string.please_fill_all_fields)
//                    val passwordMismatch = stringResource(R.string.password_mismatch)
//
//                    Button(
//                        modifier =
//                            Modifier
//                                .height(48.dp)
//                                .fillMaxWidth()
//                                .padding(
//                                    start = 16.dp,
//                                    end = 16.dp
//                                )
//                                .shadow(
//                                    elevation = 6.dp,
//                                    shape = RoundedCornerShape(8.dp),
//                                    spotColor = Color.Blue.copy(0.5f)
//                                ),
//
//                        shape = RoundedCornerShape(8.dp),
//                        onClick = {
//                            if (
//                                name.text.isBlank() ||
//                                username.text.isBlank() ||
//                                email.text.isBlank() ||
//                                password.text.isBlank() ||
//                                confirmPassword.text.isBlank()
//                            ) {
//                                Toast.makeText(context, validationError, Toast.LENGTH_SHORT).show()
//                            } else if (password.text != confirmPassword.text) {
//                                Toast.makeText(context, passwordMismatch, Toast.LENGTH_SHORT).show()
//                            } else {
//                                Toast.makeText(context, signUpButtonClicked, Toast.LENGTH_SHORT).show()
//                                // You can also trigger API call here or navigate to the next screen
//                            }
//                        },
//                        colors = ButtonDefaults.buttonColors(
//                            containerColor = MaterialTheme.colorScheme.primary
//                        )
//                    ) {
//                        Text(
//                            text = stringResource(R.string.sign_up),
//                            color = Color.White
//                        )
//                    }
//
//                    Text(
//                        modifier = Modifier.padding(top = 24.dp),
//                        text = stringResource(R.string.or_with),
//                        fontWeight = FontWeight.SemiBold,
//                        color = MaterialTheme.colorScheme.primary,
//                        fontSize = 14.sp
//                    )
//
//                    Row(
//                        modifier =
//                            Modifier
//                                .fillMaxWidth()
//                                .padding(
//                                    start = 16.dp,
//                                    top = 32.dp,
//                                    end = 16.dp,
//                                    bottom = 20.dp
//                                ),
//                        horizontalArrangement = Arrangement.Center
//                    ) {
//                        Box(
//                            modifier =
//                                Modifier
//                                    .height(52.dp)
//                                    .width(60.dp)
//                                    .background(
//                                        color = MaterialTheme.colorScheme.primary,
//                                        shape = RoundedCornerShape(8.dp)
//                                    ),
//                            contentAlignment = Alignment.Center
//
//                        ) {
//                            Image(
//                                contentScale = ContentScale.Fit,
//                                painter = painterResource(id = R.drawable.facebook),
//                                contentDescription = "Sign in with Facebook"
//                            )
//                        }
//
//                        Spacer(modifier = Modifier.width(40.dp))
//
//                        Box(
//                            modifier =
//                                Modifier
//                                    .height(52.dp)
//                                    .width(60.dp)
//                                    .background(
//                                        color = MaterialTheme.colorScheme.primary,
//                                        shape = RoundedCornerShape(8.dp)
//                                    ),
//                            contentAlignment = Alignment.Center
//
//                        ) {
//                            Image(
//                                contentScale = ContentScale.Fit,
//                                painter = painterResource(id = R.drawable.gmail),
//                                contentDescription = "Sign in with Google"
//                            )
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
//
///**
// * Draw box for screen top background
// */
//@Composable
//fun SignupScreenTwoBackground(modifier: Modifier = Modifier) {
//    Box(
//        modifier = modifier.fillMaxWidth()
//    ) {
//        Box(
//            modifier =
//                Modifier
//                    .offset(x = 23.dp, y = (-171).dp)
//                    .width(496.dp)
//                    .height(496.dp)
//                    .border(
//                        width = 2.dp,
//                        color = MaterialTheme.colorScheme.inverseOnSurface,
//                        shape = CircleShape
//                    )
//        )
//
//        Box(
//            modifier =
//                Modifier
//                    .offset(x = 114.dp, y = (-358).dp)
//                    .align(Alignment.TopEnd)
//                    .width(635.dp)
//                    .height(635.dp)
//                    .background(
//                        color = MaterialTheme.colorScheme.inverseOnSurface,
//                        shape = CircleShape
//                    )
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
//    val interactionSourceName = remember { MutableInteractionSource() }
//    val isNameFocused by interactionSourceName.collectIsFocusedAsState()
//
//    BasicTextField(
//        value = name,
//        onValueChange = onValueChange,
//        modifier = modifier
//            .fillMaxWidth()
//            .padding(start = 16.dp, top = 30.dp, end = 16.dp)
//            .border(
//                width = if (isNameFocused) 1.dp else 0.dp,
//                color = if (isNameFocused) Color.Blue else Color.Transparent,
//                shape = RoundedCornerShape(8.dp)
//            ),
//        visualTransformation = VisualTransformation.None,
//        interactionSource = interactionSourceName,
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
//            shape = RoundedCornerShape(8.dp),
//            placeholder = { Text(text = stringResource(R.string.name)) },
//            visualTransformation = VisualTransformation.None,
//            innerTextField = innerTextField,
//            singleLine = true,
//            enabled = true,
//            interactionSource = interactionSourceName,
//            contentPadding = PaddingValues(start = 20.dp, top = 12.dp, bottom = 12.dp, end = 0.dp),
//            colors = TextFieldDefaults.colors(
//                focusedContainerColor = MaterialTheme.colorScheme.inverseOnSurface,
//                unfocusedContainerColor = MaterialTheme.colorScheme.inverseOnSurface,
//                disabledIndicatorColor = Color.Transparent,
//                focusedIndicatorColor = Color.Transparent,
//                unfocusedIndicatorColor = Color.Transparent
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
//    val interactionSourceUsername = remember { MutableInteractionSource() }
//    val isUsernameFocused by interactionSourceUsername.collectIsFocusedAsState()
//
//    BasicTextField(
//        value = username,
//        onValueChange = onValueChange,
//        modifier = modifier
//            .fillMaxWidth()
//            .padding(start = 16.dp, top = 16.dp, end = 16.dp)
//            .border(
//                width = if (isUsernameFocused) 1.dp else 0.dp,
//                color = if (isUsernameFocused) Color.Blue else Color.Transparent,
//                shape = RoundedCornerShape(8.dp)
//            ),
//        visualTransformation = VisualTransformation.None,
//        interactionSource = interactionSourceUsername,
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
//            shape = RoundedCornerShape(8.dp),
//            placeholder = { Text(text = stringResource(R.string.username)) },
//            visualTransformation = VisualTransformation.None,
//            innerTextField = innerTextField,
//            singleLine = true,
//            enabled = true,
//            interactionSource = interactionSourceUsername,
//            contentPadding = PaddingValues(start = 20.dp, top = 12.dp, bottom = 12.dp, end = 0.dp),
//            colors = TextFieldDefaults.colors(
//                focusedContainerColor = MaterialTheme.colorScheme.inverseOnSurface,
//                unfocusedContainerColor = MaterialTheme.colorScheme.inverseOnSurface,
//                disabledIndicatorColor = Color.Transparent,
//                focusedIndicatorColor = Color.Transparent,
//                unfocusedIndicatorColor = Color.Transparent
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
//    val interactionSourceEmail = remember { MutableInteractionSource() }
//    val isEmailFocused by interactionSourceEmail.collectIsFocusedAsState()
//
//    BasicTextField(
//        value = email,
//        onValueChange = onValueChange,
//        modifier = modifier
//            .fillMaxWidth()
//            .padding(
//                start = 16.dp,
//                top = 16.dp,
//                end = 16.dp
//            )
//            .border(
//                width = if (isEmailFocused) 1.dp else 0.dp,
//                color = if (isEmailFocused) Color.Blue else Color.Transparent,
//                shape = RoundedCornerShape(8.dp)
//            ),
//        visualTransformation = VisualTransformation.None,
//        interactionSource = interactionSourceEmail,
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
//            shape = RoundedCornerShape(8.dp),
//            placeholder = {
//                Text(text = stringResource(R.string.email))
//            },
//            visualTransformation = VisualTransformation.None,
//            innerTextField = innerTextField,
//            singleLine = true,
//            enabled = true,
//            interactionSource = interactionSourceEmail,
//            contentPadding =
//                PaddingValues(
//                    start = 20.dp,
//                    top = 12.dp,
//                    bottom = 12.dp,
//                    end = 0.dp
//                ),
//            colors =
//                TextFieldDefaults.colors(
//                    focusedContainerColor = MaterialTheme.colorScheme.inverseOnSurface,
//                    unfocusedContainerColor = MaterialTheme.colorScheme.inverseOnSurface,
//                    disabledIndicatorColor = Color.Transparent,
//                    focusedIndicatorColor = Color.Transparent,
//                    unfocusedIndicatorColor = Color.Transparent
//                )
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
//    val interactionSourcePassword = remember { MutableInteractionSource() }
//
//    val isPasswordFocused by interactionSourcePassword.collectIsFocusedAsState()
//
//    BasicTextField(
//        value = password,
//        onValueChange = onValueChange,
//        modifier = modifier
//            .fillMaxWidth()
//            .padding(
//                start = 16.dp,
//                end = 16.dp,
//                top = 16.dp
//            )
//            .border(
//                width = if (isPasswordFocused) 1.dp else 0.dp,
//                color = if (isPasswordFocused) Color.Blue else Color.Transparent,
//                shape = RoundedCornerShape(8.dp)
//            ),
//        visualTransformation = PasswordVisualTransformation(),
//        interactionSource = interactionSourcePassword,
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
//            placeholder = { Text(text = "Password") },
//            visualTransformation = PasswordVisualTransformation(),
//            innerTextField = innerTextField,
//            singleLine = true,
//            enabled = true,
//            interactionSource = interactionSourcePassword,
//            contentPadding =
//                PaddingValues(
//                    start = 20.dp,
//                    top = 12.dp,
//                    bottom = 12.dp,
//                    end = 0.dp
//                ),
//            colors =
//                TextFieldDefaults.colors(
//                    focusedContainerColor = MaterialTheme.colorScheme.inverseOnSurface,
//                    unfocusedContainerColor = MaterialTheme.colorScheme.inverseOnSurface,
//                    disabledIndicatorColor = Color.Transparent,
//                    focusedIndicatorColor = Color.Transparent,
//                    unfocusedIndicatorColor = Color.Transparent
//                )
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
//    val interactionSourceConfirmPassword = remember { MutableInteractionSource() }
//    val isConfirmFocused by interactionSourceConfirmPassword.collectIsFocusedAsState()
//
//    BasicTextField(
//        value = confirmPassword,
//        onValueChange = onValueChange,
//        modifier = modifier
//            .fillMaxWidth()
//            .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 30.dp)
//            .border(
//                width = if (isConfirmFocused) 1.dp else 0.dp,
//                color = if (isConfirmFocused) Color.Blue else Color.Transparent,
//                shape = RoundedCornerShape(8.dp)
//            ),
//        visualTransformation = PasswordVisualTransformation(),
//        interactionSource = interactionSourceConfirmPassword,
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
//            shape = RoundedCornerShape(8.dp),
//            placeholder = { Text(text = stringResource(R.string.confirm_password)) },
//            visualTransformation = PasswordVisualTransformation(),
//            innerTextField = innerTextField,
//            singleLine = true,
//            enabled = true,
//            interactionSource = interactionSourceConfirmPassword,
//            contentPadding = PaddingValues(start = 20.dp, top = 12.dp, bottom = 12.dp, end = 0.dp),
//            colors = TextFieldDefaults.colors(
//                focusedContainerColor = MaterialTheme.colorScheme.inverseOnSurface,
//                unfocusedContainerColor = MaterialTheme.colorScheme.inverseOnSurface,
//                disabledIndicatorColor = Color.Transparent,
//                focusedIndicatorColor = Color.Transparent,
//                unfocusedIndicatorColor = Color.Transparent
//            )
//        )
//    }
//}
//
//@PreviewLightDark
//@Composable
//fun SignupScreenTwoPreview() {
//    AppScreensTheme {
//        Scaffold { innerPadding ->
//            Column(modifier = Modifier.padding(innerPadding)) {
//                SignupScreenTwo()
//            }
//        }
//    }
//}
