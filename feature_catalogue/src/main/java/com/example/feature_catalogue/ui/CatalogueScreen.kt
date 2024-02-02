package com.example.feature_catalogue.ui

import android.util.Log
import androidx.compose.animation.Animatable
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.feature_catalogue.R
import com.example.feature_catalogue.data.States
import com.example.feature_catalogue.domain.models.Item
import com.example.feature_catalogue.viewmodel.CatalogueViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogueScreen(
    catalogueViewModel: CatalogueViewModel = koinViewModel()
) {

    val state = catalogueViewModel.state.collectAsState()

    val menu = arrayOf("По популярности", "По уменьшению цены", "По возрастанию цены")
    var selectedText by remember { mutableStateOf(menu[0]) }
    var expanded by remember {
        mutableStateOf(false)
    }

    var tabIndex by remember { mutableIntStateOf(0) }
    val scope = rememberCoroutineScope()
    val tabs = listOf("Смотреть все", "Лицо", "Тело", "Загар", "Маски")

    var filteredList by remember {
        mutableStateOf<List<Item>>(emptyList())
    }

    var item by remember {
        mutableStateOf<Item?>(null)
    }

    var showCatalogueScreen by remember {
        mutableStateOf(true)
    }

    if (showCatalogueScreen) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Каталог",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontFamily = FontFamily(
                    Font(R.font.medium)
                ),
                fontSize = 16.sp
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 6.dp, top = 16.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.filter),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )

                Box(
                    modifier = Modifier
                        .width(180.dp)
                        .height(45.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    ExposedDropdownMenuBox(
                        expanded = expanded,
                        onExpandedChange = {
                            expanded = !expanded
                        }
                    ) {
                        TextField(
                            colors = TextFieldDefaults.colors(
                                unfocusedContainerColor = Color.Transparent,
                                focusedContainerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent
                            ),
                            textStyle = TextStyle(
                                fontSize = 10.sp
                            ),
                            value = selectedText,
                            onValueChange = {},
                            readOnly = true,
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                            modifier = Modifier.menuAnchor()
                        )

                        ExposedDropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            menu.forEach { item ->
                                DropdownMenuItem(
                                    text = {
                                        Text(
                                            text = item
                                        )
                                    },
                                    onClick = {
                                        selectedText = item
                                        expanded = false
                                    }
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painter = painterResource(id = R.drawable.filter2),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(top = 2.dp)
                )
                Text(
                    text = "Фильтры",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(end = 16.dp),
                    fontFamily = FontFamily(
                        Font(R.font.medium)
                    ),
                    fontSize = 14.sp
                )
            }

            ScrollableTabRow(
                selectedTabIndex = tabIndex,
                edgePadding = 1.dp,
                divider = {},
                indicator = {
                    SecondaryIndicator(
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
                            if (tabIndex == index) Color(
                                android.graphics.Color.parseColor(
                                    "#52606D"
                                )
                            ) else Color.LightGray
                        )
                    }
                    val tabShape = RoundedCornerShape(30.dp)

                    val tabModifier = Modifier
                        .background(color = color.value, shape = tabShape)
                        .height(28.dp)
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.padding(start = 6.dp, end = 6.dp, bottom = 6.dp)
                    ) {
                        Tab(
                            text = {
                                Row {
                                    Text(
                                        title,
                                        style = if (tabIndex == index) TextStyle(
                                            color = Color.White,
                                            fontSize = 14.sp
                                        ) else TextStyle(
                                            color = Color.Gray,
                                            fontSize = 14.sp
                                        )
                                    )
                                    if (tabIndex == index) Icon(
                                        painter = painterResource(id = R.drawable.cross),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .width(20.dp)
                                            .height(20.dp)
                                            .clickable {
                                                tabIndex = 0
                                            },
                                        tint = Color.White
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
                    LaunchedEffect(Unit) {
                        catalogueViewModel.getFullList()
                    }
                }

                1 -> {
                    LaunchedEffect(Unit) {
                        catalogueViewModel.getFaceFilter()
                        Log.d("getFaceFilter", "getFaceFilter=======")
                    }
                }

                2 -> {
                    LaunchedEffect(Unit) {
                        catalogueViewModel.getBodyFilter()
                    }
                }

                3 -> {
                    LaunchedEffect(Unit) {
                        catalogueViewModel.getSunFilter()
                    }
                }

                4 -> {
                    LaunchedEffect(Unit) {
                        catalogueViewModel.getMaskFilter()
                    }
                }
            }
            when (val currentState = state.value) {
                is States.Error -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        currentState.error?.let { Text(text = it) }
                    }
                }

                States.Loading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }

                is States.Success -> {
                    filteredList = currentState.items
                    when (selectedText) {
                        "По популярности" -> {
                            val rating = filteredList.sortedByDescending {
                                it.feedback.rating
                            }
                            LazyVerticalGrid(
                                columns = GridCells.Fixed(2),
                            ) {
                                items(rating) {
                                    ProductItem(item = it) {
                                        showCatalogueScreen = false
                                        item = it
                                    }
                                }
                            }
                        }

                        "По уменьшению цены" -> {
                            val priceDescending = filteredList.sortedByDescending {
                                it.price.priceWithDiscount.toInt()
                            }
                            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                                items(priceDescending) {
                                    ProductItem(item = it) {
                                        showCatalogueScreen = false
                                        item = it
                                    }
                                }
                            }
                        }

                        "По возрастанию цены" -> {
                            val priceAscending = filteredList.sortedBy {
                                it.price.priceWithDiscount.toInt()
                            }
                            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                                items(priceAscending) {
                                    ProductItem(item = it) {
                                        showCatalogueScreen = false
                                        item = it
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    } else {
        item?.let {
            DetailScreen(
                item = it,
                catalogueViewModel = catalogueViewModel,
                onBackClick = {
                    showCatalogueScreen = true
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    CatalogueScreen()
}