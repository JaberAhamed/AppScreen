package com.sj.corescreens.ui.auth.screens.loginScreenEight

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
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
fun SignUpScreenEight() {
    var fullName by remember { mutableStateOf(TextFieldValue("")) }
    var username by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var confirmPassword by remember { mutableStateOf(TextFieldValue("")) }

    var showPassword by remember { mutableStateOf(false) }
    var showConfirmPassword by remember { mutableStateOf(false) }

    val shape = RoundedCornerShape(10.dp)

    Scaffold(
        modifier = Modifier.imePadding()
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
                .padding(bottom = 10.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(
                        color = CustomColor.brown_600,
                        shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
                    )
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(120.dp)
                        .clip(CircleShape)
                        .border(width = 4.dp, color = Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "A", color = Color.White, fontSize = 30.sp)
                }
            }

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 40.dp),
                text = "Create Account",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Full Name
            CustomInputField(
                value = fullName,
                onValueChange = { fullName = it },
                placeholder = "Full Name",
                icon = Icons.Default.Person,
                imeAction = ImeAction.Next,
                shape = shape
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Username
            CustomInputField(
                value = username,
                onValueChange = { username = it },
                placeholder = "Username",
                icon = Icons.Default.AccountCircle,
                imeAction = ImeAction.Next,
                shape = shape
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Email
            CustomInputField(
                value = email,
                onValueChange = { email = it },
                placeholder = "Email",
                icon = Icons.Default.Email,
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next,
                shape = shape
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Password
            PasswordInputField(
                value = password,
                onValueChange = { password = it },
                placeholder = "Password",
                showPassword = showPassword,
                onTogglePassword = { showPassword = !showPassword },
                shape = shape
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Confirm Password
            PasswordInputField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                placeholder = "Confirm Password",
                showPassword = showConfirmPassword,
                onTogglePassword = { showConfirmPassword = !showConfirmPassword },
                shape = shape
            )

            // Sign Up Button
            Button(
                modifier = Modifier
                    .wrapContentSize()
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 48.dp, end = 48.dp),
                shape = RoundedCornerShape(size = 18.dp),
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = CustomColor.brown_600)
            ) {
                Text(text = "Sign Up", fontWeight = FontWeight.W600, color = Color.White)
            }

            Row(
                modifier = Modifier.padding(start = 48.dp, top = 12.dp, end = 48.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(
                    modifier = Modifier.weight(1f).height(1.dp).padding(end = 16.dp)
                        .background(color = CustomColor.purple_600)
                )

                Text(
                    text = "Or sign up with",
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 14.sp
                )

                Spacer(
                    modifier = Modifier.padding(start = 16.dp).weight(1f).height(1.dp)
                        .background(color = CustomColor.purple_600)
                )
            }

            // Social sign up section
            Row(
                modifier = Modifier.padding(start = 16.dp, top = 12.dp, end = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    modifier = Modifier
                        .weight(1f)
                        .height(58.dp)
                        .padding(top = 8.dp, end = 6.dp),
                    shape = RoundedCornerShape(size = 18.dp),
                    elevation = ButtonDefaults.elevatedButtonElevation(disabledElevation = 4.dp),
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Image(
                        modifier = Modifier.size(26.dp),
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "Google"
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(text = "Google", fontWeight = FontWeight.W600, color = CustomColor.brown_600)
                }

                Button(
                    modifier = Modifier
                        .height(58.dp)
                        .weight(1f)
                        .padding(start = 6.dp, top = 8.dp),
                    shape = RoundedCornerShape(size = 18.dp),
                    elevation = ButtonDefaults.elevatedButtonElevation(disabledElevation = 4.dp),
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = CustomColor.brown_600)
                ) {
                    Image(
                        modifier = Modifier.size(26.dp),
                        painter = painterResource(id = R.drawable.facebook),
                        contentDescription = "Facebook"
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(text = "Facebook", color = Color.White)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomInputField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    placeholder: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction,
    shape: RoundedCornerShape
) {
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .shadow(elevation = 5.dp, shape = shape)
            .fillMaxWidth()
            .height(50.dp),
        contentAlignment = Alignment.Center
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxSize(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
            textStyle = LocalTextStyle.current,
            interactionSource = interactionSource
        ) { innerTextField ->
            TextFieldDefaults.DecorationBox(
                value = value.text,
                placeholder = { Text(text = placeholder) },
                shape = RoundedCornerShape(8.dp),
                innerTextField = innerTextField,
                singleLine = true,
                enabled = true,
                interactionSource = interactionSource,
                prefix = { Icon(imageVector = icon, contentDescription = placeholder) },
                colors = TextFieldDefaults.colors(
                    focusedTextColor = MaterialTheme.colorScheme.onSecondary,
                    focusedContainerColor = MaterialTheme.colorScheme.onSecondary,
                    unfocusedContainerColor = MaterialTheme.colorScheme.onSecondary,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                contentPadding = PaddingValues(start = 20.dp, bottom = 12.dp, end = 0.dp),
                visualTransformation = VisualTransformation.None

            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordInputField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    placeholder: String,
    showPassword: Boolean,
    onTogglePassword: () -> Unit,
    shape: RoundedCornerShape
) {
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .shadow(elevation = 5.dp, shape = shape)
            .fillMaxWidth()
            .height(50.dp),
        contentAlignment = Alignment.Center
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Next),
            textStyle = LocalTextStyle.current,
            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
            interactionSource = interactionSource
        ) { innerTextField ->
            TextFieldDefaults.DecorationBox(
                value = value.text,
                placeholder = { Text(text = placeholder) },
                shape = RoundedCornerShape(8.dp),
                innerTextField = innerTextField,
                singleLine = true,
                enabled = true,
                interactionSource = interactionSource,
                prefix = { Icon(imageVector = Icons.Default.Lock, contentDescription = placeholder) },
                trailingIcon = {
                    IconButton(onClick = onTogglePassword) {
                        Icon(
                            imageVector = if (showPassword) Icons.Rounded.Visibility else Icons.Rounded.VisibilityOff,
                            contentDescription = if (showPassword) "Hide Password" else "Show Password"
                        )
                    }
                },
                colors = TextFieldDefaults.colors(
                    focusedTextColor = MaterialTheme.colorScheme.onSecondary,
                    focusedContainerColor = MaterialTheme.colorScheme.onSecondary,
                    unfocusedContainerColor = MaterialTheme.colorScheme.onSecondary,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                contentPadding = PaddingValues(start = 20.dp, bottom = 12.dp),
                visualTransformation = VisualTransformation.None
            )
        }
    }
}

@AllPreview
@Composable
fun SignUpScreenEightPreview() {
    MaterialTheme {
        SignUpScreenEight()
    }
}
