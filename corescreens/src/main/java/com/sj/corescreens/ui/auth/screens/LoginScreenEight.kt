package com.sj.corescreens.ui.auth.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
import com.sj.corescreens.ui.theme.CustomColor
import com.sj.corescreens.utils.AllPreview


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreenEight() {
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

    var showPassword by remember {
        mutableStateOf(false)
    }

    var state by remember { mutableIntStateOf(0) }

    val titles = listOf("SignIn", "SignUp")

    Scaffold(
        modifier = Modifier
            .imePadding()
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .verticalScroll(state = rememberScrollState())
                .padding(innerPadding)
                .padding(bottom = 10.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(
                        color = CustomColor.brown_600,
                        shape = RoundedCornerShape(
                            bottomStart = 20.dp,
                            bottomEnd = 20.dp
                        )
                    )
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(120.dp)
                        .clip(CircleShape)
                        .border(
                            width = 4.dp,
                            color = Color.White
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "A",
                        color = Color.White,
                        fontSize = 30.sp
                    )
                }

                Row(
                    modifier = Modifier
                        .padding(
                            start = 16.dp,
                            end = 16.dp
                        )
                        .align(Alignment.BottomCenter)
                ) {
                    PrimaryTabRow(
                        modifier = Modifier.padding(start = 12.dp, end = 12.dp),
                        containerColor = CustomColor.brown_600,
                        contentColor = Color.White,
                        selectedTabIndex = state,
                        indicator = {
                            // Override the default indicator
                            if (state < titles.size) {
                                TabRowDefaults.SecondaryIndicator(
                                    modifier = Modifier.tabIndicatorOffset(state),
                                    color = Color.White
                                )
                            }
                        }

                    ) {
                        titles.forEachIndexed { index, title ->

                            Tab(
                                selected = state == index,
                                onClick = { state = index },
                                selectedContentColor = Color.White,
                                unselectedContentColor = Color.Gray,
                                text = {
                                    Text(
                                        text = title,
                                        fontSize = 16.sp
                                    )
                                }
                            )
                        }
                    }
                }
            }

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        top = 40.dp
                    ),
                text = "Welcome Back !",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )

            // Email Text Field

            Spacer(modifier = Modifier.height(16.dp))

            val interactionSourceEmail = remember { MutableInteractionSource() }
            val shape = RoundedCornerShape(10.dp)

            Box(
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        end = 16.dp
                    )
                    .shadow(
                        elevation = 5.dp,
                        shape = shape
                    )
                    .fillMaxWidth()
                    .height(50.dp),

                contentAlignment = Alignment.Center
            ) {
                BasicTextField(
                    value = email,
                    onValueChange = { email = it },
                    modifier =
                        Modifier
                            .fillMaxSize(),
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
                        placeholder = { Text(text = "Email") },
                        visualTransformation = VisualTransformation.None,
                        innerTextField = innerTextField,
                        singleLine = true,
                        enabled = true,
                        interactionSource = interactionSourceEmail,
                        prefix = {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = "Mail icon"
                            )
                        },
                        contentPadding =
                            PaddingValues(
                                start = 20.dp,
                                bottom = 12.dp,
                                end = 0.dp
                            ),
                        colors =
                            TextFieldDefaults.colors(
                                focusedTextColor = MaterialTheme.colorScheme.onSecondary,
                                focusedContainerColor = MaterialTheme.colorScheme.onSecondary,
                                unfocusedContainerColor = MaterialTheme.colorScheme.onSecondary,
                                disabledIndicatorColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            )

                    )
                }
            }

            // Password Text Field

            Spacer(modifier = Modifier.height(16.dp))

            val interactionSourcePassword = remember { MutableInteractionSource() }

            Box(
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        end = 16.dp
                    )
                    .shadow(
                        elevation = 5.dp,
                        shape = shape
                    )
                    .fillMaxWidth()
                    .height(50.dp),

                contentAlignment = Alignment.Center
            ) {
                BasicTextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier =
                        Modifier
                            .fillMaxWidth(),
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
                        shape = RoundedCornerShape(8.dp),
                        placeholder = { Text(text = "Password") },
                        visualTransformation = PasswordVisualTransformation(),
                        innerTextField = innerTextField,
                        singleLine = true,
                        enabled = true,
                        interactionSource = interactionSourcePassword,
                        prefix = {
                            Icon(imageVector = Icons.Default.Lock, contentDescription = "Mail icon")
                        },

                        trailingIcon = {
                            IconButton(onClick = {
                                showPassword = !showPassword
                            }) {
                                Icon(
                                    imageVector = if (showPassword) Icons.Rounded.Visibility else Icons.Rounded.VisibilityOff,
                                    contentDescription = if (showPassword) "Show Password" else "Hide Password"
                                )
                            }
                        },
                        contentPadding =
                            PaddingValues(
                                start = 20.dp,
                                bottom = 12.dp
                            ),
                        colors =
                            TextFieldDefaults.colors(
                                focusedTextColor = MaterialTheme.colorScheme.onSecondary,
                                focusedContainerColor = MaterialTheme.colorScheme.onSecondary,
                                unfocusedContainerColor = MaterialTheme.colorScheme.onSecondary,
                                disabledIndicatorColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            )
                    )
                }
            }

            /**
             * Forgot password text button
             */
            TextButton(
                modifier =
                    Modifier
                        .padding(
                            top = 16.dp,
                            end = 26.dp
                        )
                        .align(Alignment.End),
                onClick = { },
                contentPadding = PaddingValues(top = 0.dp, bottom = 0.dp)
            ) {
                Text(
                    text = "Forgot your Password ?",
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 14.sp
                )
            }

            /**
             * Here is screen signIn button
             */
            Button(
                modifier = Modifier
                    .wrapContentSize()
                    .fillMaxWidth()
                    .padding(
                        top = 8.dp,
                        start = 48.dp,
                        end = 48.dp
                    ),
                shape = RoundedCornerShape(
                    size = 18.dp

                ),
                onClick = { },
                colors = ButtonDefaults
                    .buttonColors(
                        containerColor = CustomColor.brown_600
                    )
            ) {
                Text(
                    text = "LogIn",
                    fontWeight = FontWeight.W600,
                    color = Color.White
                )
            }

            Row(
                modifier = Modifier.padding(
                    start = 48.dp,
                    top = 12.dp,
                    end = 48.dp
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(
                    modifier = Modifier
                        .weight(1f)
                        .height(1.dp)
                        .padding(end = 16.dp)
                        .background(color = CustomColor.purple_600)
                )

                Text(
                    text = "Or sign in with",
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 14.sp
                )

                Spacer(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .weight(1f)
                        .height(1.dp)
                        .background(color = CustomColor.purple_600)
                )
            }

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
                Button(
                    modifier = Modifier
                        .weight(1f)
                        .height(58.dp)
                        .padding(
                            top = 8.dp,
                            end = 6.dp
                        ),
                    shape = RoundedCornerShape(
                        size = 18.dp

                    ),
                    elevation = ButtonDefaults
                        .elevatedButtonElevation(disabledElevation = 4.dp),
                    onClick = { },
                    colors = ButtonDefaults
                        .buttonColors(
                            containerColor = Color.White
                        )
                ) {
                    Image(
                        modifier = Modifier.size(26.dp),
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "Description"
                    )

                    Spacer(modifier = Modifier.width(2.dp))

                    Text(
                        text = "Google",
                        fontWeight = FontWeight.W600,
                        color = CustomColor.brown_600
                    )
                }

                Button(
                    modifier = Modifier
                        .height(58.dp)
                        .weight(1f)
                        .padding(
                            start = 6.dp,
                            top = 8.dp
                        ),
                    shape = RoundedCornerShape(
                        size = 18.dp

                    ),
                    elevation = ButtonDefaults
                        .elevatedButtonElevation(disabledElevation = 4.dp),
                    onClick = { },
                    colors = ButtonDefaults
                        .buttonColors(
                            containerColor = CustomColor.brown_600
                        )
                ) {
                    Image(
                        modifier = Modifier.size(26.dp),
                        painter = painterResource(id = R.drawable.facebook),
                        contentDescription = "Description"
                    )

                    Spacer(modifier = Modifier.width(2.dp))

                    Text(
                        text = "Facebook",
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@AllPreview
@Composable
fun LoginScreenEightPreview() {
    MaterialTheme {
        Scaffold { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                LoginScreenEight()
            }
        }
    }
}
