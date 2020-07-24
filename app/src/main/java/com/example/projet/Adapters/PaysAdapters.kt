




package com.example.projet.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.projet.R
import com.example.projet.data.Pays
import com.example.projet.listePaysDirections
import kotlinx.android.synthetic.main.fragment_info_pays.view.*
import kotlinx.android.synthetic.main.item_layout.view.*

class PaysAdapters (private val pays:List<Pays>): RecyclerView.Adapter<PaysAdapters.PaysViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaysAdapters.PaysViewHolder {
        return PaysAdapters.PaysViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout, parent, false)
        )
    }

    override fun getItemCount(): Int =pays.size

    override fun onBindViewHolder(holder: PaysAdapters.PaysViewHolder, position: Int) {
        val pays = pays[position]
        holder.view.countryTitleView.text =pays.nom
        holder.view.countryCapitalView.text =pays.capital
        holder.view.countryFlagView.setImageResource(pays.drapeau)
        holder.view.arrowView.setOnClickListener{
//            val action=listePaysDirections.actionVideo()
//            Navigation.findNavController(it).navigate(action)
//            val action=listePaysDirections.infoPays()
//            action.pays=pays
//            Navigation.findNavController(it).navigate(action)

            val action=listePaysDirections.infoPays()
            action.pays=pays
            Navigation.findNavController(it).navigate(action)


        }

    }
    class PaysViewHolder(val view: View): RecyclerView.ViewHolder(view)

}
