package com.example.joshuavaley.ejemplogridviewkt

import android.net.sip.SipSession
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Array list que contiene los elementos del Grid
       var frutas = ArrayList<String>()

        frutas.add("Manzana")
        frutas.add("Plátano")
        frutas.add("Sandía")
        frutas.add("Manzana")

        //Instancia del recurso
        var grid:GridView = findViewById(R.id.grid)

        //Adaptador por defecto
        var adaptador = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, frutas)
        //Asignarle el adaptador
        grid.adapter = adaptador

        //OnClick del grid.
        grid.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
                                        //Obtiene el elemento que es clickado en esa posicion.
            Toast.makeText(this, frutas.get(i), Toast.LENGTH_SHORT).show()
        }



    }
}
