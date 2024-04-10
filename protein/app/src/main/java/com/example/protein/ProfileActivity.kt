package com.example.protein

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val linkToMain: TextView = findViewById(R.id.link_to_main)
        linkToMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val sharedPreferences = getSharedPreferences("User", Context.MODE_PRIVATE)

        val login: TextView = findViewById(R.id.textLogin)
        val email: TextView = findViewById(R.id.textEmail)
        val firstname: TextView = findViewById(R.id.textName)
        val lastname: TextView = findViewById(R.id.textLast)

        login.text = "Login: " + sharedPreferences.getString("LOGIN", "")
        email.text = "Email: " + sharedPreferences.getString("EMAIL", "")
        firstname.text = "First name: " + sharedPreferences.getString("NAME", "")
        lastname.text = "Last name: " + sharedPreferences.getString("LASTNAME", "")
    }
}