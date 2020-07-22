package com.example.projet.Adapters

import com.example.projet.data.Ressources

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

class RessourcesAdapter (private val ressources:List<Ressources>): RecyclerView.Adapter<RessourcesAdapter.RessourcesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RessourcesAdapter.RessourcesViewHolder {
        return RessourcesAdapter.RessourcesViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.historique_layout, parent, false)
        )
    }

    override fun getItemCount(): Int =ressources.size

    override fun onBindViewHolder(holder: RessourcesAdapter.RessourcesViewHolder, position: Int) {
        val res = ressources[position]
        holder.view.eventTitle.text =res.nomRessource
        holder.view.evDescription.text =res.description

    }
    class RessourcesViewHolder(val view: View): RecyclerView.ViewHolder(view)

}
