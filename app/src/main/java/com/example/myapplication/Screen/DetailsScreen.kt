package com.example.myapplication.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.AppFonts

// Data class для хранения информации о направлении
data class Destination(
    val id: Int,
    val title: String,
    val location: String,
    val subLocation: String,
    val rating: Double,
    val reviews: Int,
    val price: Int,
    val imageRes: Int
)

// Список направлений (4 функциональных + 1 нефункциональная заглушка)
val allDestinations = listOf(
    Destination(1, "Niladri Reservoir", "Tekergat, Sunamgnj", "Tekergat", 4.7, 2498, 59, R.drawable.f0300adc49024100a89c01bb1b2bacc523162e75),
    Destination(2, "Santorini Paradise", "Aegean Sea, Greece", "Oia Village", 4.9, 3150, 89, R.drawable.card1),
    Destination(3, "Bali Tropical", "Kuta, Indonesia", "Kuta Beach", 4.8, 4200, 45, R.drawable.card2),
    Destination(4, "Maldives Dreams", "North Male, Maldives", "Male Atoll", 5.0, 5600, 199, R.drawable.card3)
)

@Composable
fun DetailsScreen(
    initialDestinationId: Int = 1,
    onBackClick: () -> Unit
) {
    // Состояние для текущего выбранного направления
    var currentDestination by remember { mutableStateOf(allDestinations.find { it.id == initialDestinationId } ?: allDestinations[0]) }
    // Состояние для отслеживания выбранной миниатюры (для визуального выделения)
    var selectedIndex by remember { mutableIntStateOf(initialDestinationId - 1) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEBF6FF))
    ) {
        // Основное изображение (обновляется при выборе нового направления)
        Image(
            painter = painterResource(id = currentDestination.imageRes),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(390.dp),
            contentScale = ContentScale.Crop
        )

        // Верхние кнопки
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 24.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {

            CircleButton(
                icon = R.drawable.back,
                onClick = onBackClick,
                iconTint = Color.White,
                backgroundColor = Color.Black.copy(alpha = 0.3f),
                // Полупрозрачный белый
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Details",
                fontSize = 20.sp,
                color = Color.White,
                fontFamily = AppFonts.SfUi,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.weight(1f))
            CircleButton(
                icon = R.drawable.bookmark,
                iconTint = Color.White,
                onClick = {},
                size = 48.dp,

                iconSize = 24.dp,
                backgroundColor = Color.Black.copy(alpha = 0.3f)  // Полупрозрачный белый
            )
        }

        // Нижняя белая карточка
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 330.dp)
                .clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
                .background(Color.White)
                .padding(horizontal = 20.dp, vertical = 16.dp)
        ) {
            // Заголовок и аватар
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = currentDestination.title,
                        fontSize = 29.sp,
                        color = Color(0xFF1A1D2E),
                        fontFamily = AppFonts.SfUi,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = currentDestination.location,
                        fontSize = 14.sp,
                        color = Color(0xFF8A8F9C),
                        fontFamily = AppFonts.SfUi
                    )
                }
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFC8F4D5)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon2),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier.size(52.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Информация (локация, рейтинг, цена)
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.geo),
                    contentDescription = null,
                    tint = Color(0xFF8A8F9C),
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text(currentDestination.subLocation, fontSize = 14.sp, color = Color(0xFF8A8F9C), fontFamily = AppFonts.SfUi)
                Spacer(modifier = Modifier.weight(1f))
                Text("★ ${currentDestination.rating}", fontSize = 14.sp, color = Color(0xFFF8B429), fontFamily = AppFonts.SfUi, fontWeight = FontWeight.SemiBold)
                Text("(${currentDestination.reviews})", fontSize = 14.sp, color = Color(0xFF8A8F9C), fontFamily = AppFonts.SfUi)
                Spacer(modifier = Modifier.weight(1f))
                Text("$${currentDestination.price}", fontSize = 16.sp, color = Color(0xFF2EB6EC), fontFamily = AppFonts.SfUi, fontWeight = FontWeight.Bold)
                Text("/Person", fontSize = 14.sp, color = Color(0xFF8A8F9C), fontFamily = AppFonts.SfUi)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Галерея маленьких картинок (уменьшенный размер 44.dp)
            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                items(allDestinations.size) { index ->
                    val dest = allDestinations[index]
                    val isSelected = selectedIndex == index

                    Box(
                        modifier = Modifier
                            .size(52.dp)
                            .clip(RoundedCornerShape(14.dp))
                            .border(
                                width = if (isSelected) 3.dp else 0.dp,
                                color = Color(0xFF2EB6EC),
                                shape = RoundedCornerShape(14.dp)
                            )
                            .clickable {
                                currentDestination = dest
                                selectedIndex = index
                            }
                    ) {
                        Image(
                            painter = painterResource(id = dest.imageRes),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(RoundedCornerShape(14.dp)),
                            contentScale = ContentScale.Crop
                        )
                    }
                }

                // 5-я НЕФУНКЦИОНАЛЬНАЯ заглушка (не меняет данные)
                item {
                    Box(
                        modifier = Modifier
                            .size(52.dp)
                            .clip(RoundedCornerShape(14.dp))
                            .background(Color(0xFFE0E0E0))
                            .clickable {
                                // НИЧЕГО НЕ ДЕЛАЕТ - нефункциональная
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.card4),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier.size(50.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "About Destination",
                fontSize = 20.sp,
                color = Color(0xFF1A1D2E),
                fontFamily = AppFonts.SfUi,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(8.dp))

            // Текст с "Read More" оранжевым цветом
            Text(
                text = buildAnnotatedString {
                    append("You will get a complete travel package on the beaches. Packages in the form of airline tickets, recommended Hotel rooms, Transportation, Have you ever been on holiday to the Greek ETC... ")
                    withStyle(SpanStyle(color = Color(0xFFFF8C00), fontWeight = FontWeight.SemiBold)) {
                        append("Read More")
                    }
                },
                fontSize = 14.sp,
                lineHeight = 24.sp,
                color = Color(0xFF7D8796),
                fontFamily = AppFonts.SfUi
            )

            Spacer(modifier = Modifier.weight(1f))

            // Кнопка Book Now
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFF2EB6EC))
                    .clickable { },
                contentAlignment = Alignment.Center
            ) {
                Text("Book Now", color = Color.White, fontSize = 18.sp, fontFamily = AppFonts.SfUi, fontWeight = FontWeight.SemiBold)
            }
        }
    }
}

@Composable
private fun CircleButton(
    icon: Int,
    onClick: () -> Unit,
    size: Dp = 48.dp,
    iconSize: Dp = 24.dp,
    backgroundColor: Color = Color.White.copy(alpha = 0.3f),
    iconTint: Color = Color(0xFF1A1D2E)
) {
    Box(
        modifier = Modifier
            .size(size)
            .clip(CircleShape)
            .background(backgroundColor)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = iconTint,
            modifier = Modifier.size(iconSize)
        )
    }
}