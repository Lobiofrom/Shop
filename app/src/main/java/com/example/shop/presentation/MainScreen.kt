package com.example.shop.presentation

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.shop.R
import com.example.shop.bottom_navigation.BottomNaviItem
import com.example.shop.bottom_navigation.Navigation

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    modifier: Modifier,
    onClick: () -> Unit,
    sharedPreferences: SharedPreferences,
    startDestination: String
) {
    val navController = rememberNavController()
    val naviItems = listOf(
        BottomNaviItem(
            name = "Главная",
            route = "start",
            icon = R.drawable.home,
            unselectedIcon = R.drawable.home_pink
        ),
        BottomNaviItem(
            name = "Каталог",
            route = "catalogue",
            icon = R.drawable.catalog,
            unselectedIcon = R.drawable.home_pink
        ),
        BottomNaviItem(
            name = "Корзина",
            route = "basket",
            icon = R.drawable.basket,
            unselectedIcon = R.drawable.home_pink
        ),
        BottomNaviItem(
            name = "Акции",
            route = "discounts",
            icon = R.drawable.discount,
            unselectedIcon = R.drawable.home_pink
        ),
        BottomNaviItem(
            name = "Профиль",
            route = "profile",
            icon = R.drawable.profile,
            unselectedIcon = R.drawable.home_pink
        ),
    )
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    if (startDestination == "catalogue") {
        selectedItemIndex = 1
    }

    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            bottomBar = {
                Column {
                    HorizontalDivider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(1.dp, Color.LightGray)
                    )
                    NavigationBar(
                        tonalElevation = 0.dp,
                        contentColor = MaterialTheme.colorScheme.background,
                    ) {
                        naviItems.forEachIndexed { index, bottomNaviItem ->
                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentDestination = navBackStackEntry?.destination
                            val selected = currentDestination?.hierarchy?.any {
                                it.route == bottomNaviItem.route
                            } == true
                            NavigationBarItem(
                                colors = NavigationBarItemDefaults.colors(
                                    selectedIconColor = Color(android.graphics.Color.parseColor("#D62F89")),
                                    selectedTextColor = Color(android.graphics.Color.parseColor("#D62F89")),
                                    indicatorColor = Color.White
                                ),
                                selected = selected,
                                onClick = {
                                    selectedItemIndex = index
                                    navController.navigate(bottomNaviItem.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                label = {
                                    Text(
                                        text = bottomNaviItem.name
                                    )
                                },
                                alwaysShowLabel = true,
                                icon = {
                                    Icon(
                                        painter = painterResource(id = bottomNaviItem.icon),
                                        contentDescription = null
                                    )
                                }
                            )
                        }
                    }
                }
            }
        ) { innerPadding ->
            Navigation(
                navHostController = navController,
                onClick = onClick,
                modifier = Modifier.padding(innerPadding),
                sharedPreferences = sharedPreferences,
                startDestination = startDestination
            )
        }
    }
}