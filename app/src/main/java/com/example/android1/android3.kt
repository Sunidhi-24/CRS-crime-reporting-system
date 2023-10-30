package com.example.android1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class android3 : AppCompatActivity() {

    private lateinit var mdatabase: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android3)
        //police login screen

        val createaccount = findViewById<Button>(R.id.createaccount)
        val loginuser=findViewById<Button>(R.id.login)
        val uniqueid=findViewById<EditText>(R.id.password)

        loginuser.setOnClickListener {
            val uniqueid=uniqueid.text.toString()
            if(uniqueid.isNotEmpty() )
            {
                readData(uniqueid)
            }
            else{
                Toast.makeText(this,"Please enter valid password", Toast.LENGTH_SHORT).show()
            }
        }
        createaccount.setOnClickListener {
            intent= Intent(applicationContext,android7::class.java)
            startActivity(intent)
        }
    }

    private fun readData(uniqueid:String) {
        mdatabase= FirebaseDatabase.getInstance().getReference("Police")
        mdatabase.child(uniqueid).get().addOnSuccessListener {
            if(it.exists())
            {
                intent=Intent(applicationContext,android11::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this,"Account does not exist",Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener{
            Toast.makeText(this,"User not found",Toast.LENGTH_SHORT).show()
        }


    }
}