package com.example.shereheapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Bookings : AppCompatActivity() {


    private lateinit var gogobook:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookings)

        gogobook = findViewById(R.id.gogobook)

        gogobook.setOnClickListener {

            startActivity(Intent(this, payment::class.java))
        }

    }
}