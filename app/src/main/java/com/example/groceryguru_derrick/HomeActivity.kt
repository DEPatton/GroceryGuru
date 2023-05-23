package com.example.groceryguru_derrick

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast



class HomeActivity : AppCompatActivity() {

    private lateinit var menuimagebutton: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        /*
        var firstName = Firebase_Base().user["firstName"]

        val welcomeText: TextView = findViewById<TextView>(R.id.welcomeText)
        if (firstName != "nullFN") {

            welcomeText.text = "Welcome Back, $firstName"

        } else {
            welcomeText.text = "Welcome! Please Sign In."
        }*/

    }

    fun onClick(view: View) {
        // Referencing and Initializing the button
        menuimagebutton = findViewById(R.id.clickBtn)

        // Setting onClick behavior to the button
        menuimagebutton.setOnClickListener {
            // Initializing the popup menu and giving the reference as current context
            val popupMenu = PopupMenu(this@HomeActivity, menuimagebutton)

            // Inflating popup menu from popup_menu.xml file
            popupMenu.menuInflater.inflate(R.menu.dropdown_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { menuItem ->
                // Toast message on menu item clicked
                Toast.makeText(
                    this@HomeActivity,
                    "You Clicked " + menuItem.title,
                    Toast.LENGTH_SHORT
                ).show()
                true
            }
            // Showing the popup menu
           // popupMenu.show()
            var menuitem = title
            if(menuitem == "Profile")
            {
                menuimagebutton.setOnClickListener{
                    val intent = Intent(this, ProfileActivity::class.java)
                    // start your next activity
                    startActivity(intent)
                }
            }
        }
    }
}
