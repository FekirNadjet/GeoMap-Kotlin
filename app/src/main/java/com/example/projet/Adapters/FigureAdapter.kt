package com.example.projet.Adapters

import com.example.projet.data.personalities
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.projet.R
import com.example.projet.data.Pays
import com.example.projet.listePaysDirections
import kotlinx.android.synthetic.main.figure_layout.view.*
import kotlinx.android.synthetic.main.historique_layout.view.*
import kotlinx.android.synthetic.main.item_layout.view.*

class FigureAdapter (private val figures:List<personalities>): RecyclerView.Adapter<FigureAdapter.FigureViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FigureAdapter.FigureViewHolder {
        return FigureAdapter.FigureViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.figure_layout, parent, false)
        )
    }

    override fun getItemCount(): Int =figures.size

    override fun onBindViewHolder(holder: FigureAdapter.FigureViewHolder, position: Int) {
        val figure = figures[position]
        holder.view.FigureName.text =figure.nom
        holder.view.FigurePic.setImageResource(figure.photo)

    }
    class FigureViewHolder(val view: View): RecyclerView.ViewHolder(view)

}