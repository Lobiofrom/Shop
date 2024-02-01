package com.example.feature_catalogue.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductItem(
    item: Item,
    onItemClick: () -> Unit
) {

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

    Card(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color(0xFFF8F8F8),
                shape = RoundedCornerShape(size = 8.dp)
            )
            .width(168.dp)
            .height(287.dp)
            .clickable { onItemClick() },
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFFFFF)
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(144.dp)
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
                    contentScale = ContentScale.FillBounds,
                    contentDescription = null
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
                            .size(6.dp)
                    )
                }
            }
            Icon(
                painter = painterResource(id = R.drawable.empty_heart),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(1.dp)
                    .width(24.dp)
                    .height(24.dp)
                    .clickable { }
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
                    text = item.price.price,
                    textDecoration = TextDecoration.LineThrough,
                    style = TextStyle(
                        fontSize = 9.sp,
                        lineHeight = 9.9.sp,
                        fontFamily = FontFamily(Font(R.font.regular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFFA0A1A3),
                    ),
                    modifier = Modifier.padding(start = 3.dp, top = 6.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        6.dp,
                        Alignment.CenterHorizontally
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(3.dp)
                ) {
                    Text(
                        text = item.price.priceWithDiscount, style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 18.2.sp,
                            fontFamily = FontFamily(Font(R.font.regular)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF000000),
                        )
                    )
                    Box(
                        modifier = Modifier
                            .width(34.dp)
                            .height(16.dp)
                            .background(
                                color = Color(0xFFD62F89),
                                shape = RoundedCornerShape(size = 4.dp)
                            )
                            .padding(start = 6.dp, top = 3.dp, end = 6.dp, bottom = 3.dp)
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
                    text = item.title, style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 15.6.sp,
                        fontFamily = FontFamily(Font(R.font.regular)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                    ),
                    modifier = Modifier.padding(3.dp)
                )
                Text(
                    text = item.subtitle,
                    style = TextStyle(
                        fontSize = 10.sp,
                        lineHeight = 11.sp,
                        fontFamily = FontFamily(Font(R.font.regular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF3E3E3E),
                    ),
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.padding(3.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(2.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(3.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon), contentDescription = null,
                        tint = Color(0xFFF9A249)
                    )
                    Text(
                        text = item.feedback.rating.toString(), style = TextStyle(
                            fontSize = 9.sp,
                            lineHeight = 9.9.sp,
                            fontFamily = FontFamily(Font(R.font.regular)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFFF9A249),
                        )
                    )
                    Text(
                        text = "(${item.feedback.count})",
                        style = TextStyle(
                            fontSize = 9.sp,
                            lineHeight = 9.9.sp,
                            fontFamily = FontFamily(Font(R.font.regular)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFFA0A1A3),
                        )
                    )
                }
            }
            AsyncImage(
                model = R.drawable.add,
                contentDescription = null,
                modifier = Modifier
                    .width(32.dp)
                    .height(32.dp)
                    .align(Alignment.BottomEnd)
            )
        }
    }
}