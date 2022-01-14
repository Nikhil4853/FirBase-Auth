package com.example.chatapp_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.auth.FirebaseAuth as FirebaseAuth1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Go Login Activity
        Go_Login_Activity.setOnClickListener {
            val intent = Intent(this, loginActivity::class.java)
            startActivity(intent)
        }

// FireBase RegisterButton Click handling
        Register_button.setOnClickListener {
            // Register function Call
            val email: String = Register_Email_text.text.toString()
            val password = Register_text_password.text.toString()
            com.google.firebase.auth.FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (!it.isSuccessful) {
                        Toast.makeText(
                            applicationContext,
                            "Please check Email and Password",
                            Toast.LENGTH_SHORT
                        ).show()
                        return@addOnCompleteListener
                    } else {
                        Toast.makeText(
                            applicationContext,
                            "User Register Successful",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

        }
    }

//FireBase Register Function

}