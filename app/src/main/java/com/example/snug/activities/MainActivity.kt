package com.example.snug.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.sample.fragments.adapters.ViewPagerAdapter
import com.example.snug.R
import com.example.snug.fragments.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_third.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpTabs()
        setButtons()
    }

    private fun setUpTabs() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(FirstFragment(), "ユーザー情報")
        adapter.addFragment(SecondFragment(), "好きな動物")
        adapter.addFragment(ThirdFragment(), "WebView")
        adapter.addFragment(FourthFragment(), "ローカルhtml")

        viewPager.adapter = adapter
        this.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }

    private fun setButtons() {
        save.setOnClickListener {
            val dialog = SimpleDialogFragment()
            dialog.show(supportFragmentManager, "simple")

            val currentFragment = adapter.getItem(viewPager.currentItem)
            when (currentFragment) {
                is FirstFragment -> {
                    currentFragment.save()
                }
                is SecondFragment -> {
                    currentFragment.save()
                }
            }
        }

        load.setOnClickListener {
            val currentFragment = adapter.getItem(viewPager.currentItem)
            when (currentFragment) {
                is FirstFragment -> {
                    currentFragment.load()
                }
                is SecondFragment -> {
                    currentFragment.load()
                }
            }
        }
    }
}
