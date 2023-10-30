package com.example.android1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class android10 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android10)

        val proceed=findViewById<Button>(R.id.proceed)
        proceed.setOnClickListener {
            intent= Intent(applicationContext,android3::class.java)
            startActivity(intent)
        }
    }
}