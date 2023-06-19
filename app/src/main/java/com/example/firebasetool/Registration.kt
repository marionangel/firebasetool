package com.example.firebasetool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.firebasetool.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Registration : AppCompatActivity() {
    lateinit var Txt_login:TextView
    lateinit var Edtregemail:EditText
    lateinit var Edtregpass:EditText
    lateinit var Edtconfirmpass:EditText
    lateinit var Btn_Register:Button
    lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        Txt_login = findViewById(R.id.Tv_back)
        Edtregemail = findViewById(R.id.EdtAddress)
        Edtregpass = findViewById(R.id.EdtPass)
        Edtconfirmpass = findViewById(R.id.Edtconpass)
        Btn_Register = findViewById(R.id.btnReg)
        auth= Firebase.auth
        Txt_login.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
        Btn_Register.setOnClickListener {
            Signupuser()
        }
    }
    private fun Signupuser(){
        val email=Edtregemail.text.toString()
        val pass=Edtregpass.text.toString()
        val confirmpass=Edtconfirmpass.text.toString()

        if(email.isBlank()||pass.isBlank()||confirmpass.isBlank()){
            Toast.makeText(this,"Password and email can't be blank",Toast.LENGTH_LONG).show()
            return
        }else if (pass !=confirmpass) {
            Toast.makeText(this,"Password does not match",Toast.LENGTH_LONG).show()
        }
        auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this) {
            if (it.isSuccessful){
                Toast.makeText(this,"Signed up succesfully",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Failed to create user",Toast.LENGTH_LONG).show()
            }
        }
    }

}