package com.example.groceryguru_derrick

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ManageProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_profile)
    }

    fun mapPressed(view: View?)
    {

        val i = Intent(this, StoreLocatorActivity::class.java)
        startActivity(i)
        finish()

    }
}