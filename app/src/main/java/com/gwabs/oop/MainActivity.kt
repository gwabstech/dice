package com.gwabs.oop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnRoll : Button = findViewById(R.id.btnRoll)
        btnRoll.setOnClickListener {
           rollDice()
        }
    }

    private fun rollDice() {
        val  dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage : ImageView = findViewById(R.id.ivDice)
        loging(diceRoll.toString())
        when(diceRoll){
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
            else -> Toast.makeText(this,"sorry the diced is over",Toast.LENGTH_SHORT).show()
        }

    }

    private fun loging(message: String){
        Log.v(TAG,message)
    }

}

class Dice(private val numSide : Int){

    fun roll(): Int{
        return (1..numSide).random()
    }
}