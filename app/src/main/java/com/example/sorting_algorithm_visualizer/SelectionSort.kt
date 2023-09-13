package com.example.sorting_algorithm_visualizer

import androidx.appcompat.app.AppCompatActivity

class SelectionSort(
    private val activity: AppCompatActivity,
    private var type: String, // type of sorting eg. selection, bubble, merge
    private var numberElements: Int // number of elements in array
) : Sorting(activity, type, numberElements){

    override fun sort() {

        var original = elements.copyOf()

        for (i in 0 until elements.size - 1) {
            var minIndex = i

            for (j in i + 1 until elements.size) {
                if (elements[j] < elements[minIndex]) {
                    minIndex = j
                }
            }

            if (minIndex != i) {
                val temp = elements[i]
                elements[i] = elements[minIndex]
                elements[minIndex] = temp

                swaps.add(intArrayOf(i, minIndex))
            }
        }
        elements = original;
    }


}