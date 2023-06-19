package com.example.firebasetool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.firebasetool.R
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    lateinit var Txt_gotoreg:TextView
    lateinit var Edtlogemail:EditText
    lateinit var Edtlogpas:EditText
    lateinit var Btnlogin:Button
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Txt_gotoreg=findViewById(R.id.TvLogin)
        Edtlogemail=findViewById(R.id.EdtRegEmail)
        Edtlogpas=findViewById(R.id.EdtLogpass)
        Btnlogin=findViewById(R.id.btn_login)

        Txt_gotoreg.setOnClickListener {
            val intent=Intent(this,Registration::class.java)
            startActivity(intent)
        }
    }
}