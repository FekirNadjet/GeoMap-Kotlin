package com.example.projet

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.example.geomob.Other.RequestHandler

import com.example.projet.Adapters.VideoAdapter
import com.example.projet.data.Pays
import com.example.projet.data.PaysVideo

import kotlinx.android.synthetic.main.fragment_videos.*

class VideosFragment : Fragment() {
    private var pays: Pays? =null

    private var countryCode = ""
    private var countryName = ""
    var videoList = arrayListOf<PaysVideo>()

    lateinit var videoAdapter: VideoAdapter
    lateinit var layoutManager : LinearLayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            pays=VideosFragmentArgs.fromBundle(it).pays
        }
        countryCode = "DZ"
        countryName = "algeria"

        recyclerView.setHasFixedSize(true)

        layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager

        videoAdapter = VideoAdapter(videoList)
        recyclerView.adapter = videoAdapter


        val videoUrl = "https://www.googleapis.com/youtube/v3/search?key=AIzaSyBAZcxVrHs8w3EHcxlaE2H1ahtGxnzR-_E&q=$countryName&maxResults=4&type=video&safeSearch=strict&part=snippet"
        val jsonRequestVideos = JsonObjectRequest(
            Request.Method.GET, videoUrl, null,
            Response.Listener { response ->
                videoList.clear()
                val items = response.getJSONArray("items")
                for (i in 0 until items.length()){
                    val video = items.getJSONObject(i)
                    val id = video.getJSONObject("id").getString("videoId")
                    val title = video.getJSONObject("snippet").getString("title")
                    videoList.add(PaysVideo(id, title, countryCode))
                }
                videoAdapter.notifyDataSetChanged()
            },
            Response.ErrorListener {
                Log.d("Error", "Request error")

            })

        RequestHandler.getInstance(requireActivity()).addToRequestQueue(jsonRequestVideos)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_videos, container, false)
    }
}
