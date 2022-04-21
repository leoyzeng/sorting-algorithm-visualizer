package com.example.sorting_algorithm_visualizer

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import androidx.appcompat.app.AppCompatActivity

/**
 * class for sorting the elements
 * contains an array of elements
 * note to self
 * can have multiple sorting classes
 * 1 sorting class per type
 * those sorting classes extends this sorting
 * this class has abstract methods
 */
class Sorting(
    private val context: Context,
    private var type: String, // type of sorting eg. selection, bubble, merge
    private var numberElements: Int // number of elements in array
    ){

    var elements = emptyArray<Element>() // array of elements to sort

    /**
     * set up array
     */
    init{
        createArray()
        randomize()
        print()
    }

    /**
     * create a ordered array of numberElements
     * set index and value of element to index in array
     */
    private fun createArray(){
        elements = Array(numberElements){ Element(0,0) }

        for(i in 0 until numberElements){
            val element = Element(i, i)
            elements[i] = element

        }
    }

    /**
     * randomize elements array
     * update index number in element
     */
    private fun randomize(){
        elements.shuffle()
        for(i in 0 until numberElements){
            elements[i].index = i
        }
    }

    /**
     * print out index and value of elements
     * used for debugging
     */
    private fun print(){
        for(i in elements){
            println("index:" + i.index + " value: " + i.value)
        }
    }


}