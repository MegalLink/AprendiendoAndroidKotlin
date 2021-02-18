package com.example.aprendiendoandroidkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import android.widget.Button
import android.widget.Toast
//Volley
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
//fuel
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result


import java.lang.Exception


class CiudadesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)

        //Intent explicito = declaramos en la aplicacion que debe ser llamado
        //Intent implicito = No se sabe que componente se va a llamar por ejemplo para compartir algo se abre facebook , whatsapp etc+
        val btn_quito=findViewById<Button>(R.id.btn_quito)
        val btn_tulcan=findViewById<Button>(R.id.btn_tulcan)
        val btn_get_volley=findViewById<Button>(R.id.btn_get_volley)
        val btn_get_fuel=findViewById<Button>(R.id.btn_get_fuel)
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

        btn_get_volley.setOnClickListener {
            if(Network.hayRed(this)){
                solicitudHttpVolley("https://jsonplaceholder.typicode.com/users")

            }else{
                Toast.makeText(this,"No hay conexión a internet",Toast.LENGTH_LONG).show()
            }
        }
        btn_get_fuel.setOnClickListener {
            if(Network.hayRed(this)){
                solicitudHttpFuel("https://jsonplaceholder.typicode.com/users")
            }else{
                Toast.makeText(this,"No hay conexión a internet",Toast.LENGTH_LONG).show()
            }
        }


    }

    private fun solicitudHttpVolley(url:String){
        //Funciona en forma de stack como una cola de peticiones y administra multiples solicitudes a la vez
        val cola=Volley.newRequestQueue(this)
        val solicitud=StringRequest(Request.Method.GET,url, Response.Listener<String> {
            response ->
            try {
                Log.i("PeticionVolley",response)
            }catch (e:Exception){

            }

        },Response.ErrorListener {  })
            cola.add(solicitud)
    }
    private fun solicitudHttpFuel(url:String){
        val httpAsync = url
                .httpGet()
                .responseString { request, response, result ->
                    when (result) {
                        is Result.Failure -> {
                            val ex = result.getException()
                            Log.i("PeticionFuel","Error en la peticion")
                        }
                        is Result.Success -> {
                            val data = result.get()
                            Log.i("PeticionFuel",data)
                        }
                    }
                }

        httpAsync.join()
    }

}