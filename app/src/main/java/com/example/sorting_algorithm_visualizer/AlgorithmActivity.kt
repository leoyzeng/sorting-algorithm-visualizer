package com.example.sorting_algorithm_visualizer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AlgorithmActivity : AppCompatActivity() {

    private val sorting = Sorting(10)
    private val container = Container(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_algorithm)


        sorting.print()
        container.attachListener()


    }
}