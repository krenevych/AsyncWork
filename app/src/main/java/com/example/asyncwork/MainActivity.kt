package com.example.asyncwork

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.asyncwork.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
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
            textUSDCourse.text = loadUsd().toString()
            textEuroCourse.text = loadEuro().toString()
            binding.loadDataButton.isEnabled = true
            binding.progressBar.visibility = View.GONE
        }
    }

    private fun loadUsd(): Float {
//        delay(3000)
        return 37.7f
    }

    private fun loadEuro(): Float {
//        delay(4000)
        return 42.1f
    }


}
