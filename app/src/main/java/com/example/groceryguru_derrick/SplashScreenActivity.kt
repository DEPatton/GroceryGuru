package com.example.groceryguru_derrick

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val ivFood: ImageView? = findViewById(R.id.ivFood)

        ivFood?.alpha = 0f
        ivFood?.animate()?.setDuration(2000)?.alpha(1f)?.withEndAction {
            val i = Intent(this, MainActivity::class.java)  // change this line
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}
