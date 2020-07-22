package com.example.projet.Adapters

import com.example.projet.data.Historique


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.projet.R
import com.example.projet.data.Pays
import com.example.projet.listePaysDirections
import kotlinx.android.synthetic.main.historique_layout.view.*
import kotlinx.android.synthetic.main.item_layout.view.*

class HistoriqueAdapter (private val events:List<Historique>): RecyclerView.Adapter<HistoriqueAdapter.HistoireViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoriqueAdapter.HistoireViewHolder {
        return HistoriqueAdapter.HistoireViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.historique_layout, parent, false)
        )
    }

    override fun getItemCount(): Int =events.size

    override fun onBindViewHolder(holder: HistoriqueAdapter.HistoireViewHolder, position: Int) {
        val event = events[position]
        holder.view.eventTitle.text =event.date
        holder.view.evDescription.text =event.description

    }
    class HistoireViewHolder(val view: View): RecyclerView.ViewHolder(view)

}
