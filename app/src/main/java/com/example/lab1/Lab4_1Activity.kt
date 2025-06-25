package com.example.lab1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.lab1.databinding.ActivityLab41Binding

class Lab4_1Activity : AppCompatActivity() {

    private lateinit var binding: ActivityLab41Binding
    private val viewModel: QuizViewModel by viewModels()

    companion object {
        const val REQUEST_CODE_CHEAT = 1
        const val EXTRA_ANSWER = "com.example.lab1.answer"
        const val EXTRA_CHEATED = "com.example.lab1.cheated"
        const val MAX_CHEATS = 3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLab41Binding.inflate(layoutInflater)
        setContentView(binding.root)

        updateUI()

        binding.trueButton.setOnClickListener {
            checkAnswer(true)
        }

        binding.falseButton.setOnClickListener {
            checkAnswer(false)
        }

        binding.nextButton.setOnClickListener {
            viewModel.moveToNext()
            updateUI()
        }

        binding.cheatButton.setOnClickListener {
            if (viewModel.cheatUsedCount >= MAX_CHEATS) {
                Toast.makeText(this, "Больше нельзя жульничать!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, CheatActivity::class.java).apply {
                putExtra(EXTRA_ANSWER, viewModel.currentQuestion.answer)
            }
            startActivityForResult(intent, REQUEST_CODE_CHEAT)
        }
    }

    private fun updateUI() {
        binding.questionTextView.text = viewModel.currentQuestion.text
        binding.trueButton.isEnabled = !viewModel.hasAnswered
        binding.falseButton.isEnabled = !viewModel.hasAnswered

        if (viewModel.isLastQuestion && viewModel.hasAnswered) {
            binding.nextButton.isEnabled = false
            Toast.makeText(
                this,
                "Результат: ${viewModel.correctAnswers} правильных",
                Toast.LENGTH_LONG
            ).show()
        } else {
            binding.nextButton.isEnabled = viewModel.hasAnswered
        }
    }

    private fun checkAnswer(userAnswer: Boolean) {
        if (viewModel.hasAnswered) return

        val correct = viewModel.currentQuestion.answer

        if (userAnswer == correct) {
            viewModel.correctAnswers++
            Toast.makeText(this, "Верно!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Неверно", Toast.LENGTH_SHORT).show()
        }

        viewModel.hasAnswered = true
        updateUI()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE_CHEAT && resultCode == RESULT_OK) {
            val cheated = data?.getBooleanExtra(EXTRA_CHEATED, false) ?: false
            if (cheated) {
                viewModel.cheatUsedCount++
                Toast.makeText(this, "Жульничество №${viewModel.cheatUsedCount}", Toast.LENGTH_SHORT).show()
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}
