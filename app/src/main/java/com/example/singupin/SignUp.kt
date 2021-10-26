package com.example.singupin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.singupin.Database.DatabaseHelper

class SignUp : AppCompatActivity() {

    lateinit var nameEditText: EditText
    lateinit var mobileEditText: EditText
    lateinit var locationEditText: EditText
    lateinit var passEditText: EditText
    lateinit var submitBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val databaseHelper = DatabaseHelper(applicationContext)

        nameEditText = findViewById(R.id.nameED)
        mobileEditText = findViewById(R.id.mobileED)
        locationEditText = findViewById(R.id.locationED)
        passEditText = findViewById(R.id.passwordED)

        submitBtn = findViewById(R.id.submitBtn)
        submitBtn.setOnClickListener {
            //take the user enters
            val name = nameEditText.text.toString()
            val mobile = mobileEditText.text.toString()
            val location = locationEditText.text.toString()
            val passWord = passEditText.text.toString()

            //Save to the database
            databaseHelper.saveUserInfo(name, mobile, location, passWord)

            //show the user information in details page
            val intent = Intent(this, Details::class.java)
            intent.putExtra("Name", name)
            intent.putExtra("Mobile", mobile)
            intent.putExtra("Location", location)
            startActivity(intent)
        }
    }
}