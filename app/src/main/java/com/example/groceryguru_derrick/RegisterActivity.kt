package com.example.groceryguru_derrick

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.groceryguru_derrick.databinding.ActivityRegisterBinding
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding:ActivityRegisterBinding
    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.regButton.setOnClickListener {
            val username = binding.UsernameMain1.text.toString().trim() //Entered Username Variable
            val email = binding.EmailMain1.text.toString().trim() //Entered Email Variable
            val pass = binding.PasswordMain1.text.toString().trim() // Entered Email Variable

            if (username.isNotBlank() && email.isNotBlank() && pass.isNotBlank()) {

                this.auth.createUserWithEmailAndPassword(email, pass)
                    .addOnCompleteListener { task: Task<AuthResult> ->
                        if (task.isSuccessful)
                        {
                            //Registration Okay!

                            val intent = Intent(this, SignInActivity::class.java)
                            startActivity(intent)

                            sendVerifiedEmail()

                        }
                        else //Registration Failed
                        {

                            Toast.makeText(this, "Failed to create account", Toast.LENGTH_SHORT)
                                .show()

                        }
                    }
            } else //Empty field on form
            {

                Toast.makeText(this, "Empty fields are not allowed", Toast.LENGTH_SHORT).show()

            }
        }
    }

    private fun sendVerifiedEmail() {

        val user = auth.currentUser

        user?.sendEmailVerification()
            ?.addOnSuccessListener {

                Toast.makeText(
                    this,
                    "Email Verification Required. Please Check Email.",
                    Toast.LENGTH_LONG
                ).show()

            }
            ?.addOnFailureListener {

                println("Unable to send email.")

            }
    }

    fun onBackClick1(view : View?) {

        val i = Intent(this, SignInActivity::class.java)
        startActivity(i)
        finish()
    }
}