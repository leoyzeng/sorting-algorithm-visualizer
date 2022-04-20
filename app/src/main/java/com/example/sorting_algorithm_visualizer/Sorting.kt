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

    private val elements = Array(numberElements) {Element(null, null)} // array of elements to sort


    init{

        for(i in 0 until numberElements){
            val element = Element(i, i)
            elements[i] = element

        }
    }


    fun print(){

        for (element in elements) {
            println(element.value)
            println("here")
        }
    }
}