package com.example.lab1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.abs

class Lab2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab2)

        val epsilon = 0.0001

        var sum = 0.0
        var term: Int
        var i = 1
        var count = 0
        var lastN = 1
        do {
            term = i * i
            sum += 1.0 / term
            lastN = i
            i++
            count++
        } while (1.0 / term >= epsilon)

        val resultView = findViewById<TextView>(R.id.resultView)
        resultView.text = """
            Сумма: $sum
            Последнее слагаемое: $term
            Число итераций: $count
        """.trimIndent()
    }
}
