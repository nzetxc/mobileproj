package com.example.protein

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class RegActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)

        val userLogin: EditText = findViewById(R.id.user_login)
        val userEmail: EditText = findViewById(R.id.user_email)
        val userFirstname: EditText = findViewById(R.id.user_firstname)
        val userLastname: EditText = findViewById(R.id.user_lastname)
        val userPass: EditText = findViewById(R.id.user_pass)
        val userRepeat: EditText = findViewById(R.id.user_repeat)
        val button: Button = findViewById(R.id.button_reg)
        val linkToAuth: TextView = findViewById(R.id.link_to_auth)

        val sharedPreferences = getSharedPreferences("User", Context.MODE_PRIVATE)

        linkToAuth.setOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener{
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val firstname = userFirstname.text.toString().trim()
            val lastname = userLastname.text.toString().trim()
            val pass = userPass.text.toString().trim()
            val repeat = userRepeat.text.toString().trim()

            fun saveUser(user: User) {
                val editor = sharedPreferences.edit()
                editor.putString("LOGIN", user.login)
                editor.putString("EMAIL", user.email)
                editor.putString("NAME", user.firstname)
                editor.putString("LASTNAME", user.lastname)
                editor.putString("PASS", user.pass)

                editor.apply()
            }

            val pattern = "[A-Za-z]+".toRegex()
            if(login == "" || email == "" || firstname == "" || lastname == "" || pass == "" || repeat == "")
                Toast.makeText(this, "Not all fields are filled", Toast.LENGTH_LONG).show()
            else if (!email.contains("@", true))
                Toast.makeText(this, "Email must contain '@' character", Toast.LENGTH_LONG).show()
            else if (!firstname.matches(pattern) || !lastname.matches(pattern))
                Toast.makeText(this, "First and last name can only contain letters [A-Z]", Toast.LENGTH_LONG).show()
            else if (pass.length <= 7)
                Toast.makeText(this, "Password must be at least 8 characters long", Toast.LENGTH_LONG).show()
            else if(pass == repeat){
                val user = User(login, email, firstname, lastname, pass, repeat)

                saveUser(user)

//                val db = DbHelper(this, null)
//                db.addUser(user)
                Toast.makeText(this, "User $login successfully registered", Toast.LENGTH_LONG).show()

                userLogin.text.clear()
                userEmail.text.clear()
                userFirstname.text.clear()
                userLastname.text.clear()
                userPass.text.clear()
                userRepeat.text.clear()
            }
            else{
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_LONG).show()
            }
        }
    }
}