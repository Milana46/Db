package com.example.just

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.sql.SQLData

class dbHelper(val context: Context, val factory: SQLiteDatabase.CursorFactory?):
SQLiteOpenHelper(context, "app",factory, 1){

    override fun onCreate(db: SQLiteDatabase?) {
             val query="CREATE TABLE users (id INT PRIMARY KEY, login TEXT, email TEXT, pass TEXT)"
             db!!.execSQL(query)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        db!!.execSQL("DROP TABLE IF EXISTS users") //удаляем если выполнилось
        onCreate(db)

    }

    //ContentValue хранит в себе пары    имя стоблца-значение!!!
    fun addUser(user:User){
        val values=ContentValues()
        values.put("login",user.login)
        values.put("email",user.email)
        values.put("pass",user.pass)

       val db=this.writableDatabase  //текущая бд!!!
        db.insert("users",null,values)

        db.close()

    }



}