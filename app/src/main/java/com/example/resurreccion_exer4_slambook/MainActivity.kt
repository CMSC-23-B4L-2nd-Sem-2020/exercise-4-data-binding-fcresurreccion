package com.example.resurreccion_exer4_slambook

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.resurreccion_exer4_slambook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val entry: Entry = Entry()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.entry = entry

        binding.doneButton.setOnClickListener {
            addEntry(it)
        }
    }

    private fun addEntry(view : View){
        binding.apply{
            scrollView.visibility = View.GONE

            displayNameTextView.visibility = View.VISIBLE
            displayNicknameTextView.visibility = View.VISIBLE
            displayAgeTextView.visibility = View.VISIBLE
            thanksTextView.visibility = View.VISIBLE

            entry?.name = nameEditText.text.toString()
            entry?.nickname = nicknameEditText.text.toString()
            entry?.age = ageEditText.text.toString()

            invalidateAll()
        }

        // Hide keyboard
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
