package com.example.sorting_algorithm_visualizer

import androidx.appcompat.app.AppCompatActivity

class QuickSort(
    activity: AppCompatActivity,
    type: String,
    numberElements: Int
) : Sorting(activity, type, numberElements) {

    override fun sort() {
        val original = elements.copyOf()
        quickSort(0, elements.size - 1)
        elements = original
    }

    private fun quickSort(low: Int, high: Int) {
        if (low < high) {
            val pivotIndex = partition(low, high)
            quickSort(low, pivotIndex - 1)
            quickSort(pivotIndex + 1, high)
        }
    }

    private fun partition(low: Int, high: Int): Int {
        val pivot = elements[high]
        var i = low - 1

        for (j in low until high) {
            if (elements[j] < pivot) {
                i++
                val temp = elements[i]
                elements[i] = elements[j]
                elements[j] = temp
                swaps.add(intArrayOf(i, j))
            }
        }

        val temp = elements[i + 1]
        elements[i + 1] = elements[high]
        elements[high] = temp
        swaps.add(intArrayOf(i + 1, high))

        return i + 1
    }
}