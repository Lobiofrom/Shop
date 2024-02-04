package com.example.feature_profile.ui

import androidx.compose.animation.Animatable
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.database.domain.models.ItemFromDb
import com.example.feature_profile.R
import com.example.feature_profile.viewmodel.ProfileViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun SelectionScreen(
    profileViewModel: ProfileViewModel = koinViewModel(),
    navController: NavController
) {
    var listFromDb by remember {
        mutableStateOf<List<ItemFromDb>>(emptyList())
    }

    LaunchedEffect(key1 = profileViewModel.itemList) {
        profileViewModel.itemList.collect {
            listFromDb = it
        }
    }
    var tabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf(stringResource(R.string.goods), stringResource(R.string.brands))
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.back_arrow),
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .padding(6.dp)
                    .align(Alignment.CenterStart)
                    .clickable {
                        navController.popBackStack()
                    }
            )
            Text(
                text = stringResource(R.string.selection2),
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(6.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.8.sp,
                    fontFamily = FontFamily(Font(R.font.regular)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center,
                )
            )
        }
        TabRow(
            modifier = Modifier.padding(16.dp),
            selectedTabIndex = tabIndex,
            divider = {},
            indicator = {
                TabRowDefaults.SecondaryIndicator(
                    color = Color.Transparent
                )
            },
        ) {
            tabs.forEachIndexed { index, title ->
                val color = remember {
                    Animatable(Color.DarkGray)
                }
                scope.launch {
                    color.animateTo(
                        if (tabIndex == index) Color.White
                        else Color.LightGray
                    )
                }
                val tabShape = RoundedCornerShape(5.dp)

                val tabModifier = Modifier
                    .background(color = color.value, shape = tabShape)
                    .height(40.dp)
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Tab(
                        text = {
                            Row {
                                Text(
                                    title,
                                    style = if (tabIndex == index) TextStyle(
                                        color = Color.Black,
                                        fontSize = 14.sp
                                    ) else TextStyle(
                                        color = Color.Gray,
                                        fontSize = 14.sp
                                    )
                                )
                            }
                        },
                        selected = tabIndex == index,
                        onClick = {
                            tabIndex = index
                        },
                        modifier = tabModifier
                    )
                }
            }
        }
        when (tabIndex) {
            0 -> {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                ) {
                    items(listFromDb) {
                        ProductFromDbItem(itemFromDb = it, profileViewModel = profileViewModel)
                    }
                }
            }

            1 -> {}
        }
    }
}