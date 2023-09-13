package com.example.sorting_algorithm_visualizer

import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

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
        if(sortType == "selection"){
            sorting = SelectionSort(activity, sortType, size)
        }
        else if(sortType == "bubble"){
            sorting = BubbleSort(activity, sortType, size)
        }
        else if(sortType == "insertion"){
            sorting = InsertionSort(activity, sortType, size)
        }
        else if(sortType == "quick"){
            sorting = QuickSort(activity, sortType, size)
        }
        sorting.sort()
        draw.updateElements(sorting.elements)
        println("starting sort");
        for (swap in sorting.swaps) {
            val i = swap[0]
            val j = swap[1]
            println("Swapped indices: [$i, $j]")
        }
    }

    /**
     * reset sorting object and the graphics
     * reset array
     */
    private fun resetSorting(){
        sorting.reset()
        draw.updateElements(sorting.elements)
    }

    /**
     * do the next step in the sorting
     */
    private fun nextStep(){
        sorting.next()
        draw.updateElements(sorting.elements)
    }

    /**
     * do the previous step in the sorting
     */
    private fun previousStep(){
        sorting.previous()
        draw.updateElements(sorting.elements)
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
        val buttonInsertion: Button = this.activity.findViewById(R.id.button_insertion) // selection button
        buttonInsertion.setOnClickListener { // on click
            sortType = "insertion"
        }
        val buttonQuick: Button = this.activity.findViewById(R.id.button_quick) // selection button
        buttonQuick.setOnClickListener { // on click
            sortType = "quick"
        }

        val buttonNew: Button = this.activity.findViewById(R.id.button_new) // start button
        buttonNew.setOnClickListener { // on click
            if(sortType != ""){
                initSorting() // create new array, create sorting object
            }
        }
        val buttonReset: Button = this.activity.findViewById(R.id.button_reset) // reset button
        buttonReset.setOnClickListener { // on click
            resetSorting() // reset sorting, destructor for sorting object
        }

        val buttonNext: Button = this.activity.findViewById(R.id.button_next) // next button
        buttonNext.setOnClickListener { // on click
            nextStep() //
        }
        val buttonPrevious: Button = this.activity.findViewById(R.id.button_previous) // previous button
        buttonPrevious.setOnClickListener { // on click
            previousStep() //
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