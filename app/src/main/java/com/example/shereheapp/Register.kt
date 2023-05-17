package com.example.shereheapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity() {

    private lateinit var logregister:Button
    private lateinit var edtregname:EditText
    private lateinit var edtregemail:EditText
    private lateinit var edtregpassword:EditText
    private lateinit var btnregaccount:Button


    lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        logregister = findViewById(R.id.btnLogRegister)

        edtregname = findViewById(R.id.edtregname)
        edtregemail = findViewById(R.id.edtregemail)
        edtregpassword = findViewById(R.id.edtregpassword)
        btnregaccount = findViewById(R.id.btnregaccount)

        auth = FirebaseAuth.getInstance()


        logregister.setOnClickListener {

            startActivity(Intent(this, Login::class.java))
        }

        btnregaccount.setOnClickListener {

            var name = edtregname.text.toString().trim()
            var email = edtregemail.text.toString().trim()
            var password = edtregpassword.text.toString().trim()

            //validate your inputs

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {

                Toast.makeText(this, "One of the Fields is Empty", Toast.LENGTH_SHORT).show()

            } else {
                //Create a User in Firebase
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) {

                    if (it.isSuccessful) {
                        Toast.makeText(this, "User Created Successfully", Toast.LENGTH_SHORT).show()
                        var gotologin = Intent(this, Login::class.java)
                        startActivity(gotologin)
                        finish()
                    } else {
                        Toast.makeText(this, "Failed to Create Account", Toast.LENGTH_SHORT).show()
                    }
                }


            }

        }

    }
}
