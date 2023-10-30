package com.example.android1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class android7 : AppCompatActivity() {
    lateinit var mdatabase: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android7)

        val username = findViewById<EditText>(R.id.name)
        val email = findViewById<EditText>(R.id.mail)
        val aadharnumber = findViewById<EditText>(R.id.aadhar)
        val mobilenumber = findViewById<EditText>(R.id.mobile)
        val password = findViewById<EditText>(R.id.unique)
        val confirm = findViewById<Button>(R.id.confirmbutton)

        confirm.setOnClickListener {
            val name = username.text.toString()
            val mail = email.text.toString()
            val aadhar = aadharnumber.text.toString()
            val phonenumber = mobilenumber.text.toString()
            val uniqueid = password.text.toString()

            //Kotlin class names Users which is in firebase
            val user = Police(name, mail, aadhar, phonenumber, uniqueid)

            //saving contents of data in firebase
            mdatabase = FirebaseDatabase.getInstance().getReference("Police")
            mdatabase.child(uniqueid).setValue(user).addOnSuccessListener {
                Toast.makeText(this, "User Registered Successfully", Toast.LENGTH_SHORT).show()
                intent = Intent(applicationContext, android3::class.java)
                startActivity(intent)
            }.addOnFailureListener {
                Toast.makeText(this, "Registration is not Successfully", Toast.LENGTH_SHORT).show()
            }
        }
    }
}