package com.example.shereheapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var reglogin:Button

    private lateinit var edtemail:EditText
    private lateinit var edtpassword:EditText
    private lateinit var btnlogin:Button


    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        reglogin = findViewById(R.id.btnRegLogin)

        edtemail = findViewById(R.id.edtemail)
        edtpassword = findViewById(R.id.edtpassword)
        btnlogin = findViewById(R.id.btnloginaccount)

        auth = FirebaseAuth.getInstance()



        reglogin.setOnClickListener {

            startActivity(Intent(this, Register::class.java))
        }

        btnlogin.setOnClickListener{

            val email = edtemail.text.toString().trim()
            val password = edtpassword.text.toString().trim()



            if ( email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "One of the Fields is Empty", Toast.LENGTH_SHORT).show()
            }else{

                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){
                    if (it.isSuccessful){
                        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()

                        val gotomain = Intent(this, list::class.java)
                        startActivity(gotomain)
                        finish()

                    }else{
                        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
                    }

                }

            }

        }


    }
}