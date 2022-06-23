package com.optimahorizonapps.bmicalculatorapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

//    lateinit var sharedPreferences: SharedPreferences
//    lateinit var editor: SharedPreferences.Editor
    var bmiTwoDigits = 0.0f


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weightInputEt = findViewById<EditText>(R.id.inputWeight_editText)
        val heightInputEt = findViewById<EditText>(R.id.inputHeight_editText)
        val calculateBMIBtn = findViewById<Button>(R.id.calculateBMI_button)

        calculateBMIBtn.setOnClickListener {
            val weight = weightInputEt.text.toString()
            val height = heightInputEt.text.toString()

            val bmi = weight.toFloat() / ((height.toFloat() / 100) * (height.toFloat() / 100))

            // get result with 2 decimal places
            bmiTwoDigits = String.format("%.2f", bmi).toFloat()
//            saveResult()

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("bmi", bmiTwoDigits)
            startActivity(intent)
        }
    }

//    private fun saveResult() {
//        editor.apply {
//            putFloat("bmi", bmiTwoDigits)
//            commit()
//        }
//    }
}