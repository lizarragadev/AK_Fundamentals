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
import com.miramicodigo.rvycards.model.Pokemon
import com.miramicodigo.rvycards.ui.DetalleActivity

internal class RVAdapter(activity: Activity, private val items: ArrayList<Pokemon>) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    private val context: Context

    init {
        this.context = activity
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_item_grid, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tf_black = Typeface.createFromAsset(context.assets, "fonts/roboto_black.ttf")
        val tf_thin = Typeface.createFromAsset(context.assets, "fonts/roboto_thin.ttf")

        holder.tvTitulo.typeface = tf_black
        holder.tvSubtitulo.typeface = tf_thin

        val poke = items[position]
        holder.tvTitulo.text = poke.titulo
        holder.tvSubtitulo.text = poke.subTitulo
        holder.ivImagen.setImageResource(poke.imagen)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitulo: TextView
        val tvSubtitulo: TextView
        val ivImagen: ImageView

        init {
            tvTitulo = itemView.findViewById(R.id.tvTitulo) as TextView
            tvSubtitulo = itemView.findViewById(R.id.tvSubtitulo) as TextView
            ivImagen = itemView.findViewById(R.id.ivImagen) as ImageView

            itemView.setOnClickListener {
                val intent = Intent(context, DetalleActivity::class.java)
                intent.putExtra("poke", items[adapterPosition])
                context.startActivity(intent)
            }
        }
    }
}
