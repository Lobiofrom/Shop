package com.example.feature_profile.ui

import android.content.SharedPreferences
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.const_vals.NAME
import com.example.const_vals.SURNAME
import com.example.const_vals.TELNUMBER
import com.example.feature_profile.R

@Composable
fun ProfileScreen(
    sharedPreferences: SharedPreferences,
    onClick: () -> Unit
) {
    val name = sharedPreferences.getString(NAME, "")
    val surname = sharedPreferences.getString(SURNAME, "")
    val number = sharedPreferences.getString(TELNUMBER, "")

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Личный кабинет",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.8.sp,
                    fontFamily = FontFamily(Font(R.font.regular)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center,
                )
            )
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
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = null,
                        modifier = Modifier
                            .height(24.dp)
                            .width(24.dp)
                            .align(Alignment.CenterStart)
                            .padding(start = 6.dp)
                    )
                    Column(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 50.dp)
                    ) {
                        Text(
                            text = "$name $surname",
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 18.2.sp,
                                fontFamily = FontFamily(Font(R.font.regular)),
                                fontWeight = FontWeight(500),
                                color = Color(0xFF000000),

                                ),
                            modifier = Modifier
                                .padding(start = 6.dp)
                        )
                        if (number != null) {
                            Text(
                                text = number,
                                style = TextStyle(
                                    fontSize = 10.sp,
                                    lineHeight = 11.sp,
                                    fontFamily = FontFamily(Font(R.font.regular)),
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFFA0A1A3),

                                    ),
                                modifier = Modifier
                                    .padding(start = 6.dp)
                            )
                        }
                    }

                    Image(
                        painter = painterResource(id = R.drawable.exit),
                        contentDescription = null,
                        modifier = Modifier
                            .height(24.dp)
                            .width(24.dp)
                            .align(Alignment.CenterEnd)
                            .padding(end = 6.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
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
                    Image(
                        painter = painterResource(id = R.drawable.heart),
                        contentDescription = null,
                        modifier = Modifier
                            .height(24.dp)
                            .width(24.dp)
                            .align(Alignment.CenterStart)
                            .padding(start = 6.dp)
                    )
                    Column(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 50.dp)
                    ) {
                        Text(
                            text = "Избранное",
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 18.2.sp,
                                fontFamily = FontFamily(Font(R.font.regular)),
                                fontWeight = FontWeight(500),
                                color = Color(0xFF000000),

                                ),
                            modifier = Modifier
                                .padding(start = 6.dp)
                        )
                        Text(
                            text = "1 товар",
                            style = TextStyle(
                                fontSize = 10.sp,
                                lineHeight = 11.sp,
                                fontFamily = FontFamily(Font(R.font.regular)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFFA0A1A3),

                                ),
                            modifier = Modifier
                                .padding(start = 6.dp)
                        )
                    }

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
                    Image(
                        painter = painterResource(id = R.drawable.shop),
                        contentDescription = null,
                        modifier = Modifier
                            .height(24.dp)
                            .width(24.dp)
                            .align(Alignment.CenterStart)
                            .padding(start = 6.dp)
                    )
                    Column(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 50.dp)
                    ) {
                        Text(
                            text = "Магазины",
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 18.2.sp,
                                fontFamily = FontFamily(Font(R.font.regular)),
                                fontWeight = FontWeight(500),
                                color = Color(0xFF000000),

                                ),
                            modifier = Modifier
                                .padding(start = 6.dp)
                        )
                    }

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
                    Image(
                        painter = painterResource(id = R.drawable.feed),
                        contentDescription = null,
                        modifier = Modifier
                            .height(24.dp)
                            .width(24.dp)
                            .align(Alignment.CenterStart)
                            .padding(start = 6.dp)
                    )
                    Column(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 50.dp)
                    ) {
                        Text(
                            text = "Обратная связь",
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 18.2.sp,
                                fontFamily = FontFamily(Font(R.font.regular)),
                                fontWeight = FontWeight(500),
                                color = Color(0xFF000000),

                                ),
                            modifier = Modifier
                                .padding(start = 6.dp)
                        )
                    }

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
                    Image(
                        painter = painterResource(id = R.drawable.offer),
                        contentDescription = null,
                        modifier = Modifier
                            .height(24.dp)
                            .width(24.dp)
                            .align(Alignment.CenterStart)
                            .padding(start = 6.dp)
                    )
                    Column(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 50.dp)
                    ) {
                        Text(
                            text = "Оферта",
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 18.2.sp,
                                fontFamily = FontFamily(Font(R.font.regular)),
                                fontWeight = FontWeight(500),
                                color = Color(0xFF000000),

                                ),
                            modifier = Modifier
                                .padding(start = 6.dp)
                        )
                    }

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
                    Image(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = null,
                        modifier = Modifier
                            .height(24.dp)
                            .width(24.dp)
                            .align(Alignment.CenterStart)
                            .padding(start = 6.dp)
                    )
                    Column(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 50.dp)
                    ) {
                        Text(
                            text = "Возврат товара",
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 18.2.sp,
                                fontFamily = FontFamily(Font(R.font.regular)),
                                fontWeight = FontWeight(500),
                                color = Color(0xFF000000),

                                ),
                            modifier = Modifier
                                .padding(start = 6.dp)
                        )
                    }

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
        }
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
                .align(Alignment.BottomCenter)
                .clickable {
                    onClick()
                    val editor = sharedPreferences.edit()
                    editor.putString(NAME, "")
                    editor.putString(SURNAME, "")
                    editor.putString(TELNUMBER, "")
                    editor.apply()
                }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .align(Alignment.Center)
                ) {
                    Text(
                        text = "Выйти",
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 18.2.sp,
                            fontFamily = FontFamily(Font(R.font.regular)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF000000),

                            ),
                        modifier = Modifier
                            .padding(start = 6.dp)
                    )
                }
            }
        }
    }
}