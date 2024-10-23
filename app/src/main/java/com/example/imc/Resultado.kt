package com.example.imc

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Resultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        try {
            val imc: Double = intent.getDoubleExtra("imc", 0.0)
            val resultado = when {
                imc < 18.5 -> "Bajo peso"
                imc < 24.9 -> "Peso normal"
                imc < 29.9 -> "Sobrepeso"
                else -> "Obesidad"
            }
            val salida = findViewById<TextView>(R.id.tvResultado)
            salida.text = "Tu IMC es: $imc, lo que significa que tienes: $resultado"
        } catch (e: Exception) {
            Log.e("Error", e.message.toString())
        }

    }
}