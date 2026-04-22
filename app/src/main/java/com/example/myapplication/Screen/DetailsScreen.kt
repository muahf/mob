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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.weight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.AppFonts

@Composable
fun DetailsScreen(
    onBackClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEBF6FF))
    ) {
        Image(
            painter = painterResource(id = R.drawable.f0300adc49024100a89c01bb1b2bacc523162e75),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(390.dp),
            contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 18.dp)
        ) {
            CircleButton(icon = R.drawable.back, onClick = onBackClick)
            Spacer(modifier = Modifier.weight(1f))
            CircleButton(icon = R.drawable.bookmark, onClick = {})
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 330.dp)
                .clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
                .background(Color.White)
                .padding(horizontal = 20.dp, vertical = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Niladri Reservoir",
                        fontSize = 29.sp,
                        color = Color(0xFF1A1D2E),
                        fontFamily = AppFonts.SfUi,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Tekergat, Sunamgnj",
                        fontSize = 14.sp,
                        color = Color(0xFF8A8F9C),
                        fontFamily = AppFonts.SfUi
                    )
                }
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFC8F4D5)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = null,
                        tint = Color(0xFF1A1D2E),
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.poisk),
                    contentDescription = null,
                    tint = Color(0xFF8A8F9C),
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text("Tekergat", fontSize = 14.sp, color = Color(0xFF8A8F9C), fontFamily = AppFonts.SfUi)
                Spacer(modifier = Modifier.weight(1f))
                Text("★ 4.7", fontSize = 14.sp, color = Color(0xFFF8B429), fontFamily = AppFonts.SfUi, fontWeight = FontWeight.SemiBold)
                Text("(2498)", fontSize = 14.sp, color = Color(0xFF8A8F9C), fontFamily = AppFonts.SfUi)
                Spacer(modifier = Modifier.weight(1f))
                Text("\$59", fontSize = 16.sp, color = Color(0xFF2EB6EC), fontFamily = AppFonts.SfUi, fontWeight = FontWeight.Bold)
                Text("/Person", fontSize = 14.sp, color = Color(0xFF8A8F9C), fontFamily = AppFonts.SfUi)
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                items(listOf(1, 2, 3, 4, 5)) {
                    Image(
                        painter = painterResource(id = R.drawable.f0300adc49024100a89c01bb1b2bacc523162e75),
                        contentDescription = null,
                        modifier = Modifier
                            .size(44.dp)
                            .clip(RoundedCornerShape(14.dp)),
                        contentScale = ContentScale.Crop
                    )
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
            Text(
                text = "You will get a complete travel package on the beaches. Packages in the form of airline tickets, recommended hotel rooms, transportation, and more.",
                fontSize = 14.sp,
                lineHeight = 24.sp,
                color = Color(0xFF7D8796),
                fontFamily = AppFonts.SfUi
            )
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
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
private fun CircleButton(icon: Int, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(38.dp)
            .clip(CircleShape)
            .background(Color.White.copy(alpha = 0.9f))
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = Color(0xFF1A1D2E),
            modifier = Modifier.size(18.dp)
        )
    }
}