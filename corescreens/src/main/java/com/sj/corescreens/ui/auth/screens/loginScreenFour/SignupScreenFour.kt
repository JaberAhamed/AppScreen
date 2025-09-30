package com.sj.corescreens.ui.auth.screens.loginScreenFour

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sj.corescreens.R
import com.sj.corescreens.utils.AllPreview

@Composable
fun SignupScreenFour() {
    /**
     * Local context is use here for toast context
     */
    val context = LocalContext.current

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

    var name by remember {
        mutableStateOf(
            TextFieldValue("")
        )
    }
    var userName by remember { mutableStateOf(TextFieldValue("")) }
    var confirmPassword by remember { mutableStateOf(TextFieldValue("")) }

    Scaffold(
        modifier = Modifier
            .navigationBarsPadding()
            .imePadding()
    ) { innerPadding ->
        val configuration = LocalConfiguration.current
        val screenHeight = configuration.screenHeightDp.dp
        val topStartRoundValue = 250f

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .background(Color.Black.copy(0.9f))
            ) {
                /**
                 * Screen top or logo section
                 */
                SignupScreenFourTopSection()

                Box(
                    modifier = Modifier
                        .padding(top = screenHeight / 4f)
                        .fillMaxSize()
                        .background(
                            color = MaterialTheme.colorScheme.onPrimary,
                            shape = RoundedCornerShape(topStart = topStartRoundValue)
                        )

                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            modifier = Modifier.padding(top = 50.dp),
                            text = stringResource(R.string.sign_up),
                            color = MaterialTheme.colorScheme.onSecondaryContainer,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold
                        )

                        NameInputField(
                            name = name,
                            onValueChange = { name = it }
                        )

                        UserNameInputField(
                            userName = userName,
                            onValueChange = { userName = it }
                        )

                        EmailInputField(
                            email = email,
                            onValueChange = {
                                email = it
                            }
                        )

                        PasswordInputField(
                            password = password,
                            onValueChange = {
                                password = it
                            }
                        )

                        ConfirmPasswordInputField(
                            confirmPassword = confirmPassword,
                            onValueChange = { confirmPassword = it }
                        )

                        Spacer(modifier = Modifier.height(30.dp))

                        /**
                         * Here is screen signIn button
                         */
                        val signUpButtonClicked = stringResource(R.string.sign_in_btn_clicked)
                        val validationError = stringResource(R.string.please_fill_all_fields)
                        Button(
                            modifier = Modifier
                                .height(48.dp)
                                .fillMaxWidth()
                                .padding(
                                    start = 26.dp,
                                    end = 26.dp
                                ),
                            shape = RoundedCornerShape(
                                topStart = 16f,
                                topEnd = 0f,
                                bottomStart = 16f,
                                bottomEnd = 16f

                            ),
                            onClick = {
                                if (email.text.isEmpty() || password.text.isEmpty()) {
                                    Toast.makeText(context, validationError, Toast.LENGTH_SHORT).show()
                                } else {
                                    Toast.makeText(context, signUpButtonClicked, Toast.LENGTH_SHORT).show()
                                }
                            },
                            colors = ButtonDefaults
                                .buttonColors(
                                    containerColor = Color.Black.copy(0.9f)
                                )
                        ) {
                            Text(
                                text = stringResource(R.string.sign_up),
                                fontWeight = FontWeight.W600,
                                color = Color.White
                            )
                        }

                        Spacer(modifier = Modifier.height(250.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun SignupScreenFourTopSection(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 50.dp),

        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(
                    Color.White,
                    shape = RoundedCornerShape(
                        topStart = 100f,
                        topEnd = 30f,
                        bottomStart = 30f,
                        bottomEnd = 100f
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "A",
                textAlign = TextAlign.Center,
                fontSize = 40.sp,
                fontWeight = FontWeight.W500,
                color = Color.Black
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun NameInputField(
    modifier: Modifier = Modifier,
    name: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit
) {
    val interactionSourceName = remember { MutableInteractionSource() }
    val isNameFocused by interactionSourceName.collectIsFocusedAsState()

    BasicTextField(
        value = name,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 26.dp, end = 26.dp, top = 30.dp)
            .border(
                width = if (isNameFocused) 1.dp else 0.dp,
                color = if (isNameFocused) Color.Blue else Color.Transparent,
                shape = RoundedCornerShape(8.dp)
            ),
        visualTransformation = VisualTransformation.None,
        interactionSource = interactionSourceName,
        enabled = true,
        singleLine = true,
        textStyle = LocalTextStyle.current,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        )
    ) { innerTextField ->
        TextFieldDefaults.DecorationBox(
            value = name.text,
            shape = RoundedCornerShape(8.dp),
            placeholder = { Text(text = stringResource(R.string.name)) },
            visualTransformation = VisualTransformation.None,
            innerTextField = innerTextField,
            singleLine = true,
            enabled = true,
            interactionSource = interactionSourceName,
            prefix = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Name input field icon"
                )
            },
            contentPadding = PaddingValues(start = 20.dp, top = 12.dp, bottom = 12.dp, end = 0.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black.copy(0.9f),
                focusedContainerColor = Color.LightGray.copy(0.4f),
                unfocusedContainerColor = Color.LightGray.copy(0.4f),
                disabledIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun UserNameInputField(
    modifier: Modifier = Modifier,
    userName: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit
) {
    val interactionSourceUserName = remember { MutableInteractionSource() }
    val isUserNameFocused by interactionSourceUserName.collectIsFocusedAsState()

    BasicTextField(
        value = userName,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 26.dp, end = 26.dp, top = 30.dp)
            .border(
                width = if (isUserNameFocused) 1.dp else 0.dp,
                color = if (isUserNameFocused) Color.Blue else Color.Transparent,
                shape = RoundedCornerShape(8.dp)
            ),
        visualTransformation = VisualTransformation.None,
        interactionSource = interactionSourceUserName,
        enabled = true,
        singleLine = true,
        textStyle = LocalTextStyle.current,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        )
    ) { innerTextField ->
        TextFieldDefaults.DecorationBox(
            value = userName.text,
            shape = RoundedCornerShape(8.dp),
            placeholder = { Text(text = stringResource(R.string.username)) },
            visualTransformation = VisualTransformation.None,
            innerTextField = innerTextField,
            singleLine = true,
            enabled = true,
            interactionSource = interactionSourceUserName,
            prefix = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Username input field icon"
                )
            },
            contentPadding = PaddingValues(start = 20.dp, top = 12.dp, bottom = 12.dp, end = 0.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black.copy(0.9f),
                focusedContainerColor = Color.LightGray.copy(0.4f),
                unfocusedContainerColor = Color.LightGray.copy(0.4f),
                disabledIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun EmailInputField(
    modifier: Modifier = Modifier,
    email: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit
) {
    val interactionSourceEmail = remember { MutableInteractionSource() }
    val isEmailFocused by interactionSourceEmail.collectIsFocusedAsState()

    BasicTextField(
        value = email,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = 26.dp,
                top = 26.dp,
                end = 26.dp
            )
            .border(
                width = if (isEmailFocused) 1.dp else 0.dp,
                color = if (isEmailFocused) Color.Blue else Color.Transparent,
                shape = RoundedCornerShape(8.dp)
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
            shape = RoundedCornerShape(8.dp),
            placeholder = {
                Text(text = stringResource(R.string.email))
            },
            visualTransformation = VisualTransformation.None,
            innerTextField = innerTextField,
            singleLine = true,
            enabled = true,
            interactionSource = interactionSourceEmail,
            prefix = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Mail input field icon"
                )
            },
            contentPadding =
            PaddingValues(
                start = 20.dp,
                top = 12.dp,
                bottom = 12.dp,
                end = 0.dp
            ),
            colors =
            TextFieldDefaults.colors(
                focusedTextColor = Color.Black.copy(0.9f),
                focusedContainerColor = Color.LightGray.copy(0.4f),
                unfocusedContainerColor = Color.LightGray.copy(0.4f),
                disabledIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
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
    val interactionSourcePassword = remember { MutableInteractionSource() }

    val isPasswordFocused by interactionSourcePassword.collectIsFocusedAsState()

    BasicTextField(
        value = password,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = 26.dp,
                end = 26.dp,
                top = 30.dp
            )
            .border(
                width = if (isPasswordFocused) 1.dp else 0.dp,
                color = if (isPasswordFocused) Color.Blue else Color.Transparent,
                shape = RoundedCornerShape(8.dp)
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
            shape = RoundedCornerShape(8),
            placeholder = { Text(text = stringResource(R.string.password)) },
            visualTransformation = PasswordVisualTransformation(),
            innerTextField = innerTextField,
            singleLine = true,
            enabled = true,
            interactionSource = interactionSourcePassword,
            prefix = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Password input field icon"
                )
            },
            contentPadding =
            PaddingValues(
                start = 20.dp,
                top = 12.dp,
                bottom = 12.dp,
                end = 0.dp
            ),
            colors =
            TextFieldDefaults.colors(
                focusedTextColor = Color.Black.copy(0.9f),
                focusedContainerColor = Color.LightGray.copy(0.4f),
                unfocusedContainerColor = Color.LightGray.copy(0.4f),
                disabledIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ConfirmPasswordInputField(
    modifier: Modifier = Modifier,
    confirmPassword: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit
) {
    val interactionSourceConfirmPassword = remember { MutableInteractionSource() }
    val isConfirmPasswordFocused by interactionSourceConfirmPassword.collectIsFocusedAsState()

    BasicTextField(
        value = confirmPassword,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 26.dp, end = 26.dp, top = 30.dp)
            .border(
                width = if (isConfirmPasswordFocused) 1.dp else 0.dp,
                color = if (isConfirmPasswordFocused) Color.Blue else Color.Transparent,
                shape = RoundedCornerShape(8.dp)
            ),
        visualTransformation = PasswordVisualTransformation(),
        interactionSource = interactionSourceConfirmPassword,
        enabled = true,
        singleLine = true,
        textStyle = LocalTextStyle.current,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        )
    ) { innerTextField ->
        TextFieldDefaults.DecorationBox(
            value = confirmPassword.text,
            shape = RoundedCornerShape(8),
            placeholder = { Text(text = stringResource(R.string.confirm_password)) },
            visualTransformation = PasswordVisualTransformation(),
            innerTextField = innerTextField,
            singleLine = true,
            enabled = true,
            interactionSource = interactionSourceConfirmPassword,
            prefix = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Confirm password input field icon"
                )
            },
            contentPadding = PaddingValues(start = 20.dp, top = 12.dp, bottom = 12.dp, end = 0.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black.copy(0.9f),
                focusedContainerColor = Color.LightGray.copy(0.4f),
                unfocusedContainerColor = Color.LightGray.copy(0.4f),
                disabledIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}

@AllPreview
@Composable
fun SignupScreenFourPreview() {
    MaterialTheme {
        Scaffold { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                SignupScreenFour()
            }
        }
    }
}
