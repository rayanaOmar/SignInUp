package com.example.singupin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.singupin.Database.DatabaseHelper

class SignIn : AppCompatActivity() {

    private lateinit var nameEd: EditText
    private lateinit var mobileEd: EditText
    private lateinit var signInBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        nameEd = findViewById(R.id.edName)
        mobileEd = findViewById(R.id.edMobile)
        signInBtn = findViewById(R.id.signInBtn)

        signInBtn.setOnClickListener {
            //take the user enters
            val name = nameEd.text.toString()
            val mobile = mobileEd.text.toString()

            val databaseHelper = DatabaseHelper(applicationContext)

            //retrieve user information from database
            val retrieve = databaseHelper.retrieveUserInfo(name, mobile)
            println(retrieve)

            if(retrieve!= null){ // make sure the database return something

                //show the user information in details page
                val intent = Intent(this, Details::class.java)
                intent.putExtra("name", retrieve.name)
                intent.putExtra("mobile", retrieve.mobile)
                intent.putExtra("location", retrieve.location)
                startActivity(intent)
            }else{
                Toast.makeText(applicationContext, "Something Went Wrong!!"
                    ,Toast.LENGTH_LONG).show()
            }
        }
    }
}