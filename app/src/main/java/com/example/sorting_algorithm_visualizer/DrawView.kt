package com.example.sorting_algorithm_visualizer

import android.content.Context
import android.graphics.Camera
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity

/**
 * class to draw and update elements
 * call on updateElements with array to update graphics
 */
class DrawView(
    context: Context?,
    attributeSet: AttributeSet
) : View(context, attributeSet){

    var paint = Paint()
    var number: Int? = null
    var elements = arrayOf<Element>() // array of elements to sort


    /**
     * called on from container
     *
     */
    fun updateElements(elements: Array<Element>){
        this.elements = elements
        invalidate()
    }

    /**
     * draw elements based on array
     */
    private fun drawElements(canvas: Canvas, elements: Array<Element>){

        paint.color = Color.BLACK
        paint.strokeWidth = 3f
        var totalHeight : Float = 800f
        var totalWidth : Float = 800f

        println(elements.size)


        for(element in elements){

            println(element.index)
            println(element.value)

            var left = totalWidth / elements.size * element.index
            var right = left + 20f
            var top = totalHeight - (totalHeight / elements.size * element.value)
            var bottom = totalHeight

            canvas.drawRect(left, top, right, bottom, paint)

        }
    }

    public override fun onDraw(canvas: Canvas) {
        drawElements(canvas,elements)

    }


}