package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val name = intent?.extras?.getString("userName").toString()
        findViewById<TextView>(R.id.name).text = name

        if(savedInstanceState!= null) {
            val res = findViewById<TextView>(R.id.res).setText(savedInstanceState.getString("res"))
        }

        val btn = findViewById<TextView>(R.id.button2)
        btn.setOnClickListener {
            val w = findViewById<TextView>(R.id.input_weight).text.toString().toFloatOrNull()
            val h = findViewById<TextView>(R.id.input_height).text.toString().toFloatOrNull()

            val bmi = w!! /h!! /h

            val res = findViewById<TextView>(R.id.res)
            res.text = getString(R.string.res, bmi, getStatus(bmi))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) { // Here You have to save count value
        super.onSaveInstanceState(outState)

        outState.putString("res", findViewById<TextView>(R.id.res).text.toString())
    }

    private fun getStatus(bmi : Float) : String {
        return when {
            bmi < 18.5 -> "Underweight"
            bmi <= 24.9 -> "Normal Weight"
            bmi <= 29.9 -> "Overweight"
            bmi <= 34.9 -> "Obesity class I"
            bmi <= 39.9 -> "Obesity class II"
            else -> "Obesity class III"
        }
    }
}