package com.example.protein

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1: Button = findViewById(R.id.button_exit)
        val button2: Button = findViewById(R.id.button_profile)
        val button3: Button = findViewById(R.id.button_prods)
        val button4: Button = findViewById(R.id.button_edit)

        button1.setOnClickListener{
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }
        button2.setOnClickListener{
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
        button3.setOnClickListener{
            val intent = Intent(this, ItemsActivity::class.java)
            startActivity(intent)
        }
        button4.setOnClickListener{
            Toast.makeText(this, "Work in progress <3", Toast.LENGTH_LONG).show()
        }
    }
}