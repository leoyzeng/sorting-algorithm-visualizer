package com.example.sorting_algorithm_visualizer

import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.sorting_algorithm_visualizer.DrawView

/**
 * container class to hold all elements
 * contains buttons, slider, canvas
 * contains object for sort
 * will create or start Sorting object on click start
 */
class Container(private val activity: AppCompatActivity) {

    private var sortType: String = "" // type of sorting eg. selection, bubble, merge
    private var size: Int = 3 // size of sorting.elements array
    private val minSizeRange: Int = 3 // min and max size of array
    private val maxSizeRange: Int = 20
    private lateinit var sorting: Sorting // object to do the sorting logic
    private lateinit var draw : DrawView // object to draw graphics

    /**
     * init UI after view is loaded
     * this should be called from onCreate of the activity
     */
    fun initUI(){
        draw = activity.findViewById(R.id.drawView)
        initSeekBar()
    }

    /**
     * update size based on seek bar
     * update text of seek bar
     */
    private fun initSeekBar(){
        val numElement: TextView = this.activity.findViewById(R.id.num_elements) // number of elements
        val seekBar: SeekBar = this.activity.findViewById(R.id.seekBar) // seekbar to change number of elements
        size = ((maxSizeRange-minSizeRange) * seekBar.progress / 100) + minSizeRange // set size
        numElement.text = size.toString()
    }


    /**
     * create sorting object and uses sorting object
     * this should be called when user presses start
     */
    private fun initSorting(){
        sorting = Sorting(activity, sortType, size)
        draw.updateElements(sorting.elements)
    }

    /**
     * reset sorting object and the graphics
     */
    private fun resetSorting(){
        initSorting()
    }

    /**
     * attach listeners for everything in container
     * sort buttons, seekbar, start/reset button
     */
    fun attachListener(){

        println(this.activity.findViewById(R.id.button_selection))
        println(activity.findViewById(R.id.button_selection))

        val buttonSelection: Button = this.activity.findViewById(R.id.button_selection) // selection button
        buttonSelection.setOnClickListener { // on click
            sortType = "selection"
        }
        val buttonBubble: Button = this.activity.findViewById(R.id.button_bubble) // selection button
        buttonBubble.setOnClickListener { // on click
            sortType = "bubble"
        }
        val buttonMerge: Button = this.activity.findViewById(R.id.button_merge) // selection button
        buttonMerge.setOnClickListener { // on click
            sortType = "merge"
        }
        val buttonQuick: Button = this.activity.findViewById(R.id.button_quick) // selection button
        buttonQuick.setOnClickListener { // on click
            sortType = "quick"
        }

        val buttonStart: Button = this.activity.findViewById(R.id.button_start) // start button
        buttonStart.setOnClickListener { // on click
            initSorting() // start sorting, create sorting object
        }
        val buttonReset: Button = this.activity.findViewById(R.id.button_reset) // reset button
        buttonReset.setOnClickListener { // on click
            resetSorting() // reset sorting, destructor for sorting object
        }

        val numElement: TextView = this.activity.findViewById(R.id.num_elements) // number of elements
        val seekBar: SeekBar = this.activity.findViewById(R.id.seekBar) // seekbar to change number of elements
        seekBar.setOnSeekBarChangeListener( object : SeekBar.OnSeekBarChangeListener{

            override fun onProgressChanged(seekbar: SeekBar, progress: Int, fromUser: Boolean) { // when user changes seekbar
                size = ((maxSizeRange-minSizeRange) * seekBar.progress / 100) + minSizeRange // set size
                numElement.text = size.toString()
            }
            override fun onStartTrackingTouch(seekbar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekbar: SeekBar?) {
            }

        })
    }
}