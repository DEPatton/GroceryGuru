package com.example.groceryguru_derrick

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SettingsActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    lateinit var backPressButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_settings)
        backPressButton = findViewById(R.id.BackPress)
    }


    var clickedAmt = 0

    fun deleteAccount(view: View?){

        if (clickedAmt == 0)
        {

            Toast.makeText(this, "Press Delete Account again to confirm deletion", Toast.LENGTH_SHORT).show()
            clickedAmt = 1

        }
        else
        {

            if (auth.currentUser != null)
            {

                auth.currentUser?.delete()

                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
                finish()

            }
            else
            {

                Toast.makeText(this, "Please login before trying to delete...", Toast.LENGTH_SHORT).show()

            }
        }
    }
    fun backPress(view : View?) {
        finish()
    }
}