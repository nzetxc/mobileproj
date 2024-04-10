package com.example.protein

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val userLogin: EditText = findViewById(R.id.user_login_auth)
        val userPass: EditText = findViewById(R.id.user_pass_auth)
        val button: Button = findViewById(R.id.button_auth)
        val linkToReg: TextView = findViewById(R.id.link_to_reg)

        val sharedPreferences = getSharedPreferences("User", Context.MODE_PRIVATE)

        fun getUserLog(): String {
            val login = sharedPreferences.getString("LOGIN", "")
            return login.toString()
        }
        fun getUserPass(): String {
            val pass = sharedPreferences.getString("PASS", "")
            return pass.toString()
        }

        val userlg:String = getUserLog()
        val userps:String = getUserPass()

        linkToReg.setOnClickListener {
            val intent = Intent(this, RegActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener{
            val login = userLogin.text.toString().trim()
            val pass = userPass.text.toString().trim()

            if (login == "" || pass == "")
                Toast.makeText(this, "Not all fields are filled", Toast.LENGTH_LONG).show()
            else if(login == userlg && pass == userps){
                Toast.makeText(this, "User $login successfully logged in", Toast.LENGTH_LONG).show()

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            else
                Toast.makeText(this, "Incorrect data", Toast.LENGTH_LONG).show()
//            val login = userLogin.text.toString().trim()
//            val pass = userPass.text.toString().trim()
//
//            if(login == "" || pass == "")
//                Toast.makeText(this, "Not all fields are filled", Toast.LENGTH_LONG).show()
//            else{
//                val db = DbHelper(this, null)
//                val isAuth = db.getUser(login, pass)
//
//                if(isAuth) {
//                    Toast.makeText(this, "User $login successfully logged in", Toast.LENGTH_LONG).show()
//                    userLogin.text.clear()
//                    userPass.text.clear()
//
//                    val intent = Intent(this, MainActivity::class.java)
//                    startActivity(intent)
//                } else
//                    Toast.makeText(this, "Incorrect data", Toast.LENGTH_LONG).show()
//
//            }
        }
    }
}