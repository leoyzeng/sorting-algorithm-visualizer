package com.example.sorting_algorithm_visualizer

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import android.widget.ImageView
import android.widget.Toast
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
    private val activity: AppCompatActivity,
    private var type: String, // type of sorting eg. selection, bubble, merge
    private var numberElements: Int // number of elements in array
    ){

    private val elements = Array(numberElements) {Element(null, null)} // array of elements to sort

    val bitmap: Bitmap = Bitmap.createBitmap(700, 1000, Bitmap.Config.ARGB_8888)
    val canvas: Canvas = Canvas(bitmap)

    init{
        for(i in 0 until numberElements){
            val element = Element(i, i)
            elements[i] = element

        }
    }

    fun test(){
        println("test fun")
        println(type)
        println(numberElements)
        //activity.setContentView(R.layout.activity_algorithm)
        var shapeDrawable: ShapeDrawable
        shapeDrawable = ShapeDrawable(RectShape())
        shapeDrawable.setBounds( 100, 100, 600, 400)
        shapeDrawable.getPaint().setColor(Color.parseColor("#009944"))
        shapeDrawable.draw(canvas)
        var imageView = ImageView(activity)
        imageView.background = BitmapDrawable(activity.getResources(), bitmap)
        println("finished test")
    }

    fun print(){

        for (element in elements) {
            println(element.value)
            println("here")
        }
    }
}