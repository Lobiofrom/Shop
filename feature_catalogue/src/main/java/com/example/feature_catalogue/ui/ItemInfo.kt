package com.example.feature_catalogue.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.feature_catalogue.R
import com.example.feature_catalogue.domain.models.Info

@Composable
fun ItemInfo(
    info: Info
) {
    Box(
        modifier = Modifier.fillMaxWidth().padding(top = 6.dp)
    ) {
        Text(
            text = info.title,
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 15.6.sp,
                fontFamily = FontFamily(Font(R.font.regular)),
                fontWeight = FontWeight(400),
                color = Color(0xFF3E3E3E),

                ),
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 6.dp)
        )
        Text(
            text = info.value,
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 15.6.sp,
                fontFamily = FontFamily(Font(R.font.regular)),
                fontWeight = FontWeight(400),
                color = Color(0xFF3E3E3E),
            ),
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 6.dp)
        )
        HorizontalDivider(modifier = Modifier.align(Alignment.BottomCenter))
    }
}