package com.miramicodigo.rvycards.ui

import android.os.Bundle
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.miramicodigo.rvycards.R
import com.miramicodigo.rvycards.adapter.RVAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var datos: ArrayList<Any>
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var adaptador: RecyclerView.Adapter<*>
    lateinit var activity: Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun llenarPokemones() {


    }

}
