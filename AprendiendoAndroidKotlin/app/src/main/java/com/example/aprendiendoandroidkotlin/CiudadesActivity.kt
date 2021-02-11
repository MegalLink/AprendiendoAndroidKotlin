package com.example.aprendiendoandroidkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class CiudadesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)

        //Intent explicito = declaramos en la aplicacion que debe ser llamado
        //Intent implicito = No se sabe que componente se va a llamar por ejemplo para compartir algo se abre facebook , whatsapp etc+
        val btn_quito=findViewById<Button>(R.id.btn_quito)
        val btn_tulcan=findViewById<Button>(R.id.btn_tulcan)

        btn_quito.setOnClickListener {
            Toast.makeText(this,"Ciudad Quito",Toast.LENGTH_LONG).show()
        }
        btn_tulcan.setOnClickListener {
            Toast.makeText(this,"Ciudad Tulcan",Toast.LENGTH_LONG).show()
        }
    }

    fun irIntent(){

    }
}