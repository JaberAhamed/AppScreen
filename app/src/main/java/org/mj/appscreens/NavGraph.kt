package org.mj.appscreens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sj.corescreens.ui.auth.screens.LoginScreenEight
import com.sj.corescreens.ui.auth.screens.LoginScreenFive
import com.sj.corescreens.ui.auth.screens.LoginScreenFour
import com.sj.corescreens.ui.auth.screens.LoginScreenNine
import com.sj.corescreens.ui.auth.screens.loginScreenOne.LoginScreenOne
import com.sj.corescreens.ui.auth.screens.LoginScreenSeven
import com.sj.corescreens.ui.auth.screens.LoginScreenSix
import com.sj.corescreens.ui.auth.screens.LoginScreenTen
import com.sj.corescreens.ui.auth.screens.loginScreenThree.LoginScreenThree
import com.sj.corescreens.ui.auth.screens.LoginScreenTwo
import org.mj.appscreens.ui.screen.ScreenList

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object LoginScreen : Screen("LoginScreen")
}

sealed class HomeScreen(val route: String) {
    data object HomeIndex : HomeScreen("home/index")
}

sealed class LoginScreen(val route: String) {
    data object LoginOne : LoginScreen("login/one")
    data object LoginTwo : LoginScreen("login/two")
    data object LoginThree : LoginScreen("login/three")
    data object LoginFour : LoginScreen("login/four")
    data object LoginFive : LoginScreen("login/five")
    data object LoginSix : LoginScreen("login/six")
    data object LoginSeven : LoginScreen("login/seven")
    data object LoginEight : LoginScreen("login/eight")
    data object LoginNine : LoginScreen("login/nine")
    data object LoginTen : LoginScreen("login/ten")
}

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        addHomeScreen(navController)
        addLoginScreen(navController)
    }
}

private fun NavGraphBuilder.addHomeScreen(navHostController: NavHostController) {
    navigation(route = Screen.Home.route, startDestination = HomeScreen.HomeIndex.route) {
        composable(HomeScreen.HomeIndex.route) {
            ScreenList(
                gotoLoginScreenOne = {
                    navHostController.navigate(LoginScreen.LoginOne.route)
                },
                gotoLoginScreenTwo = {
                    navHostController.navigate(LoginScreen.LoginTwo.route)
                },
                gotoLoginScreenThree = {
                    navHostController.navigate(LoginScreen.LoginThree.route)
                },
                gotoLoginScreenFour = {
                    navHostController.navigate(LoginScreen.LoginFour.route)
                },
                gotoLoginScreenFive = {
                    navHostController.navigate(LoginScreen.LoginFive.route)
                },
                gotoLoginScreenSix = {
                    navHostController.navigate(LoginScreen.LoginSix.route)
                },
                gotoLoginScreenSeven = {
                    navHostController.navigate(LoginScreen.LoginSeven.route)
                },
                gotoLoginScreenEight = {
                    navHostController.navigate(LoginScreen.LoginEight.route)
                },
                gotoLoginScreenNine = {
                    navHostController.navigate(LoginScreen.LoginNine.route)
                },
                gotoLoginScreenTen = {
                    navHostController.navigate(LoginScreen.LoginTen.route)
                }

            )
        }
    }
}

private fun NavGraphBuilder.addLoginScreen(navHostController: NavHostController) {
    navigation(route = Screen.LoginScreen.route, startDestination = LoginScreen.LoginOne.route) {
        composable(LoginScreen.LoginOne.route) {
            LoginScreenOne()
        }
        composable(LoginScreen.LoginTwo.route) {
            LoginScreenTwo()
        }
        composable(LoginScreen.LoginThree.route) {
            LoginScreenThree()
        }
        composable(LoginScreen.LoginFour.route) {
            LoginScreenFour()
        }
        composable(LoginScreen.LoginFive.route) {
            LoginScreenFive()
        }
        composable(LoginScreen.LoginSix.route) {
            LoginScreenSix()
        }
        composable(LoginScreen.LoginSeven.route) {
            LoginScreenSeven()
        }
        composable(LoginScreen.LoginEight.route) {
            LoginScreenEight()
        }
        composable(LoginScreen.LoginNine.route) {
            LoginScreenNine()
        }
        composable(LoginScreen.LoginTen.route) {
            LoginScreenTen()
        }
    }
}
