package com.example.sorting_algorithm_visualizer

import android.widget.Toast

class Sorting(numberElements: Int ){


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