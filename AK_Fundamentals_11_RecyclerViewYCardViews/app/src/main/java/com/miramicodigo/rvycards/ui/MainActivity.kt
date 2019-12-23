package com.miramicodigo.rvycards.ui

import android.os.Bundle
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.miramicodigo.rvycards.R
import com.miramicodigo.rvycards.adapter.RVAdapter
import com.miramicodigo.rvycards.model.Pokemon
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var datos: ArrayList<Pokemon>
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var adaptador: RecyclerView.Adapter<*>
    lateinit var activity: Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        //layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        //layoutManager = GridLayoutManager(this, 3)
        layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rvContenido.layoutManager = layoutManager
        llenarPokemones()
        adaptador = RVAdapter(this, datos)
        rvContenido.adapter = adaptador

    }

    fun llenarPokemones() {
        datos = ArrayList()
        val arrayTitulos = resources.getStringArray(R.array.titulos)
        val arraySubtitulos = resources.getStringArray(R.array.subtitulos)
        val arrayImagenes = resources.obtainTypedArray(R.array.imagenes)

        for (i in arrayTitulos.indices) {
            val poke = Pokemon(
                arrayTitulos[i],
                arraySubtitulos[i],
                arrayImagenes.getResourceId(i, -1)
            )
            datos.add(poke)
        }
    }

}
