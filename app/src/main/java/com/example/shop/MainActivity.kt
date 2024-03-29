package com.example.shop

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.core.view.WindowCompat
import com.example.const_vals.PREFS
import com.example.shop.presentation.MyApp
import com.example.shop.ui.theme.ShopTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        val sharedPrefs = getSharedPreferences(PREFS, MODE_PRIVATE)

        setContent {
            Box(
                Modifier
                    .background(Color(0xFFD62F89))
                    .statusBarsPadding()
            ) {
                Box(
                    Modifier
                        .background(Color(0xFFD62F89))
                        .navigationBarsPadding()
                ) {
                    ShopTheme {
                        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                            MyApp(
                                modifier = Modifier.padding(innerPadding),
                                sharedPrefs = sharedPrefs
                            )
                        }
                    }
                }
            }
        }
    }
}

@PreviewScreenSizes
@PreviewFontScale
@PreviewLightDark
@PreviewDynamicColors
@Preview(showBackground = true)
@Composable
fun Prevy() {
    val context = LocalContext.current
    val fakeSharedPrefs = createFakeSharedPreferences(context)
    ShopTheme {
        MyApp(Modifier, fakeSharedPrefs)
    }
}

fun createFakeSharedPreferences(context: Context): SharedPreferences {
    return context.getSharedPreferences("fake_prefs", Context.MODE_PRIVATE)
}