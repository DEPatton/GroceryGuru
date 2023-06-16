package com.example.groceryguru_derrick

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.groceryguru_derrick.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    lateinit var menuimagebutton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_home -> replaceFragment(Home())
                R.id.navigation_profile -> replaceFragment(Profile())
                R.id.navigation_grocery -> replaceFragment(Grocery())
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
    fun onSignUpPress(view: View?){

        val i = Intent(this, LoginActivity::class.java)
        startActivity(i)
        finish()
    }
    fun manageProfileClick(view: View?)
    {

        val i = Intent(this, ManageProfileActivity::class.java)
        startActivity(i)
        finish()
    }
    fun onAddButtonClick(v: View) {
        AddNewTask.newInstance()
            .show(supportFragmentManager, "ActionBottomDialog")
    }
    fun onMenuClick(view:View)
    {
        // Referencing and Initializing the button
        menuimagebutton = findViewById(R.id.menu)

        // Setting onClick behavior to the button
        menuimagebutton.setOnClickListener {
            // Initializing the popup menu and giving the reference as current context
            val popupMenu = PopupMenu(this@MainActivity, menuimagebutton)

            // Inflating popup menu from popup_menu.xml file
            popupMenu.menuInflater.inflate(R.menu.dropdown_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { menuItem ->
                // Toast message on menu item clicked
                Toast.makeText(
                    this@MainActivity,
                    "You Clicked " + menuItem.title,
                    Toast.LENGTH_SHORT
                ).show()
                true
            }
            // Showing the popup menu
            popupMenu.show()
        }
    }

}
