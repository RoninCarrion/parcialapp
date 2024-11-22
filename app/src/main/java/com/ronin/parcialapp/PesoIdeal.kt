package com.ronin.parcialapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class PesoIdeal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peso_ideal)

        val etPeso = findViewById<EditText>(R.id.etSexo)
        val etAltura = findViewById<EditText>(R.id.etAltura)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val btnRegresar = findViewById<Button>(R.id.btnRegresar)
        val tvResult = findViewById<TextView>(R.id.tvResult)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)

        btnCalcular.setOnClickListener {
            val sexo = etPeso.text.toString()
            val altura = etAltura.text.toString().toFloatOrNull()


            if (altura != null && altura > 0) {
                val pesoIdeal = getIdealWeigth(altura, sexo)
                tvResult.text = "$pesoIdeal Kg"
                tvStatus.text = "Tu peso ideal es de: $pesoIdeal Kg"
            } else {
                tvStatus.text = "Por favor, ingresa valores válidos."
            }
        }

        btnRegresar.setOnClickListener {
            finish()
        }
    }
    fun getIdealWeigth(altura: Float, sexo : String): String {
        return if (sexo.lowercase(Locale.getDefault()) == "hombre" || sexo.lowercase(Locale.getDefault()) == "masculino"){
            "${altura - 100}"
        } else if (sexo.lowercase(Locale.getDefault()) == "mujer" || sexo.lowercase(Locale.getDefault()) == "femenino"){
            "${altura - 105}"
        } else {
            "Ingresa un género válido"
        }

    }
}
