package com.example.groceryguru_derrick

import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.groceryguru_derrick.ui.theme.GroceryGuruDerrickTheme

class MainActivity : ComponentActivity() {

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        GroceryGuruDerrickTheme {
            Greeting("Android")
        }
    }
}