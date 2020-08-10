package com.example.snug.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import com.example.snug.R


class ThirdFragment : Fragment() {

    override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.fragment_third, container, false)
        val mWebView = v.findViewById<View>(R.id.webView) as WebView
        mWebView.loadUrl("https://developer.android.com/")
    // Inflate the layout for this fragment
    return v
    }
}

