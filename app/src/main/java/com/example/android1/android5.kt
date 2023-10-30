package com.example.android1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class android5 : AppCompatActivity() {

    lateinit var mdatabase:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android5)

        //declaring the variables
        val username=findViewById<EditText>(R.id.name)
        val email=findViewById<EditText>(R.id.mail)
        val aadharnumber=findViewById<EditText>(R.id.aadhar)
        val mobilenumber=findViewById<EditText>(R.id.phone)
        val password=findViewById<EditText>(R.id.pid)
        val confirm=findViewById<Button>(R.id.confirm_button)

        confirm.setOnClickListener {
            val name=username.text.toString()
            val mail=email.text.toString()
            val aadhar=aadharnumber.text.toString()
            val phonenumber=mobilenumber.text.toString()
            val uniqueid=password.text.toString()

            //Kotlin class names Users which is in firebase
            val user=Users(name,mail,aadhar,phonenumber,uniqueid)

            //saving contents of data in firebase
            mdatabase=FirebaseDatabase.getInstance().getReference("Users")
            mdatabase.child(uniqueid).setValue(user).addOnSuccessListener {
                Toast.makeText(this,"User Registered Successfully",Toast.LENGTH_SHORT).show()
                intent= Intent(applicationContext,android2::class.java)
                startActivity(intent)
            }.addOnFailureListener{
                Toast.makeText(this,"Registration is not Successfully",Toast.LENGTH_SHORT).show()
            }
        }
    }
}