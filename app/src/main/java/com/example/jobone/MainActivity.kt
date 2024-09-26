package com.example.jobone

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper

import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@MainActivity, ProductActivity::class.java)
            startActivity(intent)
            finish()
        },3000)

    }
}