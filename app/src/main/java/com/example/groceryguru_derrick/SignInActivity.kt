package com.example.groceryguru_derrick

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
    }

    fun onRegisterPress(view: View?){

        val i = Intent(this, RegisterActivity::class.java)
        startActivity(i)
        finish()
    }

    fun onSignMeUp(view: View?){

    }

    fun onBackPress1(view: View?) {

        val i = Intent(this, LoginActivity::class.java)
        startActivity(i)
        finish()

    }
}