package com.example.resurreccion_exer4_slambook

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var doneButton: Button
    private lateinit var scrollView: View
    private lateinit var displayNameView: TextView
    private lateinit var displayNicknameView: TextView
    private lateinit var displayAgeView: TextView
    private lateinit var editNameView: EditText
    private lateinit var editNicknameView: EditText
    private lateinit var editAgeView: EditText
    private lateinit var displayThanksView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doneButton = findViewById(R.id.done_button)
        scrollView = findViewById(R.id.scrollView)
        displayNameView = findViewById(R.id.displayName_textView)
        displayNicknameView = findViewById(R.id.displayNickname_textView)
        displayAgeView = findViewById(R.id.displayAge_textView)
        displayThanksView = findViewById(R.id.thanks_textView)
        editNameView = findViewById(R.id.name_editText)
        editNicknameView = findViewById(R.id.nickname_editText)
        editAgeView = findViewById(R.id.age_editText)

        doneButton.setOnClickListener {
            addEntry(it)
        }
    }

    private fun addEntry(view : View){
        scrollView.visibility = View.GONE

        displayNameView.text = editNameView.text
        displayNicknameView.text = editNicknameView.text
        displayAgeView.text = editAgeView.text

        displayNameView.visibility = View.VISIBLE
        displayNicknameView.visibility = View.VISIBLE
        displayAgeView.visibility = View.VISIBLE
        displayThanksView.visibility = View.VISIBLE

        // Hide keyboard
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
