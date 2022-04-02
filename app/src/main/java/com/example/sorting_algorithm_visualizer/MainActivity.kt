package com.example.sorting_algorithm_visualizer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        attachListener()



    }

    /**
     * attach all listeners on main activity
     */
    private fun attachListener() {
        val buttonStart:Button = findViewById(R.id.buttonStart) // start button
        buttonStart.setOnClickListener { // on click
            val intent = Intent(this, AlgorithmActivity::class.java)
            startActivity(intent) // open algorithm activity
        }
    }
}