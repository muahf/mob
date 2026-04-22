package com.example.myapplication.AppNavigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavigationPanel(
    currentRoute: String?,
    onItemClick: (Screen) -> Unit
) {
    val selectedColor = Color(0xFF2EB6EC)
    val unselectedColor = Color(0xFF8D919E)

    val items = listOf(
        NavItem.Home to Screen.Home,
        NavItem.Calendar to Screen.Calendar,
        NavItem.Search to Screen.Search,
        NavItem.Messages to Screen.Messages,
        NavItem.Profile to Screen.Profile
    )

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)),
        color = Color.White,
        shadowElevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            for ((item, screen) in items) {
                val isSelected = currentRoute == screen.route
                IconButton(
                    onClick = { onItemClick(screen) }
                ) {
                    Icon(
                        painter = painterResource(id = item.iconRes),
                        contentDescription = item.title,
                        tint = if (isSelected) selectedColor else unselectedColor,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}