package com.example.singupin.Database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context): SQLiteOpenHelper(
    context, "details", null,1){

    private val database: SQLiteDatabase = writableDatabase

    override fun onCreate(dbase: SQLiteDatabase) {
       if(dbase != null){
           dbase.execSQL("create table users(name text, mobile text , location text , password text)")
       }
    }

    override fun onUpgrade(dbase:SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun saveUserInfo(name: String, mobile: String, location: String, password: String){
        val contentValue = ContentValues()

        contentValue.put("Name", name)
        contentValue.put("Mobile", mobile)
        contentValue.put("Location", location)
        contentValue.put("Password", password)

        database.insert("users", null, contentValue)

    }

    fun retrieveUserInfo(name: String, mobile: String):Users? {
        val c: Cursor = database.query("users", null,
            "name=?", arrayOf(name), null,null,null)

        if(c.count < 1){
            return null
        }

        c.moveToFirst()
        val user: Users
        val saveMobile = c.getString(c.getColumnIndex("Mobile"))
        if(saveMobile == mobile){
            val saveLocation = c.getString(c.getColumnIndex("Location"))
            user = Users(name, mobile, saveLocation)
            return user
        }else{
            return null
        }
    }
}