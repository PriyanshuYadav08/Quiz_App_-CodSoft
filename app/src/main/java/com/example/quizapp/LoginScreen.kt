package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class LoginScreen : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText

    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_screen)

        emailEditText = findViewById(R.id.email_enter_login)
        passwordEditText = findViewById(R.id.password_enter_login)

        firebaseAuth = FirebaseAuth.getInstance()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val loginButton = findViewById<Button>(R.id.login_button_login)
        loginButton.setOnClickListener {
            login()
        }

        val signUpButton = findViewById<Button>(R.id.back_to_signup)
        signUpButton.setOnClickListener {
            val intent = Intent(this, SignUpScreen::class.java)
            startActivity(intent)
        }
    }

    private fun login() {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        if (email.isBlank() || password.isBlank()){
            Toast.makeText(this, "Email and Password can not be blank", Toast.LENGTH_SHORT).show()
            return
        }

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "User does not exist", Toast.LENGTH_SHORT).show()
            }
        }
    }
}