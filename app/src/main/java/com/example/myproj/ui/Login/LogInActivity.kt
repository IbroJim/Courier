package com.example.myproj.ui.Login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.myproj.R
import com.example.myproj.ui.requst.RequstActivity

class LogInActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val img = findViewById<Button>(R.id.log_in)
        img.setOnClickListener {
            val intent = Intent(this, RequstActivity::class.java)
            startActivity(intent)
        }
    }
}