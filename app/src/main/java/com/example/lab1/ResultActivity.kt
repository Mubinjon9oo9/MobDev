package com.example.lab1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val total = intent.getIntExtra("total", 0)

        val resultView = findViewById<TextView>(R.id.orderResultText)
        resultView.text = "Сумма заказа = $total руб."
    }
}
