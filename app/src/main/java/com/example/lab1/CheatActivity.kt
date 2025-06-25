package com.example.lab1

import android.app.Activity
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab1.databinding.ActivityCheatBinding

class CheatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCheatBinding
    private var answer = false
    private var cheated = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        answer = intent.getBooleanExtra(Lab4_1Activity.EXTRA_ANSWER, false)

        binding.cheatAnswerText.text = "Нажмите, чтобы узнать ответ"
        binding.apiLevelText.text = "API: ${Build.VERSION.SDK_INT}"

        binding.showAnswerButton.setOnClickListener {
            binding.cheatAnswerText.text = if (answer) "True" else "False"
            cheated = true
            setResult(Activity.RESULT_OK, intent.putExtra(Lab4_1Activity.EXTRA_CHEATED, true))
        }
    }
}
