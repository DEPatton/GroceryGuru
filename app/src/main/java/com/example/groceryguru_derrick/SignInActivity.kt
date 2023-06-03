package com.example.groceryguru_derrick

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.groceryguru_derrick.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SignInActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySignInBinding
    private lateinit var auth:FirebaseAuth
    private val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        binding.SignUp.setOnClickListener {
            val email = binding.UsernameMain2.text.toString()
            val pass = binding.PasswordMain2.text.toString()
            if (email.isNotBlank() && pass.isNotEmpty()) {
                auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener() {

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)

                }
            } else {

                Toast.makeText(
                    this,
                    "Empty fields are not allowed",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }
    }
    fun onRegisterPress(view: View?){

        val i = Intent(this, RegisterActivity::class.java)
        startActivity(i)
        finish()
    }

    fun onBackPress1(view: View?) {

        val i = Intent(this, LoginActivity::class.java)
        startActivity(i)
        finish()
    }

    private fun readFromUserCollection(collectionName: String){

        db.collection(collectionName)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(ContentValues.TAG, "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w(ContentValues.TAG, "Error getting documents.", exception)
            }
    }
}