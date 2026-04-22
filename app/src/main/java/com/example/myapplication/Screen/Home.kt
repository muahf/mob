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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.AppFonts

@Composable
fun HomeScreen(
    onOpenDetails: () -> Unit
) {
    val cards = listOf(
        DestinationCardData("Niladri Reservoir", "Tekergat, Sunamgnj", 4.7f),
        DestinationCardData("Darma Reservoir", "Darma, Kuningan", 4.3f)
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
        Spacer(modifier = Modifier.height(20.dp))
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
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = null,
                    tint = Color(0xFF1C2A3A),
                    modifier = Modifier.size(20.dp)
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
                tint = Color(0xFF1A1D2E),
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
private fun TitleSection() {
    Text(
        text = "Explore the",
        fontSize = 36.sp,
        color = Color(0xFF1A1D2E),
        fontFamily = AppFonts.SfUi
    )

    val styled = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color(0xFF1A1D2E), fontWeight = FontWeight.Bold)) {
            append("Beautiful ")
        }
        withStyle(style = SpanStyle(color = Color(0xFFFF7E33), fontWeight = FontWeight.Bold)) {
            append("world!")
        }
    }
    Text(
        text = styled,
        fontSize = 46.sp,
        lineHeight = 50.sp,
        fontFamily = AppFonts.SfUi
    )
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
            fontFamily = AppFonts.SfUi
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
            Image(
                painter = painterResource(id = R.drawable.travel_mockup),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .clip(RoundedCornerShape(18.dp)),
                contentScale = ContentScale.Crop
            )

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
                    Text(text = "★", color = Color(0xFFFFB833), fontSize = 13.sp)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = data.rating.toString(),
                        color = Color(0xFF1A1D2E),
                        fontSize = 13.sp,
                        fontFamily = AppFonts.SfUi
                    )
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.poisk),
                    contentDescription = null,
                    tint = Color(0xFF8A8F9C),
                    modifier = Modifier.size(14.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = data.location,
                    color = Color(0xFF8A8F9C),
                    fontSize = 11.sp,
                    fontFamily = AppFonts.SfUi
                )
            }
        }
    }
}

private data class DestinationCardData(
    val title: String,
    val location: String,
    val rating: Float
)