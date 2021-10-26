package com.example.singupin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Details : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var dearTextView: TextView
    lateinit var infoTextView: TextView
    lateinit var signOutBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        textView = findViewById(R.id.textView2)
        dearTextView = findViewById(R.id.dearTextView)
        infoTextView = findViewById(R.id.infoTextView)
        signOutBtn = findViewById(R.id.singOutBtn)

        val name = intent.getStringExtra("Name")
        val mobile = intent.getStringExtra("Mobile")
        val location = intent.getStringExtra("Location")

        dearTextView.text = "Dear $mobile member"
        infoTextView.text = "Name: $name \nLocation: $location"

        signOutBtn.setOnClickListener {
            //back to the main Activity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}