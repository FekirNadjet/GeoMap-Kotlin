package com.example.projet

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.MediaController
import android.widget.Toast
import android.widget.ViewFlipper
import androidx.appcompat.app.AppCompatActivity
import com.example.projet.R.id.slide
import kotlinx.android.synthetic.main.fragment_detail_pays.*


class DetailPays : Fragment() {
    lateinit var viewflipper :ViewFlipper

    val pays= listOf<String>("Algérie","Suède","Norvège","Australie")
    val drap= intArrayOf(R.drawable.algerie_drapeau,R.drawable.suede_drapeau,R.drawable.norvege_drapeau,R.drawable.australie_drapeau)
    val slide1=intArrayOf(R.drawable.algerie1,R.drawable.algerie2,R.drawable.algerie3,R.drawable.algerie4)
    val video= intArrayOf(R.raw.algerievideo,R.raw.suedevideo,R.raw.norvege,R.raw.australievideo)
    val audios= intArrayOf(R.raw.algerie,R.raw.suede,R.raw.norvege,R.raw.australie)

    private var paysi:Int? = null
    var mediaController: MediaController?=null
    var player:MediaPlayer?=null

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,

        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_pays, container, false)
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)

        arguments?.let {
            paysi=DetailPaysArgs.fromBundle(it).pays
        }
        (activity as AppCompatActivity).supportActionBar?.title = pays[paysi!!]

        if (mediaController==null){
            mediaController=MediaController(context)
        }
        if (mediaController==null){
            mediaController=MediaController(context)
        }
        play.setOnClickListener{
            if (player==null){
                player=MediaPlayer.create(context,audios[paysi!!])
            }
            player?.start()
        }
        pause.setOnClickListener {
            if (player!=null){
                player?.pause()
            }
        }
        stop.setOnClickListener {

            if (player!=null) {
                player?.release()
                player= null
                Toast.makeText(context,"Media Player released",Toast.LENGTH_SHORT).show()
            }
        }

        //var nomTab="image"+paysi
        drapeau.setImageResource(drap[paysi!!])


        videoView.setMediaController(mediaController)
        videoView.setVideoURI(Uri.parse("android.resource://" + getActivity()?.getPackageName() + "/raw/" + video[paysi!!]))
        videoView.start()

        for(img in slide1) {
            val view = ImageView(this.context)
            view.setImageResource(img)
            slide.addView(view)
            slide.setFlipInterval(2000)
            slide.setInAnimation(
                this.context,
                android.R.anim.slide_in_left
            )
            slide.setOutAnimation(this.context,android.R.anim.slide_out_right)
        }

        //nompays.setText(pays[paysi!!])


    }
}
