package com.example.android1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class android9 : AppCompatActivity() {
    private lateinit var mdatabase: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android9)

        val loggingout=findViewById<Button>(R.id.logout)
        loggingout.setOnClickListener {
            Toast.makeText(this,"Logging out....", Toast.LENGTH_SHORT).show()
            intent= Intent(applicationContext,android2::class.java)
            startActivity(intent)
        }

        val crimesdone=findViewById<EditText>(R.id.crime)
        val explanation=findViewById<EditText>(R.id.incident)
        val submit=findViewById<Button>(R.id.submit)
        submit.setOnClickListener {
            val crimes=crimesdone.text.toString()
            val incident=explanation.text.toString()
            val complaint=Complaints(crimes,incident)
            mdatabase = FirebaseDatabase.getInstance().getReference("Crimes")
            mdatabase.child(crimes).setValue(complaint).addOnSuccessListener {
                Toast.makeText(this, "Complaint Registered Successfully", Toast.LENGTH_SHORT).show()
                intent = Intent(applicationContext, android2::class.java)
                startActivity(intent)
            }.addOnFailureListener {
                Toast.makeText(this, "Registration is not Successfully", Toast.LENGTH_SHORT).show()
            }
        }
    }
}