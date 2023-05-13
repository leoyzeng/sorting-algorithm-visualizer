package com.example.sorting_algorithm_visualizer

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlin.concurrent.thread
import kotlin.math.min

/**
 * class for sorting the elements
 * contains an array of elements
 * note to self
 * can have multiple sorting classes
 * 1 sorting class per type
 * those sorting classes extends this sorting
 * this class has abstract methods
 */
abstract class Sorting(
    private val activity: AppCompatActivity,
    private var type: String, // type of sorting eg. selection, bubble, merge
    private var numberElements: Int // number of elements in array
    ){

    var elements = IntArray(0) // array of elements to sort
    val swaps = mutableListOf<IntArray>()

    /**
     * set up array
     */
    init{
        createArray()
        randomize()
        print()
    }

    /**
     * create a ordered array of integers from 1 to n
     */
    private fun createArray(){
        elements = IntArray(numberElements);

        for(i in 0 until numberElements){
            elements[i] = i+1

        }
    }

    /**
     * randomize elements array
     */
    private fun randomize(){
        elements.shuffle()
    }

    abstract fun sort(drawView: DrawView)


    /******
     *
     *
     *
     *
     *
     *
     *  NOTE TO SELF
     *  STORE THE STEPS TO SORTING IN AN ARRAY
     *  PROBABLY THE BEST WAY TO ANIMATE
     *  2D ARRAY WITH 2 ELEMENTS REPRESENTING THE INDEX OF 2 SWAPPED ELEMENTS
     *  {{i1, j1}, {i2, j2}}
     *
     *
     *
     *
     */




    /**
     * print out index and value of elements
     * used for debugging
     */
    private fun print(){
        for(i in elements.indices){
            println("index:" + i + " value: " + elements[i])
        }
    }


}