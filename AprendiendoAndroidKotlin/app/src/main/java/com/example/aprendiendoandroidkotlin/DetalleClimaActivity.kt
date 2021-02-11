package com.example.aprendiendoandroidkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class DetalleClimaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_clima)
        //recibir informacion de otro intent
        val ciudad=intent.getStringExtra("ciudades_activity_ciudad")
        Toast.makeText(this,"Ciudad "+ciudad,Toast.LENGTH_LONG).show()
    }
}