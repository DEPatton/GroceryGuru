package com.example.groceryguru_derrick

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.play.integrity.internal.e
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

    fun onLoginPress(view: View?){

        val i = Intent(this, LoginActivity::class.java)
        startActivity(i)
        finish()
    }

    fun onMapPress(view: View?){

        val i = Intent(this, StoreLocatorActivity::class.java)
        startActivity(i)
        finish()
    }
}