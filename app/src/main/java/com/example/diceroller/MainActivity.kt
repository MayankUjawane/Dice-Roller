package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.bt_roll)
        button.setOnClickListener {
            rollDice()
        }
    }

    class Dice(private val numOfSides: Int) {
        fun roll(): Int {
            return (1..numOfSides).random()
        }
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val textView: TextView = findViewById(R.id.tv_text)
        textView.text = diceRoll.toString()
    }
}