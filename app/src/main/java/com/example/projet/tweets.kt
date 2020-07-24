package com.example.projet

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projet.AppExecutors
import com.example.projet.Adapters.TweetAdapter
import com.example.projet.data.Pays
import com.example.projet.data.Tweet
import kotlinx.android.synthetic.main.fragment_tweets.*
import kotlinx.android.synthetic.*
import twitter4j.*
import twitter4j.conf.ConfigurationBuilder


class TweetsFragment() : Fragment() {
    private var countryName = ""
    var tweetList = arrayListOf<Tweet>()
    lateinit var tweetAdapter: TweetAdapter
    lateinit var layoutManager : LinearLayoutManager
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var pays: Pays? =null
        var lay = inflater.inflate(R.layout.fragment_tweets, container, false)
        var list_tweet = lay.findViewById<RecyclerView>(R.id.list_tweet)

        arguments?.let {
            pays=TweetsFragmentArgs.fromBundle(it).pays
        }

        layoutManager = LinearLayoutManager(lay.context)
        list_tweet.layoutManager = layoutManager

        tweetAdapter = TweetAdapter(tweetList)
        list_tweet.adapter = tweetAdapter

        println("init twitter")
        initTwitter()


        countryName = (pays!!.nom).toString()
        return lay
    }

    fun initTwitter(){
        AppExecutors.instance!!.diskIO().execute {
            val consumerKey = "COsOtBhZTEio0Y914UgtrHAth"
            val consumerKeySecret = "3gik38I9zybCZ6vGVF8UtzOwfZVe6sxhXIY2lfheQourp7UJL2"
            val accessToken = "1223554396883124224-rLKldQDAEhKI3mMTTMP9c4Y70Iid4W"
            val accessTokenSecret = "w352GRg5r3mmkVVeECBIPRPisBZq7rsceUgJayhULGj3l"

            val cb = ConfigurationBuilder()
            cb.setDebugEnabled(true)
                .setOAuthConsumerKey(consumerKey)
                .setOAuthConsumerSecret(consumerKeySecret)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessTokenSecret)

            val tf = TwitterFactory(cb.build())
            val twitter = tf.instance

            searchQuery(twitter,countryName)
        }

    }

    fun searchQuery(twitter : Twitter, query : String){
        try {
            val query = Query(query)
            val result: QueryResult
            tweetList.clear()
            query.count = 4
            query.lang = "en"
            result = twitter.search(query)

            for (status in result.tweets) {
                var mediaUrl = ""
                if (status.mediaEntities.isNotEmpty()){
                    mediaUrl = status.mediaEntities[0].mediaURLHttps
                }
                val tweet = Tweet( status.user.originalProfileImageURLHttps, status.user.name, "@"+status.user.screenName,
                    mediaUrl, status.text)
                println("tweet est "+tweet.contenu)
                tweetList.add(tweet)
            }

            AppExecutors.instance!!.mainThread().execute {
                tweetAdapter.notifyDataSetChanged()
            }

        } catch (e: TwitterException) {
            println("l'erreur "+e.errorMessage)
            e.printStackTrace()
        }
    }

}


