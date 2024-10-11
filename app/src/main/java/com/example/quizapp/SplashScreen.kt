package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val auth = FirebaseAuth.getInstance()
        if (auth.currentUser != null){
            Toast.makeText(this, "User already logged in!", Toast.LENGTH_SHORT).show()
            redirection("Main")
        }

        val getStartedButton = findViewById<Button>(R.id.get_started_button)
        getStartedButton.setOnClickListener {
            redirection("Login")
        }
    }

    private fun redirection(name:String){
        val intent = when(name){
            "Login"->Intent(this,LoginScreen::class.java)
            "Main"->Intent(this,MainActivity::class.java)
            else->throw Exception("path does not exist")
        }
        startActivity(intent)
        finish()
    }
}