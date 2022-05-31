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
class Sorting(
    private val activity: AppCompatActivity,
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

    fun sort(drawView: DrawView){
        when (type){
            "selection" -> selectionSort(drawView)
            "bubble" -> bubbleSort()
            "merge" -> mergeSort()
            "quick" -> quickSort()
            else -> {
                println("error, no sort selected")
            }
        }

    }

    private fun selectionSort(drawView: DrawView){
        var size: Int = numberElements

        for(i in 0 until size-1){
            var minIndex = i
            for(j in i+1 until size){
                if(elements[j].value < elements[minIndex].value){
                    minIndex = j
                }
            }
            var temp: Element = elements[i]
            elements[i] = elements[minIndex]
            elements[minIndex] = temp

            drawView.updateElements(elements)

        }

        for(i in 0 until numberElements){
            elements[i].index = i
        }
    }


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

    private fun bubbleSort(){

    }

    private fun mergeSort(){

    }

    private fun quickSort(){

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