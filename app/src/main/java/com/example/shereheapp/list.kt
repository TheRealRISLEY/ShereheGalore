package com.example.shereheapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class list : AppCompatActivity() {


    private lateinit var viewbtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        viewbtn = findViewById(R.id.viewbtn)

        viewbtn.setOnClickListener {

            startActivity(Intent(this, Bookings::class.java))
        }
    }
}