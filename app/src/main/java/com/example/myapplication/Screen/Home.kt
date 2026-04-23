package com.example.myapplication.Screen

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.ui.unit.sp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.AppFonts

@Composable
fun HomeScreen(
    onOpenDetails: () -> Unit
) {
    val cards = listOf(
        DestinationCardData(
            title = "Niladri Reservoir",
            location = "Tekergat, Sunamgnj",
            rating = 4.7f,
            imageRes = R.drawable.f0300adc49024100a89c01bb1b2bacc523162e75 // 👈 было второе
        ),
        DestinationCardData(
            title = "Darma Reservoir",
            location = "Darma, Kuningan",
            rating = 4.3f,
            imageRes = R.drawable.ce609041af2a3946819dfaa9194f6eb90ce77764 // 👈 было первое
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9FBFF))
            .padding(horizontal = 20.dp, vertical = 16.dp)
    ) {
        HeaderSection()
        Spacer(modifier = Modifier.height(18.dp))
        TitleSection()
        Spacer(modifier = Modifier.height(28.dp))  // Уменьшил отступ
        SectionHeader()
        Spacer(modifier = Modifier.height(14.dp))

        LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            items(cards) { item ->
                DestinationCard(
                    data = item,
                    onClick = onOpenDetails
                )
            }
        }

        // Отступ снизу для навигации (50 dp)
        Spacer(modifier = Modifier.height(50.dp))
    }
}

@Composable
private fun HeaderSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFBDE8FF)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier.size(40.dp)
                )
            }

            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Leonardo",
                color = Color(0xFF1A1D2E),
                fontSize = 14.sp,
                fontFamily = AppFonts.SfUi
            )
        }

        Box(
            modifier = Modifier
                .size(38.dp)
                .clip(CircleShape)
                .background(Color(0xFFEDEEF2)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.notification),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.size(56.dp)
            )
        }
    }
}
val SfUiLight = FontFamily(
    Font(R.font.sfuidisplaylight, FontWeight.Light)
)
@Composable
private fun TitleSection() {
    Text(
        text = "Explore the",
        fontSize = 28.sp,
        fontWeight = FontWeight.Light,
        color = Color(0xFF1A1D2E).copy(alpha = 0.6f)
    )

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Beautiful ",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1A1D2E),
            fontFamily = AppFonts.SfUi
        )

        Box {
            Text(
                text = "world!",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFF7E33),
                fontFamily = AppFonts.SfUi
            )

            Image(
                painter = painterResource(id = R.drawable.underline),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .offset(y = 6.dp) // 👈 подгон под макет
                    .width(90.dp)
                    .height(10.dp)
            )
        }
    }
}
@Composable
private fun SectionHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Best Destination",
            fontSize = 23.sp,
            color = Color(0xFF1A1D2E),
            fontWeight = FontWeight.SemiBold,
            fontFamily = AppFonts.SfUi
        )
        Text(
            text = "View all",
            fontSize = 15.sp,
            color = Color(0xFFFF914D),
            fontFamily = AppFonts.SfUi,
            modifier = Modifier.clickable { }  // Добавил кликабельность
        )
    }
}

@Composable
private fun DestinationCard(
    data: DestinationCardData,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        modifier = Modifier
            .width(240.dp)
            .clickable(onClick = onClick)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp)
            ) {
                Image(
                    painter = painterResource(id = data.imageRes),
                    contentDescription = data.title,
                    modifier = Modifier
                        .matchParentSize()
                        .clip(RoundedCornerShape(18.dp)),
                    contentScale = ContentScale.Crop
                )

                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(10.dp)
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.7f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.bookmark),
                        contentDescription = null,
                        tint = Color(0xFF1A1D2E),
                        modifier = Modifier.size(18.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = data.title,
                    fontSize = 16.sp,
                    color = Color(0xFF1A1D2E),
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = AppFonts.SfUi
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.star),
                        contentDescription = null,
                        tint = Color(0xFFFFC107),
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = data.rating.toString(),
                        color = Color(0xFF1A1D2E),
                        fontSize = 13.sp,
                        fontFamily = AppFonts.SfUi
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // ✅ ГЕОЛОКАЦИЯ И КАРТИНКА В ОДНОЙ СТРОКЕ
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Левая часть: иконка гео + текст
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.geo),
                        contentDescription = null,
                        tint = Color(0xFF8A8F9C),
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = data.location,
                        color = Color(0xFF8A8F9C),
                        fontSize = 12.sp,
                        fontFamily = AppFonts.SfUi
                    )
                }

                // Правая часть: картинка users
                Image(
                    painter = painterResource(id = R.drawable.users),
                    contentDescription = null,
                    modifier = Modifier.size(55.dp)
                )
            }
        }
    }
}

private data class DestinationCardData(
    val title: String,
    val location: String,
    val rating: Float,
    val imageRes: Int
)