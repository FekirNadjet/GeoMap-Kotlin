package com.example.projet.Adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projet.R
import com.example.projet.data.PaysVideo

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


class VideoAdapter( val list : ArrayList<PaysVideo>) : RecyclerView.Adapter<VideoAdapter.PaysVideoViewHolder>(){
    class PaysVideoViewHolder(v : View) : RecyclerView.ViewHolder(v){
        val paysVideo = v.findViewById<YouTubePlayerView>(R.id.youtube_player_view)
        val titleVideo = v.findViewById<TextView>(R.id.videoTitle)
        private val youTubePlayerView: YouTubePlayerView? = null
        private var youTubePlayer: YouTubePlayer? = null
        private var currentVideoId: String = ""

        init {
            paysVideo.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(initializedYouTubePlayer: YouTubePlayer) {
                    youTubePlayer = initializedYouTubePlayer
                    youTubePlayer!!.cueVideo(currentVideoId, 0f)
                }
            })
        }

        fun cueVideo(videoId: String) {
            currentVideoId = videoId
            if (youTubePlayer == null) return
            youTubePlayer!!.cueVideo(videoId, 0f)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaysVideoViewHolder {
        return PaysVideoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.video_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }




    override fun onBindViewHolder(holder: PaysVideoViewHolder, position: Int) {
        val video = list[position]
        holder.titleVideo.text = video.title
        holder.cueVideo(video.idPaysVideo)
    }
}