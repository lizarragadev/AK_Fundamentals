package com.miramicodigo.rvycards.adapter

import android.content.Intent
import android.widget.TextView
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.ViewGroup
import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.miramicodigo.rvycards.R
import com.miramicodigo.rvycards.ui.DetalleActivity

internal class RVAdapter(activity: Activity, private val items: ArrayList<Any>) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    private val context: Context

    init {
        this.context = activity
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return null!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}
