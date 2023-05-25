package com.example.groceryguru_derrick

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen_layout)
    }

    fun onSignInPress(view: View?){

        val i = Intent(this, SignInActivity::class.java)
        startActivity(i)
        finish()

    }

    fun onBackPress(view: View?){

        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
        finish()

    }
}