package com.example.lab1

import androidx.lifecycle.ViewModel

class QuizViewModel : ViewModel() {
    private val questionList = listOf(
        Question("Солнце — звезда?", true),
        Question("Земля плоская?", false),
        Question("Вода кипит при 100°C?", true)
    )

    var currentIndex = 0
    var correctAnswers = 0
    var cheatUsedCount = 0
    var hasAnswered = false

    val currentQuestion: Question
        get() = questionList[currentIndex]

    val isLastQuestion: Boolean
        get() = currentIndex == questionList.lastIndex

    fun moveToNext() {
        if (currentIndex < questionList.lastIndex) {
            currentIndex++
            hasAnswered = false
        }
    }

    data class Question(val text: String, val answer: Boolean)
}
