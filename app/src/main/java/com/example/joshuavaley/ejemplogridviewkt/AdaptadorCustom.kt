package com.example.joshuavaley.ejemplogridviewkt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
//Paso #1 Estender de BaseAdapter
//Paso #2 Agregar los parametros del constructor.
//Paso #3 Implementar los metodos de la clase BaseAdapter
class AdaptadorCustom(var context: Context, items:ArrayList<Fruta>):BaseAdapter() {

    //Paso #4 iniciar el arraylist de tipo de la clase.
   var items:ArrayList<Fruta>? = null
    //Paso #5 Disparar el constructor
    init {
        this.items = items
    }

    //Paso#10
    override fun getView(p0: Int, ConvertView: View?, p2: ViewGroup?): View {

        //Paso#11 Instanciar la vista y el objeto holder.
        var view:View? = ConvertView
        var holder:ViewHolder? = null

        //Paso#12 Validar que el grid tenga espacio reservado en memoria.
        //Si la celda no posee contenido.
        if (view == null)
        {
            //Inflar la vista
            view = LayoutInflater.from(context).inflate(R.layout.template_grid, null)//associamos la vista.
           // Pasarle la vista al holder
            holder = ViewHolder(view)
            //Crear el tag de la vista
            view.tag = holder
        }
        else
        {   // pasarle el tag al holder y castearlo como ViewHolder
            holder = view.tag as? ViewHolder
        }

        //Paso#13 Inicializar los recursos de la vista.
        val item = items?.get(p0) /*as? Fruta*/
        holder?.nombre_fruta?.text = item?.nombre_fruta
        holder?.img_fruta?.setImageResource(item?.img_fruta!!)

        return view!!

    }
    
    //Paso#9
    override fun getItem(p0: Int): Any {
        return items?.get(p0)!!
    }

    //Paso#8
    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    //Paso#7
    override fun getCount(): Int {
        return items?.count()!!
    }

    //Paso #6 Crear la Clase viewHolder para instanciar las vistas del template del grid.
    private  class ViewHolder(view: View){
        var img_fruta:ImageView? = null
        var nombre_fruta:TextView? = null

        init {
            img_fruta = view.findViewById(R.id.imgFruta)
            nombre_fruta = view.findViewById(R.id.textFruta)
        }


    }

}