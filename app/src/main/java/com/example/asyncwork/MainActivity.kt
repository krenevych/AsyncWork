package com.example.asyncwork

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.asyncwork.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.loadDataButton.setOnClickListener {
            loadButtonCallback()
        }
    }

    private fun loadButtonCallback() {

        with(binding) {

            loadDataButton.isEnabled = false
            progressBar.visibility = View.VISIBLE
            textUSDCourse.text = "---"
            textEuroCourse.text = "---"
            lifecycleScope.launch {
                textUSDCourse.text = loadUsd().toString()
                textEuroCourse.text = loadEuro().toString()

                binding.loadDataButton.isEnabled = true
                binding.progressBar.visibility = View.GONE
            }
        }
    }

    private suspend fun loadUsd(): Float {
        delay(3000)
        return 37.7f
    }

    private suspend fun loadEuro(): Float {
        delay(4000)
        return 42.1f
    }


}
