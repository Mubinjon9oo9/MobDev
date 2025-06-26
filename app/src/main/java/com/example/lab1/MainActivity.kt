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
        val btnLab2 = findViewById<Button>(R.id.btnLab2)
        btnLab2.setOnClickListener {
            val intent = Intent(this, Lab2Activity::class.java)
            startActivity(intent)
        }
        val btnLab3 = findViewById<Button>(R.id.btnLab3)
        btnLab3.setOnClickListener {
            val intent = Intent(this, Lab3Activity::class.java)
            startActivity(intent)
        }
        val btnLab4 = findViewById<Button>(R.id.btnLab4)
        btnLab4.setOnClickListener {
            val intent = Intent(this, Lab4Activity::class.java)
            startActivity(intent)
        }
        val btnLab4_1 = findViewById<Button>(R.id.btnLab41)
        btnLab4_1.setOnClickListener {
            val intent = Intent(this, Lab4_1Activity::class.java)
            startActivity(intent)
        }
        val btnLab5 = findViewById<Button>(R.id.btnLab5)
        btnLab5.setOnClickListener {
            val intent = Intent(this, Lab5Activity::class.java)
            startActivity(intent)
        }
    }
}
