package com.lakshay.rescuebite.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WelcomeScreen(onDonateClick: () -> Unit, onRequestClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "RescueBite", fontSize = 48.sp, fontWeight = FontWeight.Bold, color = Color.Black)
        Text(text = "Reduce Food Waste, Share with Those in Need", fontSize = 20.sp, color = Color.Black)

        Spacer(modifier = Modifier.height(50.dp))

        Button(
            onClick = onDonateClick,
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00796B))
        ) {
            Text(text = "Donate Food", fontSize = 20.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = onRequestClick,
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF388E3C))
        ) {
            Text(text = "Request Food", fontSize = 20.sp, color = Color.White)
        }
    }
}
