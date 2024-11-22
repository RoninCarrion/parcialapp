package com.ronin.parcialapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalcularImc : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_calcular_imc)

            val etPeso = findViewById<EditText>(R.id.etPeso)
            val etAltura = findViewById<EditText>(R.id.etAltura)
            val btnCalcular = findViewById<Button>(R.id.btnCalcular)
            val btnRegresar = findViewById<Button>(R.id.btnRegresar)
            val tvResult = findViewById<TextView>(R.id.tvResult)
            val tvStatus = findViewById<TextView>(R.id.tvStatus)

            btnCalcular.setOnClickListener {
                val peso = etPeso.text.toString().toFloatOrNull()
                val altura = etAltura.text.toString().toFloatOrNull()

                if (peso != null && altura != null && altura > 0) {
                    val icm = peso / (altura * altura)
                    tvResult.text = "${icm.toInt()}"
                    tvStatus.text = "Tu IMC es de : ${getIcmStatus(icm)}"
                } else {
                    tvStatus.text = "Por favor, ingresa valores válidos."
                }
            }

            btnRegresar.setOnClickListener {
                finish()
            }
        }

        private fun getIcmStatus(icm: Float): String {
            return when {
                icm < 18.5 -> "BAJO PESO"
                icm < 25 -> "NORMAL"
                icm < 30 -> "SOBREPESO"
                else -> "OBESIDAD"
            }
        }
    }


