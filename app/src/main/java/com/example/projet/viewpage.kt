package com.example.projet

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.fragment_viewpage.*

class viewpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_viewpage)

        val pagerAdapter = CountryPagesAdapter(this,supportFragmentManager, 2)
        mPager.adapter = pagerAdapter

        tabLayout.setupWithViewPager(mPager)
    }

    class CountryPagesAdapter(private val myContext: Context, fm: FragmentManager, internal var totalTabs: Int) :
        FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT ) {

        // this is for fragment tabs
        override fun getItem(position: Int): Fragment {
            when (position) {
                0 -> {
                    return InfoPays()
                }
                1 -> {
                    return VideosFragment()
                }

                else -> return InfoPays()
            }
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return when (position) {
                0 -> {
                    "Pays"
                }
                1 -> {
                    "Videos"
                }
                2 -> {
                    "Tweets"
                }
                else -> "Information du pays"
            }
        }



        // this counts total number of tabs
        override fun getCount(): Int {
            return totalTabs
        }
    }

}