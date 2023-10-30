package com.example.android1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class android2 : AppCompatActivity() {
    private lateinit var mdatabase:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android2)
//declare the ids
        val createaccount = findViewById<Button>(R.id.createaccount)
        val loginuser=findViewById<Button>(R.id.login)
        val uniqueid=findViewById<EditText>(R.id.password)

//onclicklistener
        loginuser.setOnClickListener {
            val uniqueid=uniqueid.text.toString()
            if(uniqueid.isNotEmpty() )
            {
                readData(uniqueid)
            }
            else{
                Toast.makeText(this,"Please enter valid password",Toast.LENGTH_SHORT).show()
            }
        }

//onclick listener
        createaccount.setOnClickListener {
            intent = Intent(applicationContext, android5::class.java)
            startActivity(intent)
        }
    }

    //linking of firebase with login
    private fun readData(uniqueid:String) {
        mdatabase=FirebaseDatabase.getInstance().getReference("Users")
        mdatabase.child(uniqueid).get().addOnSuccessListener {
                if(it.exists())
                {
                    intent=Intent(applicationContext,android9::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this,"Account does not exist",Toast.LENGTH_SHORT).show()
                }
        }.addOnFailureListener{
            Toast.makeText(this,"User not found",Toast.LENGTH_SHORT).show()
        }

    }
}

