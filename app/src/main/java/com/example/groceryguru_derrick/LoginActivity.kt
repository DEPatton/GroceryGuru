package com.example.groceryguru_derrick

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.groceryguru_derrick.databinding.ActivityMainBinding
import com.example.groceryguru_derrick.databinding.ActivitySignInBinding

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen_layout)
    }

    //Transition to Sign In screen.
    fun onSignIn(view : View?){

        val i = Intent(this, SignInActivity::class.java)
        startActivity(i)
        finish()
    }

    //Back button.
    fun onBackPress(view: View?){

        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
        finish()
    }
}