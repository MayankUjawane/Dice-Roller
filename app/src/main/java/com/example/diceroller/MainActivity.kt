package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // do a dice roll when the app starts
        rollDice()

        // call rollDice when the roll button is clicked
        val button: Button = findViewById(R.id.bt_roll)
        button.setOnClickListener { rollDice() }
    }

    class Dice(private val numOfSides: Int) {
        fun roll(): Int {
            return (1..numOfSides).random()
        }
    }

    // show the dice image based on the diceRoll number
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.iv_dice)
        val imageResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        Toast.makeText(this, "You Rolled $diceRoll", Toast.LENGTH_LONG).show()
        diceImage.setImageResource(imageResource)
        diceImage.contentDescription = diceRoll.toString()
    }
}