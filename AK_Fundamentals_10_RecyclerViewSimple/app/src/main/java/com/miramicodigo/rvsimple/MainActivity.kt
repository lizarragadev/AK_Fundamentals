package com.miramicodigo.rvsimple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvDatos.layoutManager = LinearLayoutManager(this)
        val listaDatos = llenarDatos()
        val adaptador = RecyclerViewAdapter(listaDatos)
        rvDatos.adapter = adaptador
    }

    fun llenarDatos(): ArrayList<String> {
        var datos = ArrayList<String>()
        for(i in 0..500) {
            datos.add("Item en posicion ${i + 1}")
        }
        return datos
    }

    inner class RecyclerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvTexto = itemView as TextView

        init {
            itemView.setOnClickListener {
                Toast.makeText(applicationContext, "Click en ${adapterPosition + 1}", Toast.LENGTH_LONG).show()
            }
        }
    }

    inner class RecyclerViewAdapter(val data: ArrayList<String>) : RecyclerView.Adapter<RecyclerViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
            val layoutInflater = LayoutInflater.from(applicationContext)
            val view = layoutInflater.inflate(android.R.layout.simple_list_item_1, parent, false)
            return RecyclerViewHolder(view)
        }

        override fun getItemCount(): Int {
            return data.size
        }

        override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
            val dato = data[position]
            holder.tvTexto.text = dato
        }

    }

}
