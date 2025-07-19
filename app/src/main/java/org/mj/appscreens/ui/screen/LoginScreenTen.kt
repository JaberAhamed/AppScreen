package org.mj.appscreens.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.mj.appscreens.R
import org.mj.appscreens.ui.theme.AppScreensTheme
import org.mj.appscreens.ui.theme.CustomColor

@Composable
fun LoginScreenTen() {
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
            val configuration = LocalConfiguration.current
            val screenWidth = configuration.screenWidthDp.dp
            val screenHeight = configuration.screenHeightDp.dp
            val color = MaterialTheme.colorScheme.primary
            Box(
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(screenHeight / 3)
                        .drawWithCache {
                            onDrawWithContent {
                                val path = Path()
                                path.moveTo(0f, 0f)
                                path.lineTo(0f, size.height)
                                path.cubicTo(
                                    x1 = screenWidth.toPx() / 3,
                                    y1 = size.height + 150.dp.toPx(),
                                    x2 = screenWidth.toPx() / 1.5f,
                                    y2 = size.height - 150.dp.toPx(),
                                    x3 = screenWidth.toPx() + 2.5f,
                                    y3 = size.height
                                )
                                path.lineTo(screenWidth.toPx() + 2f, y = 0f)
                                drawPath(
                                    path = path,
                                    color = color,
                                    style = Fill

                                )
                            }
                        }
                )

                /**
                 * Screen logo section
                 */
                Image(
                    painter = painterResource(id = R.drawable.writeview),
                    contentDescription = null
                )
            }

            Spacer(modifier = Modifier.height(100.dp))

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        end = 16.dp
                    ),
                value = email,
                onValueChange = {
                    email = it
                },
                prefix = {
                    Icon(imageVector = Icons.Default.Mail, contentDescription = "Mail icon")
                },
                placeholder = {
                    Text(text = "Email")
                },
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        end = 16.dp
                    ),
                value = password,
                onValueChange = {
                    password = it
                },
                prefix = {
                    Icon(imageVector = Icons.Default.Lock, contentDescription = "Lock icon")
                },
                placeholder = {
                    Text(text = "Password")
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
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent
                )

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
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            /**
             * Here is screen Login button
             */
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    modifier = Modifier.padding(
                        start = 26.dp,
                        end = 26.dp
                    ),
                    text = "Login",
                    fontSize = 16.sp
                )
            }

            Text(
                modifier = Modifier.padding(
                    start = 26.dp,
                    top = 12.dp,
                    end = 26.dp
                ),
                text = "Or Login With",
                color = MaterialTheme.colorScheme.primary
            )

            /**
             * Social sign up section
             */
            Row(
                modifier = Modifier.padding(
                    start = 56.dp,
                    top = 12.dp,
                    end = 56.dp
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    shape = RoundedCornerShape(8.dp),
                    onClick = { },
                    colors = ButtonDefaults
                        .buttonColors(
                            containerColor = Color.Red.copy(0.8f)
                        )
                ) {
                    Image(
                        modifier = Modifier.size(26.dp),
                        painter = painterResource(id = R.drawable.gmail),
                        contentDescription = ""
                    )
                }

                VerticalDivider(
                    modifier = Modifier.height(60.dp)
                        .padding(
                            start = 12.dp,
                            end = 12.dp
                        )
                )

                Button(
                    shape = RoundedCornerShape(8.dp),
                    onClick = { },
                    colors = ButtonDefaults
                        .buttonColors(
                            containerColor = CustomColor.brown_600
                        )
                ) {
                    Image(
                        modifier = Modifier.size(26.dp),
                        painter = painterResource(id = R.drawable.facebook),
                        contentDescription = ""
                    )
                }
            }

            /**
             * Sign up screen navigation section
             */
            val text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(color = MaterialTheme.colorScheme.primary)
                ) {
                    append("Don't have an account?")
                }
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
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
        }
    }
}

@PreviewLightDark
@Composable
fun LoginScreenTenPreview() {
    AppScreensTheme {
        Scaffold { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                LoginScreenTen()
            }
        }
    }
}
