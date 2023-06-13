package com.example.groceryguru_derrick

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.groceryguru_derrick.databinding.ActivityMainBinding
import com.google.gson.Gson
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection
import java.lang.Thread as Thread

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())

        fetchRecipeData().start()

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_home -> replaceFragment(Home())
                R.id.navigation_profile -> replaceFragment(Profile())
                R.id.navigation_grocery -> replaceFragment(Grocery())
            }
            true
        }
    }

    fun onSignUpPress(view: View?){

        val i = Intent(this, LoginActivity::class.java)
        startActivity(i)
        finish()
    }
    fun manageProfileClick(view: View?)
    {

        val i = Intent(this, ManageProfileActivity::class.java)
        startActivity(i)
        finish()
    }

    fun manageAccountClick(view : View?) {

        val i = Intent(this, SettingsActivity::class.java)
        startActivity(i)
        finish()

    }

    // API Thread
    private fun fetchRecipeData(): Thread
    {
        return Thread {
        
            val url = URL("https://api.edamam.com/api/recipes/v2?type=any&app_id=4c31632c&app_key=8e5100d3f2a340331004a4dd3f87fdca")
            val connection = url.openConnection() as HttpsURLConnection

            if(connection.responseCode == 200)
            {

                val inputSystem = connection.inputStream
                val inputStreamReader = InputStreamReader(inputSystem, "UTF-8")
                val request = Gson().fromJson(inputStreamReader, Request::class.java)
                updateUI(request)
                inputStreamReader.close()
                inputSystem.close()
                println("Response Code 200")

            }
            else
            {

                println("Failed Connection")

            }
        }
    }

    private fun updateUI(request: Request)
    {
        runOnUiThread{
            kotlin.run{
                //Put elements that have to do with UI and the API in this method.
            }
        }
    }
    
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}
