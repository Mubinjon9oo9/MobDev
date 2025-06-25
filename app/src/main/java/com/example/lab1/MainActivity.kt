package com.example.lab1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnConvertArshin = findViewById<Button>(R.id.btnConvertArshin)
        btnConvertArshin.setOnClickListener {
            val intent = Intent(this, Lab1Activity::class.java)
            startActivity(intent)
        }
    }
}
