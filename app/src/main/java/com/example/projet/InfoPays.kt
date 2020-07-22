package com.example.projet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.projet.Adapters.HistoriqueAdapter
import com.example.projet.Adapters.PaysAdapters
import com.example.projet.Adapters.RessourcesAdapter
import com.example.projet.data.Pays
import kotlinx.android.synthetic.main.fragment_detail_pays.*
import kotlinx.android.synthetic.main.fragment_info_pays.*
import kotlinx.android.synthetic.main.fragment_liste_pays.*
import kotlinx.coroutines.launch

class InfoPays : BaseFragment() {
    private var pays: Pays? =null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info_pays, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        arguments?.let {
            pays=InfoPaysArgs.fromBundle(it).pays
        }
        drapeauPays.setImageResource(pays!!.drapeau)
        nomPays.text=pays!!.nom
        capitalPays.text=pays!!.capital
        var slide1=pays!!.  images
        for(img in slide1) {
            val view = ImageView(this.context)
            view.setImageResource(img)
            images.addView(view)
            images.setFlipInterval(2000)
            images.setInAnimation(
                this.context,
                android.R.anim.slide_in_left
            )
            images.setOutAnimation(this.context,android.R.anim.slide_out_right)
        }
        description.text=pays!!.description
        surface.text= pays!!.surface.toString()
        population.text= pays!!.population.toString()

        launch {
            context?.let {
                list_Historique.adapter= HistoriqueAdapter(pays!!.historique)
                list_Ressources.adapter=RessourcesAdapter(pays!!.ressources)
            }
        }

    }

}