package com.example.snug.activities


import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.sample.fragments.adapters.ViewPagerAdapter
import com.example.snug.R
import com.example.snug.fragments.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SimpleDialogFragment.SimpleDialogListener {

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
        }

        load.setOnClickListener {
            when (val currentFragment = adapter.getItem(viewPager.currentItem)) {
                is FirstFragment -> {
                    currentFragment.load()
                }
                is SecondFragment -> {
                    currentFragment.load()
                }
            }
        }
    }

    override fun onDialogPositiveClick(dialog: DialogFragment) {
        when (val currentFragment = adapter.getItem(viewPager.currentItem)) {
            is FirstFragment -> {
                currentFragment.save()
            }
            is SecondFragment -> {
                currentFragment.save()
            }
        }
    }

    override fun onDialogNegativeClick(dialog: DialogFragment) {
        Toast.makeText(applicationContext, "キャンセルが押されました", Toast.LENGTH_LONG).show()

    }
}

