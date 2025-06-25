package com.example.lab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab1.ui.theme.Lab1Theme
import android.widget.TextView
import android.widget.Button
import android.widget.EditText

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val inputNumber = findViewById<EditText>(R.id.inputNumber)
        val outputText = findViewById<TextView>(R.id.outputText)
        val button = findViewById<Button>(R.id.showResultButton)

        button.setOnClickListener {
            val numberText = inputNumber.text.toString()
            val number = numberText.toDoubleOrNull()

            if (number != null) {
                val arshin= number*0.7112
                outputText.text = "$arshin"
            } else {
                outputText.text = "Пожалуйста, введите корректное число"
            }
        }
        val dayInput = findViewById<EditText>(R.id.dayInput)
        val dayResult = findViewById<TextView>(R.id.dayResult)
        val dayButton = findViewById<Button>(R.id.dayButton)
        dayButton.setOnClickListener {
            val dayNum = dayInput.text.toString().toIntOrNull()
            val days = listOf(
                "Понедельник", "Вторник", "Среда", "Четверг",
                "Пятница", "Суббота", "Воскресенье"
            )

            if (dayNum != null && dayNum in 1..7) {
                dayResult.text = "День недели: ${days[dayNum - 1]}"
            } else {
                dayResult.text = "Введите число от 1 до 7"
            }
        }
    }
}
