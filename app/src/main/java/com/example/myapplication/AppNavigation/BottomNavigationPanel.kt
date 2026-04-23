package com.example.myapplication.AppNavigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

data class BottomNavItem(
    val iconRes: Int,
    val label: String? = null
)

@Composable
fun BottomNavigationPanel(
    currentRoute: String?,
    onItemClick: (Screen) -> Unit,
    modifier: Modifier = Modifier
) {
    val selectedColor = Color(0xFF2EB6EC)
    val unselectedColor = Color(0xFF8D919E)

    val items = listOf(
        BottomNavItem(R.drawable.home, "Home") to Screen.Home,
        BottomNavItem(R.drawable.calendar, "Calendar") to Screen.Calendar,
        BottomNavItem(R.drawable.poisk) to Screen.Search,
        BottomNavItem(R.drawable.caht, "Messages") to Screen.Messages,
        BottomNavItem(R.drawable.profile, "Profile") to Screen.Profile
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(0.92f)
                .height(85.dp),
            color = Color.White,
            shape = RoundedCornerShape(28.dp),
            shadowElevation = 12.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                for ((item, screen) in items) {
                    val isSelected = currentRoute == screen.route

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .weight(1f)
                            .clickable { onItemClick(screen) }
                    ) {
                        when (screen) {
                            Screen.Search -> {
                                // Просто увеличенная иконка поиска
                                Image(
                                    painter = painterResource(id = item.iconRes),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .width(80.dp)
                                        .height(80.dp),
                                    contentScale = ContentScale.Fit
                                )
                            }
                            else -> {
                                Icon(
                                    painter = painterResource(id = item.iconRes),
                                    contentDescription = null,
                                    tint = if (isSelected) selectedColor else unselectedColor,
                                    modifier = Modifier.size(26.dp)
                                )
                            }
                        }

                        item.label?.let { label ->
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = label,
                                fontSize = 11.sp,
                                color = if (isSelected) selectedColor else unselectedColor,
                                fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal
                            )
                        }
                    }
                }
            }
        }
    }
}