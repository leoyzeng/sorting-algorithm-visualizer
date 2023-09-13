package com.example.sorting_algorithm_visualizer

import androidx.appcompat.app.AppCompatActivity

class InsertionSort(
    activity: AppCompatActivity,
    type: String,
    numberElements: Int
) : Sorting(activity, type, numberElements) {

    override fun sort() {
        val original = elements.copyOf()

        for (i in 1 until elements.size) {
            val key = elements[i]
            var j = i - 1

            while (j >= 0 && elements[j] > key) {
                elements[j + 1] = elements[j]
                swaps.add(intArrayOf(j, j + 1))
                j--
            }

            elements[j + 1] = key
        }

        elements = original
    }
}





