package com.example.shereheapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class payment : AppCompatActivity() {

    private lateinit var nameone: EditText
    private lateinit var emailtwo: EditText
    private lateinit var datethree: EditText
    private lateinit var locationfour: EditText
    private lateinit var numberfive: EditText
    private lateinit var btnnow: Button

    lateinit var auth: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        nameone = findViewById(R.id.nameone)
        emailtwo = findViewById(R.id.emailtwo)
        datethree = findViewById(R.id.datethree)
        locationfour = findViewById(R.id.locationfour)
        numberfive = findViewById(R.id.numberfive)
        btnnow = findViewById(R.id.btnnow)

        auth = FirebaseDatabase.getInstance()

        btnnow.setOnClickListener {

            var name = nameone.text.toString().trim()
            var email = emailtwo.text.toString().trim()
            var date = datethree.text.toString().trim()
            var location = locationfour.text.toString().trim()
            var number = numberfive.text.toString().trim()

            btnnow.setOnClickListener {

                var name = nameone.text.toString().trim()
                var email = emailtwo.text.toString().trim()
                var date = datethree.text.toString().trim()
                var location = locationfour.text.toString().trim()
                var number = numberfive.text.toString().trim()



                if (name.isEmpty() || email.isEmpty() || date.isEmpty() || location.isEmpty() || number.isEmpty()) {
                    Toast.makeText(this, "Cannot Submit an Empty Field", Toast.LENGTH_SHORT).show()
                } else {

                    //saving info to firebase db


                    var userbooking = book(name, email, date, location, number)

                    var ref = FirebaseDatabase.getInstance().getReference().child("book")

                    ref.setValue(userbooking).addOnCompleteListener {

                        if (it.isSuccessful) {
                            Toast.makeText(
                                this, "Booking Informaton Uploaded Successfully... You'll Be Contacted Soon.",
                                Toast.LENGTH_LONG
                            ).show()
                        } else {
                            Toast.makeText(
                                this, "Failed Upload Booking Info",
                                Toast.LENGTH_LONG
                            ).show()
                        }

                    }


                }


            }


        }


    }
}




