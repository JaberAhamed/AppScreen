package com.sj.corescreens.ui.auth.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sj.corescreens.R
import com.sj.corescreens.ui.theme.CustomColor
import com.sj.corescreens.utils.AllPreview


@Composable
fun LoginScreenFive() {
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
            .imePadding(),
        contentWindowInsets = WindowInsets(0, 0, 0, 0)
    ) { innerPadding ->
        val configuration = LocalConfiguration.current
        val screenWidth = configuration.screenWidthDp.dp
        val backgroundColor = MaterialTheme.colorScheme.background

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .background(color = MaterialTheme.colorScheme.background)
                .fillMaxWidth()
                .fillMaxHeight()
                .verticalScroll(rememberScrollState())
        ) {
            /**
             * Screen logo section
             */
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(330.dp)
                    .drawWithCache {
                        val path = Path()
                        path.addRect(
                            Rect(
                                topLeft = Offset.Zero,
                                bottomRight = Offset(size.width, size.height)
                            )
                        )
                        onDrawWithContent {
                            clipPath(path) {
                                this@onDrawWithContent.drawContent()
                            }

                            val path1 = Path()
                            path1.moveTo(0f, size.height)
                            path1.cubicTo(
                                0f,
                                size.height,
                                (screenWidth.toPx() / 2),
                                size.height - 250,
                                screenWidth.toPx(),
                                size.height
                            )
                            drawPath(
                                path = path1,
                                color = backgroundColor,
                                style = Fill
                            )
                        }
                    }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.illis),
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Transparent),
                    contentScale = ContentScale.Crop,
                    contentDescription = "fd"
                )
            }

            Text(
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 40.dp
                    ),
                text = "Log In",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                modifier = Modifier.padding(
                    start = 16.dp,
                    top = 10.dp,
                    end = 16.dp
                ),
                text = "Enter Your Username & Password",
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        top = 20.dp,
                        end = 16.dp
                    ),
                value = email,
                onValueChange = { email = it },
                placeholder = {
                    Text(text = "Email")
                },
                shape = RoundedCornerShape(20.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        top = 16.dp,
                        end = 16.dp
                    ),
                value = password,
                onValueChange = { password = it },
                placeholder = {
                    Text(text = "password")
                },
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
                    color = MaterialTheme.colorScheme.primary,
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
                        top = 10.dp,
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
                                CustomColor.purple_100,
                                CustomColor.purple_500
                            )
                        ),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .height(44.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                onClick = {}

            ) {
                Text(
                    text = "Login",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Text(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .align(Alignment.CenterHorizontally),

                text = "or continue with",
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 14.sp
            )

            /**
             * Social signup section
             */
            Row(
                modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        top = 16.dp,
                        end = 16.dp,
                        bottom = 20.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    modifier =
                    Modifier
                        .height(44.dp)
                        .weight(1f)
                        .shadow(
                            elevation = 6.dp,
                            shape = RoundedCornerShape(20.dp),
                            ambientColor = Color.Blue.copy(0.7f),
                            spotColor = Color.Blue.copy(0.7f)
                        ),
                    shape = RoundedCornerShape(20.dp),
                    onClick = {},
                    colors = ButtonDefaults
                        .buttonColors(containerColor = Color.White)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.facebook),
                        contentDescription = "Facebook button",
                        tint = Color.Black
                    )
                }

                Spacer(modifier = Modifier.width(40.dp))

                Button(
                    modifier =
                    Modifier
                        .height(44.dp)
                        .weight(1f)
                        .shadow(
                            elevation = 6.dp,
                            shape = RoundedCornerShape(20.dp),
                            ambientColor = Color.Blue.copy(0.7f),
                            spotColor = Color.Blue.copy(0.7f)
                        ),
                    shape = RoundedCornerShape(20.dp),
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.gmail),
                        contentDescription = "Google Button",
                        tint = Color.Black

                    )
                }
            }

            /**
             * Sign up screen navigation section
             */
            val text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(color = Color.DarkGray)
                ) {
                    append("Don't have an account?")
                }
                withStyle(
                    style = SpanStyle(
                        color = CustomColor.purple_500.copy(0.9f),
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

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@AllPreview
@Composable
fun LoginScreenFivePreview() {
    MaterialTheme {
        Scaffold { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                LoginScreenFive()
            }
        }
    }
}
