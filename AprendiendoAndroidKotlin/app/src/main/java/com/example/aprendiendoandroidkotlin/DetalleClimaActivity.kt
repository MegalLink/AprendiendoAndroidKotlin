package com.example.aprendiendoandroidkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class DetalleClimaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_clima)
        //recibir informacion de otro intent
        val ciudad_intent=intent.getStringExtra("ciudades_activity_ciudad")
        Toast.makeText(this,"Ciudad "+ciudad_intent,Toast.LENGTH_LONG).show()
        var ciudad=Ciudad("No se encontro ciudad",404,"Presione atras y selecciona una ciudad")
        //Modificar text views
        val tv_ciudad=findViewById<TextView>(R.id.tv_ciudad)
        val tv_clima=findViewById<TextView>(R.id.tv_clima)
        val tv_temperatura=findViewById<TextView>(R.id.tv_temperatura)
        if(ciudad_intent=="Quito"){
            ciudad=Ciudad("Quito",14,"Nublado")

        }else if(ciudad_intent=="Tulcan"){
            ciudad=Ciudad("Tulcán",24,"Soleado")
        }
        tv_ciudad.text=ciudad.nombre
        tv_clima.text=ciudad.clima
        tv_temperatura.text=ciudad.temperatura.toString()+"°"
    }
}