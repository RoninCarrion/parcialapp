package com.ronin.parcialapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        navigateTo()
    }
    fun navigateTo() {
        findViewById<Button>(R.id.btnImc).setOnClickListener(View.OnClickListener {
            val intent = Intent(this, CalcularImc::class.java)
            startActivity(intent)
        })

        findViewById<Button>(R.id.btnWeigth).setOnClickListener(
            View.OnClickListener {
                val intent = Intent(this, PesoIdeal:: class.java)
                startActivity(intent)
            }
        )

    }
}