package com.example.groceryguru_derrick

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Firebase_Base {

    private val db = Firebase.firestore
    public val user = hashMapOf(
        "firstName" to "nullFN",
        "lastName" to "nullLN",
        "email" to "nullEM",
        "username" to "nullUN",
        "password" to "nullPW",
    )

    fun writeToUserCollection(){

        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }
    }

    fun readFromUserCollection(){

        db.collection("users")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
    }
}