package com.example.quizapp.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R
import com.example.quizapp.adapters.quiz_adapter
import com.example.quizapp.models.quiz

class MainActivity : AppCompatActivity() {
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var adapter: quiz_adapter
    private var quiz_list = mutableListOf<quiz>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        dummydata()
        setupviews()
    }

    private fun dummydata() {
        quiz_list.add(quiz("10","10"))
        quiz_list.add(quiz("11","11"))
        quiz_list.add(quiz("12","12"))
        quiz_list.add(quiz("13","13"))
    }

    fun setupviews(){
        setupdrawer()
        setuprecyclerview()
    }

    private fun setuprecyclerview() {
        adapter = quiz_adapter(this,quiz_list)
        findViewById<RecyclerView>(R.id.apprecycler).layoutManager = GridLayoutManager(this,2)
        findViewById<RecyclerView>(R.id.apprecycler).adapter = adapter
    }

    fun setupdrawer(){
        setSupportActionBar(findViewById(R.id.appbar))
        actionBarDrawerToggle = ActionBarDrawerToggle(this, findViewById(R.id.main),
            R.string.app_name,
            R.string.app_name
        )
        actionBarDrawerToggle.syncState()
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}