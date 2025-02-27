package com.lakshay.rescuebite.screen

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun DonateFoodScreen(navController: NavHostController) {
    var foodName by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var contactInfo by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(text = "Donate Food", fontSize = 32.sp, color = Color.Black)

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = foodName, onValueChange = { foodName = it }, label = { Text("Food Name") })
        OutlinedTextField(value = quantity, onValueChange = { quantity = it }, label = { Text("Quantity") })
        OutlinedTextField(value = location, onValueChange = { location = it }, label = { Text("Location") })
        OutlinedTextField(value = contactInfo, onValueChange = { contactInfo = it }, label = { Text("Contact Information") })

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            if (foodName.isNotEmpty() && quantity.isNotEmpty() && location.isNotEmpty() && contactInfo.isNotEmpty()) {
                Toast.makeText(navController.context, "Donation Submitted!", Toast.LENGTH_SHORT).show()
                navController.navigateUp()
            } else {
                Toast.makeText(navController.context, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text(text = "Submit", fontSize = 20.sp, color = Color.White)
        }
    }
}
