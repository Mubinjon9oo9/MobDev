package com.example.lab1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Lab3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab3)

        val inputString = findViewById<EditText>(R.id.inputString)
        val buttonCountLatin = findViewById<Button>(R.id.buttonCountLatin)
        val resultView = findViewById<TextView>(R.id.resultView)

        buttonCountLatin.setOnClickListener {
            val text = inputString.text.toString()
            var count = 0

            // Цикл по индексам (обращение к символам по индексу)
            for (i in text.indices) {
                val ch = text[i]
                // Проверяем, является ли символ латинской буквой
                if (ch in 'A'..'Z' || ch in 'a'..'z') {
                    count++
                }
            }

            resultView.text = "Количество латинских букв: $count"
        }
    }
}
