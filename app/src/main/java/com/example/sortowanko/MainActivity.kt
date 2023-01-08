package com.example.sortowanko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.Random

class MainActivity : AppCompatActivity() {
    private lateinit var dataText: TextView
    private lateinit var rozmiarDanychInput: EditText
    private lateinit var startButton: Button
    private lateinit var generujButton: Button
    private lateinit var numery: List<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataText = findViewById(R.id.dataText)
        rozmiarDanychInput = findViewById(R.id.rozmiarDanychInput)

        val ran = Random()
        generujButton = findViewById(R.id.generujButton)
        generujButton.setOnClickListener {

            numery = (1..rozmiarDanychInput.text.toString().toInt()).map { ran.nextInt() }
            dataText.text = numery.toString()

        }

        fun bubbleSort(list: ArrayList<Int>) : ArrayList<Int> {
            var swap = true

            while(swap){
                swap = false
                for(i in 0 until list.size-1) {
                    if(list[i] > list[i+1]) {
                        val temp = list[i]
                        list[i] = list[i+1]
                        list[i + 1] = temp
                        swap = true
                    }
                }
            }
            return list
        }

        startButton = findViewById(R.id.startButton)
        startButton.setOnClickListener {

            val bubbleSort = bubbleSort(numery as ArrayList<Int>)
            dataText.text = bubbleSort.toString()
//
            //
        }
    }
}