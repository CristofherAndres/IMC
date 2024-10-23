package com.example.imc

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        //Boton para calcular el IMC
        val calcular: Button = findViewById(R.id.btnCalcular)
        calcular.setOnClickListener {
            calcularIMC()
        }



    }

    private fun calcularIMC() {
        try {
            //Calcular el imc
            val peso: Double = findViewById<EditText>(R.id.etPeso).text.toString().toDouble()
            val altura: Double = findViewById<EditText>(R.id.etAltura).text.toString().toDouble()
            val imc: Double = peso / (altura * altura)
            Toast.makeText(this, "Tu IMC es: $imc", Toast.LENGTH_LONG).show()
            val intent: Intent = Intent(this, Resultado::class.java)
            intent.putExtra("imc", imc)
            startActivity(intent)

        } catch (e: Exception) {
            Log.e("Error", e.message.toString())
        }
    }
}