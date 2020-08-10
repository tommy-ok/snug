package com.example.snug.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import com.example.snug.R

class FourthFragment: androidx.fragment.app.Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_fourth, container, false)

        val myWebView: WebView = view.findViewById(R.id.family)

        myWebView.settings.javaScriptEnabled = true

        myWebView.loadUrl("file://android_assets/index.html")

        return view
    }
}