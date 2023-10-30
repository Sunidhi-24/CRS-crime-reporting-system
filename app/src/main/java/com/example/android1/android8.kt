package com.example.android1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class android8 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android8)

        val confirmbtn=findViewById<Button>(R.id.confirm)
        intent= Intent(applicationContext,android10::class.java)
        startActivity(intent)
    }
}