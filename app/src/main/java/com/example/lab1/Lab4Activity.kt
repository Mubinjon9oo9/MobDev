package com.example.lab1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Lab4Activity : AppCompatActivity() {

    private val questions = listOf(
        Question("Солнце — звезда?", true),
        Question("Земля плоская?", false),
        Question("Вода кипит при 100 градусах Цельсия?", true)
    )

    private var currentIndex = 0
    private var correctAnswersCount = 0
    private var answeredCurrent = false

    private lateinit var questionTextView: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button

    companion object {
        private const val KEY_INDEX = "currentIndex"
        private const val KEY_SCORE = "correctAnswersCount"
        private const val KEY_ANSWERED = "answeredCurrent"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab4)

        questionTextView = findViewById(R.id.questionTextView)
        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)
        nextButton = findViewById(R.id.nextButton)

        if (savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt(KEY_INDEX, 0)
            correctAnswersCount = savedInstanceState.getInt(KEY_SCORE, 0)
            answeredCurrent = savedInstanceState.getBoolean(KEY_ANSWERED, false)
        }

        updateQuestion()
        updateButtonsVisibility()

        trueButton.setOnClickListener {
            checkAnswer(true)
        }

        falseButton.setOnClickListener {
            checkAnswer(false)
        }

        nextButton.setOnClickListener {
            if (currentIndex < questions.size - 1) {
                currentIndex++
                answeredCurrent = false
                updateQuestion()
                updateButtonsVisibility()
            }
        }
    }

    private fun updateQuestion() {
        questionTextView.text = questions[currentIndex].text
    }

    private fun updateButtonsVisibility() {
        if (answeredCurrent) {
            trueButton.visibility = Button.INVISIBLE
            falseButton.visibility = Button.INVISIBLE
            nextButton.isEnabled = true
            nextButton.visibility = Button.VISIBLE

            // Если последний вопрос — блокируем и скрываем кнопку Next
            if (currentIndex == questions.size - 1) {
                nextButton.isEnabled = false
                nextButton.visibility = Button.INVISIBLE
                showResult()
            }
        } else {
            trueButton.visibility = Button.VISIBLE
            falseButton.visibility = Button.VISIBLE
            nextButton.isEnabled = false
            nextButton.visibility = Button.VISIBLE
        }
    }

    private fun checkAnswer(userAnswer: Boolean) {
        if (answeredCurrent) return

        val correctAnswer = questions[currentIndex].answer
        if (userAnswer == correctAnswer) {
            correctAnswersCount++
            Toast.makeText(this, "Правильно!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Неправильно!", Toast.LENGTH_SHORT).show()
        }

        answeredCurrent = true
        updateButtonsVisibility()
    }

    private fun showResult() {
        Toast.makeText(
            this,
            "Тест завершён! Правильных ответов: $correctAnswersCount из ${questions.size}",
            Toast.LENGTH_LONG
        ).show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_INDEX, currentIndex)
        outState.putInt(KEY_SCORE, correctAnswersCount)
        outState.putBoolean(KEY_ANSWERED, answeredCurrent)
    }

    data class Question(val text: String, val answer: Boolean)
}
