package org.mj.appscreens.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.mj.appscreens.models.listScreen

@Composable
fun ScreenList(
    gotoLoginScreenOne: () -> Unit,
    gotoLoginScreenTwo: () -> Unit,
    gotoLoginScreenThree: () -> Unit,
    gotoLoginScreenFour: () -> Unit,
    gotoLoginScreenFive: () -> Unit,
    gotoLoginScreenSix: () -> Unit,
    gotoLoginScreenSeven: () -> Unit,
    gotoLoginScreenEight: () -> Unit,
    gotoLoginScreenNine: () -> Unit,
    gotoLoginScreenTen: () -> Unit
) {
    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colorScheme.primary),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.padding(
                        top = 10.dp,
                        bottom = 10.dp
                    ),
                    text = "Login Screens",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 20.sp
                )
            }
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            LazyColumn {
                items(listScreen) {
                    Column(
                        modifier = Modifier
                            .padding(
                                top = 12.dp,
                                start = 16.dp
                            )
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(
                                    top = 10.dp,
                                    bottom = 10.dp
                                )
                                .clickable {
                                    if (it == "Login 1") {
                                        gotoLoginScreenOne()
                                    }

                                    if (it == "Login 2") {
                                        gotoLoginScreenTwo()
                                    }

                                    if (it == "Login 3") {
                                        gotoLoginScreenThree()
                                    }
                                    if (it == "Login 4") {
                                        gotoLoginScreenFour()
                                    }
                                    if (it == "Login 5") {
                                        gotoLoginScreenFive()
                                    }
                                    if (it == "Login 6") {
                                        gotoLoginScreenSix()
                                    }
                                    if (it == "Login 7") {
                                        gotoLoginScreenSeven()
                                    }
                                    if (it == "Login 8") {
                                        gotoLoginScreenEight()
                                    }
                                    if (it == "Login 9") {
                                        gotoLoginScreenNine()
                                    }
                                    if (it == "Login 10") {
                                        gotoLoginScreenTen()
                                    }
                                },
                            text = it,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary,
                            fontSize = 20.sp
                        )

                        HorizontalDivider(Modifier.height(1.dp))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ScreenListPreview() {
    ScreenList(
        gotoLoginScreenOne = {},
        gotoLoginScreenTwo = {},
        gotoLoginScreenThree = {},
        gotoLoginScreenFour = {},
        gotoLoginScreenFive = {},
        gotoLoginScreenSix = {},
        gotoLoginScreenSeven = {},
        gotoLoginScreenEight = {},
        gotoLoginScreenNine = {},
        gotoLoginScreenTen = {}
    )
}
