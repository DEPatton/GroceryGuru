package com.example.groceryguru_derrick

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FireBaseTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fire_base_test)
    }

    val user = hashMapOf(
        "first" to "Steven",
        "last" to "Alexander",
        "born" to 1992
    )

    val db = Firebase.firestore

    fun onTestButtonPress(view: View?){
        print("Hello, I was pressed.")

        db.collection("test")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "Document Added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }
    }
}