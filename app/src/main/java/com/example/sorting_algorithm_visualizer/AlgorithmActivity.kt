package com.example.sorting_algorithm_visualizer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_algorithm.*

/**
 * activity for algorithms
 * contains a container object which deals with inputs and sorting
 */
class AlgorithmActivity : AppCompatActivity() {

    private val container = Container(this) // container deals with inputs and contains sorting object

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_algorithm)
        container.attachListener()
    }
}