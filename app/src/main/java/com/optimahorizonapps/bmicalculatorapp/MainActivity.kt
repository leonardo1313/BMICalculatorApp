package com.optimahorizonapps.bmicalculatorapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

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

            if(validateInput(weight, height)) {

                val bmi = weight.toFloat() / ((height.toFloat() / 100) * (height.toFloat() / 100))

                // get result with 2 decimal places
                bmiTwoDigits = String.format("%.2f", bmi).toFloat()

                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("bmi", bmiTwoDigits)
                startActivity(intent)

//                weightInputEt.setText("")
//                heightInputEt.setText("")
            }
        }
    }
    private fun validateInput(weight: String?, height: String?): Boolean {
        return when {
            weight.isNullOrEmpty() -> {
                Toast.makeText(this, "Please enter weight", Toast.LENGTH_SHORT).show()
                false
            }
            height.isNullOrEmpty() -> {
                Toast.makeText(this, "Please enter height", Toast.LENGTH_SHORT).show()
                false
            }
            else -> {
                true
            }
        }
    }

}