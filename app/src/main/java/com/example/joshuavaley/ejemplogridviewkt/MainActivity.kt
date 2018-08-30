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

        /*Array list que contiene los elementos del Grid
        Primero como adaptador simple
       var frutas = ArrayList<String>()*/

        //Array List que contiene los elementos del grid.
        var frutas = ArrayList<Fruta>()

        /* Declaracion de objetos para simpleAdapter.
        frutas.add("Manzana")
        frutas.add("Plátano")
        frutas.add("Sandía")
        frutas.add("Durazno")
        */

        frutas.add(Fruta("Manzana", R.drawable.manzana))
        frutas.add(Fruta("Platano", R.drawable.platano))
        frutas.add(Fruta("Sandia", R.drawable.sandia))
        frutas.add(Fruta("Durazno", R.drawable.durazno))

        //Instancia del recurso
        var grid:GridView = findViewById(R.id.grid)

        //Adaptador por defecto
       // var adaptador = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, frutas)

        //Adaptador personalizado.
        var adaptador = AdaptadorCustom(this, frutas)

        //Asignarle el adaptador
        grid.adapter = adaptador

        //OnClick del grid.
        grid.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
                                        //Obtiene el elemento que es clickado en esa posicion.
            Toast.makeText(this, frutas.get(i).nombre_fruta, Toast.LENGTH_SHORT).show()
        }



    }
}
