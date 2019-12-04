package com.example.gitapiapp_week6_day1.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.example.gitapiapp_week6_day1.R

class RepositoryWeb : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository_web)

        val intent = intent

        val repoWeb = findViewById<WebView>(R.id.repository_webview)

        repoWeb.loadUrl(intent.getStringExtra("url")
        )
    }
}
