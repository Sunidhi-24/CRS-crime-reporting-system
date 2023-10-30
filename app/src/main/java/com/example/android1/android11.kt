package com.example.android1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class android11 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android11)

        val cases=findViewById<Button>(R.id.select)
        cases.setOnClickListener {
        intent= Intent(applicationContext,android12::class.java)
        startActivity(intent)
        }
        val loggingout=findViewById<Button>(R.id.logout)
        loggingout.setOnClickListener {
            Toast.makeText(this,"Logging out....", Toast.LENGTH_SHORT).show()
            intent= Intent(applicationContext,android3::class.java)
            startActivity(intent)
        }



    }
}