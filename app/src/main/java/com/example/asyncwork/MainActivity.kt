package com.example.asyncwork

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.asyncwork.databinding.ActivityMainBinding
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


    val isDataLoaded: Boolean
        get() = binding.textUSDCourse.text != "---"
                && binding.textEuroCourse.text != "---"

    fun finisLoadingCallback(){
        if (isDataLoaded){
            binding.loadDataButton.isEnabled = true
            binding.progressBar.visibility = View.GONE
        }
    }

   private fun loadButtonCallback(){

        with(binding){
            //            binding.textUSDCourse.text = loadUsd().toString()
//            binding.textEuroCourse.text = loadEuro().toString()
            loadDataButton.isEnabled = false
            progressBar.visibility = View.VISIBLE
            textUSDCourse.text = "---"
            textEuroCourse.text = "---"

            loadUsd {
                textUSDCourse.text = it.toString()
                finisLoadingCallback()
            }

            loadEuro {
                textEuroCourse.text = it.toString()
                finisLoadingCallback()
            }
        }


    }

    private fun loadUsd(callback: (value: Float) -> Unit)//    : Float
    {
        thread {
            Thread.sleep(3000)
            callback(37.7f)
//            return 37.7f
        }
    }

    private fun loadEuro(callback: (value: Float) -> Unit) //    : Float
    {
        thread {
            Thread.sleep(4000)
            callback(42.1f)
//        return 42.1f
        }
    }

}
