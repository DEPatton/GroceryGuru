package com.example.groceryguru_derrick

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FireBaseTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fire_base_test)
    }

    val db = Firebase.firestore

    fun onTestButtonPress(view: View?){
        println("Hello, I was pressed.")

        Firebase_Base().writeToUserCollection()

    }
}