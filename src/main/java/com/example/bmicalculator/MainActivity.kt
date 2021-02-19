package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btnEnterName)
        btn.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("userName", findViewById<TextView>(R.id.plain_text_input).text.toString())
            startActivity(intent)
        }
    }
}