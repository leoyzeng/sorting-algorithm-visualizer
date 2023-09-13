package com.example.sorting_algorithm_visualizer

import androidx.appcompat.app.AppCompatActivity

class BubbleSort(
    activity: AppCompatActivity,
    type: String,
    numberElements: Int
) : Sorting(activity, type, numberElements) {

    override fun sort() {
        val original = elements.copyOf()

        for (i in 0 until elements.size - 1) {
            for (j in 0 until elements.size - i - 1) {
                if (elements[j] > elements[j + 1]) {
                    val temp = elements[j]
                    elements[j] = elements[j + 1]
                    elements[j + 1] = temp

                    swaps.add(intArrayOf(j, j + 1))
                }
            }
        }
        elements = original
    }
}