package com.example.shereheapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var getstarted : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getstarted = findViewById(R.id.getstartedbtn)


        getstarted.setOnClickListener {

            startActivity(Intent(this, Register::class.java))
        }
    }
}



