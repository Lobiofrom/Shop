package com.example.feature_catalogue.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.feature_catalogue.R
import com.example.feature_catalogue.domain.models.Item
import com.example.feature_catalogue.viewmodel.CatalogueViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailScreen(
    item: Item,
    catalogueViewModel: CatalogueViewModel,
    onBackClick: () -> Unit
) {
    val listFromDb = catalogueViewModel.itemList.collectAsState()

    Box(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(6.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 6.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.back_arrow),
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier
                        .padding(6.dp)
                        .align(Alignment.CenterStart)
                        .clickable {
                            onBackClick()
                        }
                )
                Icon(
                    painter = painterResource(id = R.drawable.share),
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier
                        .padding(6.dp)
                        .align(Alignment.CenterEnd)
                        .height(24.dp)
                        .width(24.dp)
                )
            }
            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                item {
                    val pictures1 = listOf(
                        R.drawable.razor,
                        R.drawable.green
                    )
                    val pictures2 = listOf(
                        R.drawable.deep,
                        R.drawable.lotion
                    )
                    val pictures3 = listOf(
                        R.drawable.green,
                        R.drawable.razor
                    )
                    val pictures4 = listOf(
                        R.drawable.card,
                        R.drawable.pink_card
                    )
                    val pictures5 = listOf(
                        R.drawable.lotion,
                        R.drawable.card
                    )
                    val pictures6 = listOf(
                        R.drawable.razor,
                        R.drawable.deep
                    )
                    val pictures7 = listOf(
                        R.drawable.pink_card,
                        R.drawable.card
                    )
                    val pictures8 = listOf(
                        R.drawable.deep,
                        R.drawable.green
                    )

                    val pagerState = rememberPagerState(pageCount = {
                        pictures1.size
                    })

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(370.dp)
                    ) {
                        HorizontalPager(
                            state = pagerState,
                            modifier = Modifier
                                .align(Alignment.Center)
                                .shadow(elevation = 15.dp, shape = RoundedCornerShape(20.dp))
                        ) { page ->
                            AsyncImage(
                                model = when (item.id) {
                                    "cbf0c984-7c6c-4ada-82da-e29dc698bb50" -> pictures1[page]
                                    "54a876a5-2205-48ba-9498-cfecff4baa6e" -> pictures2[page]
                                    "75c84407-52e1-4cce-a73a-ff2d3ac031b3" -> pictures3[page]
                                    "16f88865-ae74-4b7c-9d85-b68334bb97db" -> pictures4[page]
                                    "26f88856-ae74-4b7c-9d85-b68334bb97db" -> pictures5[page]
                                    "15f88865-ae74-4b7c-9d81-b78334bb97db" -> pictures6[page]
                                    "88f88865-ae74-4b7c-9d81-b78334bb97db" -> pictures7[page]
                                    "55f58865-ae74-4b7c-9d81-b78334bb97db" -> pictures8[page]
                                    else -> null
                                },
                                contentScale = ContentScale.Crop,
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        Row(
                            Modifier
                                .wrapContentHeight()
                                .fillMaxWidth()
                                .align(Alignment.BottomCenter)
                                .padding(bottom = 8.dp), horizontalArrangement = Arrangement.Center
                        ) {
                            repeat(pagerState.pageCount) { iteration ->
                                val color =
                                    if (pagerState.currentPage == iteration) Color(0xFFD62F89) else Color(
                                        0xFFDEDEDE
                                    )
                                Box(
                                    modifier = Modifier
                                        .padding(2.dp)
                                        .clip(CircleShape)
                                        .background(color)
                                        .size(10.dp)
                                )
                            }
                        }
                        AsyncImage(
                            model = if (listFromDb.value.any {
                                    it.id == item.id
                                }) R.drawable.red_heart else R.drawable.empty_heart,
                            contentDescription = null,
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(10.dp)
                                .width(24.dp)
                                .height(24.dp)
                                .clickable {
                                    val foundItem = listFromDb.value.find {
                                        it.id == item.id
                                    }
                                    if (foundItem == null) {
                                        catalogueViewModel.upsertItemToDb(
                                            id = item.id,
                                            oldPrice = item.price.price,
                                            newPrice = item.price.priceWithDiscount,
                                            discount = item.price.discount.toString(),
                                            title = item.title,
                                            subtitle = item.subtitle,
                                            rating = item.feedback.rating.toString(),
                                            feedBackCount = item.feedback.count.toString()
                                        )
                                    } else {
                                        catalogueViewModel.deleteItem(foundItem)
                                    }
                                }
                        )
                        AsyncImage(
                            model = R.drawable.questionjpg,
                            contentDescription = null,
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(6.dp)
                                .width(24.dp)
                                .height(24.dp)
                        )
                    }
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 3.dp, end = 3.dp)
                        ) {
                            Text(
                                text = item.title,
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    lineHeight = 20.8.sp,
                                    fontFamily = FontFamily(Font(R.font.regular)),
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFFA0A1A3),

                                    ),
                                modifier = Modifier.padding(start = 3.dp, top = 6.dp)
                            )
                            Text(
                                text = item.subtitle,
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    lineHeight = 26.sp,
                                    fontFamily = FontFamily(Font(R.font.regular)),
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF000000),

                                    ),
                                modifier = Modifier.padding(start = 3.dp, top = 6.dp)
                            )
                            Text(
                                text = pluralStringResource(
                                    id = R.plurals.order_quantity,
                                    count = item.available,
                                    item.available
                                ),
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    lineHeight = 15.6.sp,
                                    fontFamily = FontFamily(Font(R.font.regular)),
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFFA0A1A3),

                                    ),
                                modifier = Modifier.padding(start = 3.dp, top = 6.dp)
                            )
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(2.dp, Alignment.Start),
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(3.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.icon),
                                    contentDescription = null,
                                    tint = Color(0xFFF9A249)
                                )
                                Text(
                                    text = item.feedback.rating.toString(), style = TextStyle(
                                        fontSize = 12.sp,
                                        lineHeight = 15.6.sp,
                                        fontFamily = FontFamily(Font(R.font.regular)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFFA0A1A3),

                                        )
                                )

                                Text(
                                    text = pluralStringResource(
                                        id = R.plurals.feedback_quantity,
                                        count = item.feedback.count, item.feedback.count
                                    ),
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        lineHeight = 15.6.sp,
                                        fontFamily = FontFamily(Font(R.font.regular)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFFA0A1A3),
                                    )
                                )
                            }
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(
                                    6.dp,
                                    Alignment.CenterHorizontally
                                ),
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(3.dp)
                            ) {
                                Text(
                                    text = "${item.price.priceWithDiscount} ${item.price.unit}",
                                    style = TextStyle(
                                        fontSize = 24.sp,
                                        lineHeight = 31.2.sp,
                                        fontFamily = FontFamily(Font(R.font.regular)),
                                        fontWeight = FontWeight(500),
                                        color = Color(0xFF000000),
                                    )
                                )
                                Text(
                                    text = "${item.price.price} ${item.price.unit}",
                                    textDecoration = TextDecoration.LineThrough,
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        lineHeight = 15.6.sp,
                                        fontFamily = FontFamily(Font(R.font.regular)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFFA0A1A3),

                                        ),
                                    modifier = Modifier.padding(start = 3.dp, top = 6.dp)
                                )
                                Box(
                                    modifier = Modifier
                                        .width(34.dp)
                                        .height(16.dp)
                                        .background(
                                            color = Color(0xFFD62F89),
                                            shape = RoundedCornerShape(size = 4.dp)
                                        )
                                        .padding(
                                            start = 6.dp,
                                            top = 3.dp,
                                            end = 6.dp,
                                            bottom = 3.dp
                                        )
                                ) {
                                    Text(
                                        text = "-${item.price.discount}%",
                                        modifier = Modifier.align(Alignment.Center),
                                        style = TextStyle(
                                            fontSize = 9.sp,
                                            lineHeight = 9.9.sp,
                                            fontFamily = FontFamily(Font(R.font.regular)),
                                            fontWeight = FontWeight(400),
                                            color = Color(0xFFFFFFFF),
                                            textAlign = TextAlign.Center,
                                        )
                                    )
                                }
                            }
                            Text(
                                text = stringResource(R.string.description),
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    lineHeight = 20.8.sp,
                                    fontFamily = FontFamily(Font(R.font.regular)),
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF000000),
                                )
                            )
                            var expanded by remember {
                                mutableStateOf(true)
                            }
                            AnimatedVisibility(visible = expanded) {
                                Column {
                                    Surface(
                                        color = Color(0xFFDEDEDE),
                                        shape = RoundedCornerShape(5.dp),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(48.dp)
                                            .padding(
                                                start = 9.dp,
                                                top = 8.dp,
                                                end = 8.dp,
                                                bottom = 8.dp
                                            )
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                        ) {
                                            Text(
                                                text = item.title,
                                                style = TextStyle(
                                                    fontSize = 14.sp,
                                                    lineHeight = 18.2.sp,
                                                    fontFamily = FontFamily(Font(R.font.regular)),
                                                    fontWeight = FontWeight(500),
                                                    color = Color(0xFF000000),
                                                ),
                                                modifier = Modifier
                                                    .align(Alignment.CenterStart)
                                                    .padding(start = 6.dp)
                                            )
                                            Image(
                                                painter = painterResource(id = R.drawable.arrow),
                                                contentDescription = null,
                                                modifier = Modifier
                                                    .height(24.dp)
                                                    .width(24.dp)
                                                    .align(Alignment.CenterEnd)
                                                    .padding(end = 6.dp)
                                            )
                                        }
                                    }
                                    Text(
                                        text = item.description,
                                        style = TextStyle(
                                            fontSize = 12.sp,
                                            lineHeight = 15.6.sp,
                                            fontFamily = FontFamily(Font(R.font.regular)),
                                            fontWeight = FontWeight(400),
                                            color = Color(0xFF3E3E3E),

                                            ),
                                        modifier = Modifier
                                            .padding(start = 6.dp)
                                    )
                                }
                            }
                            Text(
                                text = if (expanded) stringResource(R.string.hide) else stringResource(
                                    R.string.more
                                ),
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    lineHeight = 15.6.sp,
                                    fontFamily = FontFamily(Font(R.font.regular)),
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFFA0A1A3),
                                ),
                                modifier = Modifier
                                    .padding(6.dp)
                                    .clickable {
                                        expanded = !expanded
                                    }
                            )
                            Text(
                                text = stringResource(R.string.feat),
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    lineHeight = 20.8.sp,
                                    fontFamily = FontFamily(Font(R.font.regular)),
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF000000),

                                    ),
                                modifier = Modifier
                                    .padding(start = 6.dp, top = 16.dp, bottom = 16.dp)
                            )
                        }
                    }
                }

                items(item.info) {
                    ItemInfo(info = it)
                }
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 3.dp, end = 3.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.inside),
                            style = TextStyle(
                                fontSize = 16.sp,
                                lineHeight = 20.8.sp,
                                fontFamily = FontFamily(Font(R.font.regular)),
                                fontWeight = FontWeight(500),
                                color = Color(0xFF000000),

                                ),
                            modifier = Modifier
                                .padding(start = 6.dp, top = 16.dp, bottom = 16.dp)
                        )
                        var expanded by remember {
                            mutableStateOf(false)
                        }
                        Text(
                            text = item.ingredients,
                            style = TextStyle(
                                fontSize = 12.sp,
                                lineHeight = 15.6.sp,
                                fontFamily = FontFamily(Font(R.font.regular)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF3E3E3E),
                            ),
                            modifier = Modifier
                                .padding(start = 6.dp, top = 16.dp, bottom = 16.dp),
                            maxLines = if (expanded) Int.MAX_VALUE else 2
                        )
                        Text(
                            text = if (expanded) stringResource(R.string.hide) else stringResource(
                                R.string.more
                            ), style = TextStyle(
                                fontSize = 12.sp,
                                lineHeight = 15.6.sp,
                                fontFamily = FontFamily(Font(R.font.regular)),
                                fontWeight = FontWeight(500),
                                color = Color(0xFFA0A1A3),
                            ),
                            modifier = Modifier
                                .padding(start = 6.dp, bottom = 26.dp)
                                .clickable {
                                    expanded = !expanded
                                }
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    color = Color(0xFFD62F89),
                                    shape = RoundedCornerShape(size = 3.dp)
                                )
                        ) {
                            Text(
                                text = "${item.price.priceWithDiscount} ${item.price.unit}",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    lineHeight = 18.2.sp,
                                    fontFamily = FontFamily(Font(R.font.regular)),
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFFFFFFFF),

                                    ),
                                modifier = Modifier
                                    .align(Alignment.CenterStart)
                                    .padding(10.dp)
                            )
                            Text(
                                text = "${item.price.price} ${item.price.unit}",
                                textDecoration = TextDecoration.LineThrough,
                                style = TextStyle(
                                    fontSize = 10.sp,
                                    lineHeight = 11.sp,
                                    fontFamily = FontFamily(Font(R.font.regular)),
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFFFF8AC9),

                                    ),
                                modifier = Modifier
                                    .padding(start = 50.dp)
                                    .align(Alignment.CenterStart)
                            )
                            Text(
                                text = stringResource(R.string.to_basket),
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    lineHeight = 18.2.sp,
                                    fontFamily = FontFamily(Font(R.font.regular)),
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFFFFFFFF),

                                    textAlign = TextAlign.Right,
                                ),
                                modifier = Modifier
                                    .align(Alignment.CenterEnd)
                                    .padding(10.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}