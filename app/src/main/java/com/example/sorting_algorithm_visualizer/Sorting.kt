package com.example.sorting_algorithm_visualizer

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import java.util.*
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
    var originalElements = IntArray(0)
    val swaps = mutableListOf<IntArray>()
    private var currentStep: Int = 0 // current step of the sort
    private var sorted: Boolean = false

    /**
     * set up array
     */
    init{
        createArray()
        randomize()
        saveOriginalArray()
        print()
    }

    /**
     * create a ordered array of integers from 1 to n
     */
    private fun createArray(){
        elements = IntArray(numberElements)

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

    private fun saveOriginalArray(){
        originalElements = elements.copyOf()
    }

    abstract fun sort()

    /**
     * do the next step in the swap based on the predetermined order
     */
    fun next(){
        if(sorted){ // already sorted, nothing else to do
            return
        }
        if(currentStep == swaps.size){ // at the end
            return
        }
        val swap:IntArray = swaps[currentStep] // the current step of the sorting process
        val temp:Int = elements[swap[0]]// swap the 2 elements
        elements[swap[0]] = elements[swap[1]]
        elements[swap[1]] = temp
        currentStep ++

        if(currentStep == swaps.size){ // check if it reached the end of the swaps array
            sorted = true
        }
    }

    /**
     * do the previous step in the sort
     */
    fun previous(){
        if(currentStep == 0){ // if sorting hasn't started yet, don't have previous step
            return
        }
        if(currentStep == swaps.size){ // if already sorted, mark it as no longer sorted
            sorted = false
        }
        val swap:IntArray = swaps[currentStep-1] // the current step of the sorting process
        val temp:Int = elements[swap[0]]// swap the 2 elements
        elements[swap[0]] = elements[swap[1]]
        elements[swap[1]] = temp
        currentStep --
    }

    /**
     * reset array to original state
     */
    fun reset(){

        println("reset")
        println(Arrays.toString(elements))
        println(Arrays.toString(originalElements))

        elements = originalElements.copyOf()
        currentStep = 0
        sorted = false
    }




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