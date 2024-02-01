package com.example.shop.presentation

import android.content.SharedPreferences
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.const_vals.NAME
import com.example.const_vals.SURNAME
import com.example.const_vals.TELNUMBER
import com.example.shop.R
import com.example.shop.utils.PhoneField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Onboarding(
    modifier: Modifier,
    sharedPreferences: SharedPreferences,
    onClick: () -> Unit
) {
    Box(modifier = modifier.fillMaxSize()) {
        Text(
            text = "Вход",
            modifier = Modifier.align(Alignment.TopCenter),
            fontFamily = FontFamily(
                Font(R.font.medium)
            ),
            fontSize = 16.sp
        )
        Column(
            modifier = Modifier.align(Alignment.Center)
        ) {
            var name by rememberSaveable { mutableStateOf("") }
            TextField(
                trailingIcon = {
                    if (name.isNotEmpty()) {
                        Icon(
                            painter = painterResource(id = R.drawable.cross),
                            contentDescription = null,
                            modifier = Modifier
                                .width(28.dp)
                                .height(28.dp)
                                .clickable {
                                    name = ""
                                }
                        )
                    }
                },
                value = name,
                onValueChange = {
                    name = it
                },
                label = {
                    Text(
                        text = "Имя"
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = if (name.isNotEmpty() && name.matches("[а-яА-Я]+".toRegex())) Color.LightGray
                    else Color(0xFFEB5757)
                ),
                modifier = Modifier
                    .width(343.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 3.dp)
            )

            var surname by rememberSaveable { mutableStateOf("") }

            TextField(
                trailingIcon = {
                    if (surname.isNotEmpty()) {
                        Icon(
                            painter = painterResource(id = R.drawable.cross),
                            contentDescription = null,
                            modifier = Modifier
                                .width(28.dp)
                                .height(28.dp)
                                .clickable {
                                    surname = ""
                                }
                        )
                    }
                },
                value = surname,
                onValueChange = {
                    surname = it
                },
                label = {
                    Text(
                        text = "Фамилия"
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = if (surname.isNotEmpty() && surname.matches("[а-яА-Я]+".toRegex())) Color.LightGray
                    else Color(0xFFEB5757)
                ),
                modifier = Modifier
                    .width(343.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 3.dp)
            )
            var phoneNumber by rememberSaveable {
                mutableStateOf("")
            }
            PhoneField(
                phone = phoneNumber,
                mask = "+7 (000) 000-00-00",
                onPhoneChanged = {
                    phoneNumber = it
                },
                label = {
                    Text(text = "номер телефона")
                },
                modifier = Modifier
                    .width(343.dp)
                    .align(Alignment.CenterHorizontally),
                trailingIcon = {
                    if (phoneNumber.isNotEmpty()) {
                        Icon(
                            painter = painterResource(id = R.drawable.cross),
                            contentDescription = null,
                            modifier = Modifier
                                .width(28.dp)
                                .height(28.dp)
                                .clickable {
                                    phoneNumber = ""
                                }
                        )
                    }
                }
            )

            val isAllValid =
                name.isNotEmpty() && name.matches("[а-яА-Я]+".toRegex()) && surname.isNotEmpty() && surname.matches(
                    "[а-яА-Я]+".toRegex()
                ) && phoneNumber.length == 10

            Button(
                onClick = {
                    val editor = sharedPreferences.edit()
                    editor.putString(NAME, name)
                    editor.putString(SURNAME, surname)
                    val formattedNumber = "+7-(${phoneNumber.substring(0, 3)})${phoneNumber.substring(3, 6)}-${phoneNumber.substring(6, 8)}-${phoneNumber.substring(8)}"
                    editor.putString(TELNUMBER, formattedNumber)
                    editor.apply()
                    onClick()
                },
                modifier = Modifier
                    .width(343.dp)
                    .padding(top = 16.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(
                        android.graphics.Color.parseColor(
                            "#D62F89"
                        )
                    ),
                    disabledContainerColor = Color(
                        android.graphics.Color.parseColor(
                            "#FF8AC9"
                        )
                    )
                ),
                enabled = isAllValid
            ) {
                Text(text = "Войти")
            }
        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(bottom = 6.dp)
        ) {
            Text(
                text = "Нажимая кнопку “Войти”, Вы принимаете",
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 10.sp,
                fontFamily = FontFamily(
                    Font(R.font.regular)
                ),
                color = Color.LightGray
            )
            Text(
                text = "условия программы лояльности",
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 10.sp,
                fontFamily = FontFamily(
                    Font(R.font.regular)
                ),
                color = Color.LightGray,
                textDecoration = TextDecoration.Underline
            )
        }
    }
}