package com.optimahorizonapps.bmicalculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    lateinit var indexDisplay_tv: TextView
    lateinit var resultDisplay_tv: TextView
    lateinit var infoDisplay_tv: TextView
    var bmi = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        indexDisplay_tv = findViewById<TextView>(R.id.index_textView)
        resultDisplay_tv = findViewById<TextView>(R.id.result_textView)
        infoDisplay_tv = findViewById<TextView>(R.id.info_textView)

        bmi = intent.getFloatExtra("bmi", 0.0f)

        displayResult()
    }

    private fun displayResult() {
        indexDisplay_tv.text = bmi.toString()
        resultDisplay_tv.text = getString(R.string.normal)
        infoDisplay_tv.text = getString(R.string.normalBMI_info)
    }
}