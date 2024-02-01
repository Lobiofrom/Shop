package com.example.shop.bottom_navigation

import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.feature_basket.ui.BasketScreen
import com.example.feature_catalogue.ui.CatalogueScreen
import com.example.feature_discounts.ui.DiscountsScreen
import com.example.feature_profile.ui.ProfileScreen
import com.example.feature_start.ui.StartScreen

@Composable
fun Navigation(
    navHostController: NavHostController,
    onClick: () -> Unit,
    modifier: Modifier,
    sharedPreferences: SharedPreferences
) {
    NavHost(
        navController = navHostController, startDestination = "start",
        modifier = modifier
    ) {
        composable(route = "start") {
            StartScreen()
        }
        composable(
            route = "catalogue"
        ) {
            CatalogueScreen()
        }
        composable(route = "basket") {
            BasketScreen()
        }
        composable(route = "discounts") {
            DiscountsScreen()
        }
        composable(route = "profile") {
            ProfileScreen(
                sharedPreferences = sharedPreferences,
                onClick = onClick
            )
        }
    }
}
