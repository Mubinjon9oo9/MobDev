package com.example.lab1

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class Lab5Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab5)

        val formatGroup = findViewById<RadioGroup>(R.id.formatGroup)
        val pageCountInput = findViewById<EditText>(R.id.pageCountInput)
        val okButton = findViewById<Button>(R.id.okButton)

        okButton.setOnClickListener {
            val selectedId = formatGroup.checkedRadioButtonId
            val count = pageCountInput.text.toString().toIntOrNull()

            if (selectedId == -1 || count == null || count <= 0) {
                Toast.makeText(this, "Выберите формат и введите число страниц", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val pricePerPage = when (selectedId) {
                R.id.formatA4 -> 10
                R.id.formatA3 -> 30
                R.id.formatA1 -> 100
                else -> 0
            }

            val total = pricePerPage * count

            val intent = Intent(this, ResultActivity::class.java).apply {
                putExtra("total", total)
            }
            startActivity(intent)
        }
    }
}
