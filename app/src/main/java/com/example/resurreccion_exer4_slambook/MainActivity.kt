package com.example.resurreccion_exer4_slambook

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.resurreccion_exer4_slambook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /*
     * declare binding variable
     */
    private lateinit var binding: ActivityMainBinding

    /*
     * create a variable for the instance
     * of the data class Entry
     */
    private val entry: Entry = Entry()

    /*
     * override onCreate function
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*
         * create binding object
         */
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        /*
         * set the value of the entry variable
         * created in the layout file
         */
        binding.entry = entry

        /*
         * set onlick listener of done button
         */
        binding.doneButton.setOnClickListener {
            addEntry(it)
        }
    }

    /*
     * create onclick handler for done button
     * which displays the name, nickname and age
     * entered by the user
     */
    private fun addEntry(view : View){
        binding.apply{
            /*
             * update visibility of ui components
             */
            scrollView.visibility = View.GONE
            displayNameTextView.visibility = View.VISIBLE
            displayNicknameTextView.visibility = View.VISIBLE
            displayAgeTextView.visibility = View.VISIBLE
            thanksTextView.visibility = View.VISIBLE

            /*
             * update the name, nickname and age text views
             * with the details entered by the user
             */
            entry?.name = nameEditText.text.toString()
            entry?.nickname = nicknameEditText.text.toString()
            entry?.age = ageEditText.text.toString()

            /*
             * add invalidateAll() so that the UI is refreshed
             * with the value in the updated binding object
             */
            invalidateAll()
        }

        /*
         * hide the keyboard
         */
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
