package com.example.myapplication.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.AppFonts
import kotlinx.coroutines.delay

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun SplashScreen(
    onNextNavigate: () -> Unit
) {
    LaunchedEffect(Unit) {
        delay(1400)
        onNextNavigate()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF2EB6EC))
    ) {
        // Картинка по центру
        Image(
            painter = painterResource(R.drawable.samoletiki),
            contentDescription = "Logo",
            modifier = Modifier
                .size(132.dp)
                .align(Alignment.Center)
        )

        // Текст ближе к низу
        Text(
            text = "Travenor",
            fontSize = 38.sp,
            color = Color.White,
            fontFamily = AppFonts.GeometricSplash,
            fontWeight = FontWeight.Black,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 60.dp)  // Отступ от нижнего края
        )
    }
}