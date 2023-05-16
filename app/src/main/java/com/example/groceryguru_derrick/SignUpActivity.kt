package com.example.groceryguru_derrick

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.set

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        var firstName: EditText? = findViewById(R.id.nameFirst1)
        var lastName: EditText? = findViewById(R.id.nameLast1)
        var userName: EditText? = findViewById(R.id.Username1)
        var emailAdd: EditText? = findViewById(R.id.EmailEntry1)
        var passWord: EditText? = findViewById(R.id.Password1)
        var rePassWord: EditText? = findViewById(R.id.ReentPass1)

        firstName?.setOnFocusChangeListener { _: View, hasFocus: Boolean ->
            if (hasFocus && firstName.text.contentEquals("First Name"))
            {
                firstName?.text?.clear()
            }
            else if (!hasFocus && firstName.text.isBlank()) {
                // If the edit text loses focus, write its text to a text element
                firstName.text.insert(0, "First Name")
            }
        }

        lastName?.setOnFocusChangeListener { _: View, hasFocus: Boolean ->
            if (hasFocus && lastName.text.contentEquals("Last Name"))
            {
                lastName?.text?.clear()
            }
            else if (!hasFocus && lastName.text.isBlank()) {
                // If the edit text loses focus, write its text to a text element
                lastName.text.insert(0, "Last Name")

            }
        }

        userName?.setOnFocusChangeListener { _: View, hasFocus: Boolean ->
            if (hasFocus && userName.text.contentEquals("Username"))
            {
                userName?.text?.clear()
            }
            else if (!hasFocus && userName.text.isBlank()) {
                // If the edit text loses focus, write its text to a text element
                userName.text.insert(0, "Username")

            }
        }

        emailAdd?.setOnFocusChangeListener { _: View, hasFocus: Boolean ->
            if (hasFocus && emailAdd.text.contentEquals("Email"))
            {
                emailAdd?.text?.clear()
            }
            else if (!hasFocus && emailAdd.text.isBlank()) {
                // If the edit text loses focus, write its text to a text element
                emailAdd.text.insert(0, "Email")

            }
        }

        passWord?.setOnFocusChangeListener { _: View, hasFocus: Boolean ->
            if (hasFocus && passWord.text.contentEquals("Password"))
            {
                passWord?.text?.clear()
            }
            else if (!hasFocus && passWord.text.isBlank()) {
                // If the edit text loses focus, write its text to a text element
                passWord.text.insert(0, "Password")

            }
        }

        rePassWord?.setOnFocusChangeListener { _: View, hasFocus: Boolean ->
            if (hasFocus && rePassWord.text.contentEquals("Re-enter Password"))
            {
                rePassWord?.text?.clear()
            }
            else if (!hasFocus && rePassWord.text.isBlank()) {
                // If the edit text loses focus, write its text to a text element
                rePassWord.text.insert(0, "Re-enter Password")

            }
        }
    }

    fun onSignMeUp(view: View?){

        val newUser = hashMapOf(
            "firstName" to firstName,
            "lastName" to "nullLN",
            "email" to "nullEM",
            "username" to "nullUN",
            "password" to "nullPW",
        )

    }

    fun onBackPress1(view: View?){

        val i = Intent(this, HomeActivity::class.java)
        startActivity(i)
        finish()
    }
}