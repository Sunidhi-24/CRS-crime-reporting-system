package com.example.android1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.database.DatabaseReference

class android6 : AppCompatActivity() {

    lateinit var mdatabase: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android6)
//saving data in firebase
        val mobilenumber=findViewById<EditText>(R.id.phone)
        val password=findViewById<EditText>(R.id.pid)
        val confirmpassword=findViewById<EditText>(R.id.pidc)
        val confirm=findViewById<Button>(R.id.confirm_button)
        confirm.setOnClickListener {
            val phonenumber=mobilenumber.text.toString()
            val uniqueid=password.text.toString()
            val dateofbirth=confirmpassword.text.toString()

            intent= Intent(applicationContext,android4::class.java)
            startActivity(intent)
        }

    }
}