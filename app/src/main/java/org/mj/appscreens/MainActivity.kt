package org.mj.appscreens

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.sj.corescreens.ui.theme.AppScreensTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppScreensTheme {
                // A surface container using the 'background' color from the theme
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val context = LocalContext.current

    val handler = Handler(Looper.getMainLooper())
    handler.postDelayed({
        Toast.makeText(context, "got it ", Toast.LENGTH_SHORT).show()
    }, 1000L)

    handler.sendMessage(Message())

    MainNavHost(
        modifier = Modifier.background(MaterialTheme.colorScheme.background),
        navController = navController
    )
}
