package com.example.just

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.UserData
import android.widget.ArrayAdapter
import android.widget.Toast

import com.example.just.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val userLogin = binding.userLogin
        val userEmail = binding.userEmail
        val userPass = binding.userPass

        binding.btn.setOnClickListener {
            val login = userLogin.text.toString()
            val email = userEmail.text.toString()
            val pass = userPass.text.toString()

            if (login == "" || email == "" || pass == "") {
                Toast.makeText(this, "Не заполнены все поля!", Toast.LENGTH_LONG).show()
            }

            else {
                //val user:User=User(login, email,pass)
                val user = User(login, email, pass)

                val db = dbHelper(this, null)
                db.addUser(user)
                Toast.makeText(this, "Пользователь добавлен", Toast.LENGTH_SHORT).show()
            }




        }
    }

}
