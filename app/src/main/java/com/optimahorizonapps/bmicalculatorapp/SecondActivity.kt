package com.optimahorizonapps.bmicalculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat

class SecondActivity : AppCompatActivity() {

    lateinit var indexDisplayTv: TextView
    lateinit var resultDisplayTv: TextView
    lateinit var infoDisplayTv: TextView
    var bmi = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        indexDisplayTv = findViewById<TextView>(R.id.index_textView)
        resultDisplayTv = findViewById<TextView>(R.id.result_textView)
        infoDisplayTv = findViewById<TextView>(R.id.info_textView)

        bmi = intent.getFloatExtra("bmi", 0.0f)

        displayResult()
    }

    private fun displayResult() {
        var resultText = ""
        var infoText = ""
        var infoColor = 0
        indexDisplayTv.text = bmi.toString()

        when {
            bmi < 18.5 -> {
                resultText = getString(R.string.underweight)
                infoColor = R.color.underweight
                infoText = getString(R.string.underweightBMI_info)
            }
            bmi in 18.50..24.99 -> {
                resultText = getString(R.string.normal)
                infoColor = R.color.normal
                infoText = getString(R.string.normalBMI_info)
            }
            bmi in 25.00..29.99 -> {
                resultText = getString(R.string.overweight)
                infoColor = R.color.overweight
                infoText = getString(R.string.overweightBMI_info)
            }
            bmi > 29.99 -> {
                resultText = getString(R.string.obese)
                infoColor = R.color.obese
                infoText = getString(R.string.obeseBMI_info)
            }
        }
        resultDisplayTv.setTextColor(ContextCompat.getColor(this, infoColor))
        resultDisplayTv.text = resultText
        infoDisplayTv.text = infoText
    }
}