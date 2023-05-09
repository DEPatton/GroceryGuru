package com.example.groceryguru_derrick

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.jar.Attributes.Name

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var firstName = Firebase_Base().user["firstName"]

        val welcomeText: TextView = findViewById<TextView>(R.id.welcomeText)
        if(firstName != "nullFN")
        {

            welcomeText.text = "Welcome Back, $firstName"

        }
        else
        {

            welcomeText.text = "Welcome! Please Sign In."

        }
    }
}