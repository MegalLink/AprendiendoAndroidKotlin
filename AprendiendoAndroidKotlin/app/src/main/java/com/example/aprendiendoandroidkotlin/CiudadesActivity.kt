package com.example.aprendiendoandroidkotlin

import android.content.Intent
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
        val btn_validar_red=findViewById<Button>(R.id.btn_validar_red)
        btn_quito.setOnClickListener {
            Toast.makeText(this,"Ciudad Quito",Toast.LENGTH_LONG).show()
            //crear intent
            val intent= Intent(this,DetalleClimaActivity::class.java)
            //enviar informacion al intent
            intent.putExtra("ciudades_activity_ciudad","Quito")
            //iniciar intent
            startActivity(intent)
        }
        btn_tulcan.setOnClickListener {
            Toast.makeText(this,"Ciudad Tulcan",Toast.LENGTH_LONG).show()
            val intent= Intent(this,DetalleClimaActivity::class.java)
            intent.putExtra("ciudades_activity_ciudad","Tulcan")
            startActivity(intent)
        }
        btn_validar_red.setOnClickListener {
            if(Network.hayRed(this)){
                Toast.makeText(this,"Si hay red",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"No hay conexión a internet",Toast.LENGTH_LONG).show()
            }
        }

    }

    fun irIntent(){

    }
}