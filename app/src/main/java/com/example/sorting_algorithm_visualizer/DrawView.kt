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
    var elements: Array<Element> = Array(20){Element(null,null)}

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
        var left : Float = 0f
        var top : Float = 400f

        for(element in elements){
            canvas.drawRect(left, top, left + 10, 400f, paint)
            left += 20
            top -= 20
        }
    }

    public override fun onDraw(canvas: Canvas) {
        drawElements(canvas,elements)

    }


}