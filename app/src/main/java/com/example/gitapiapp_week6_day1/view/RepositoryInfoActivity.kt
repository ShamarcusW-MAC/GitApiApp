package com.example.gitapiapp_week6_day1.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.webkit.WebView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.gitapiapp_week6_day1.R
//import com.example.myapiapp.R
import kotlinx.android.synthetic.main.repository_item_layout.*

class RepositoryInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository_info)
        val intent = intent
//        intent.getStringExtra("name")
        val repoName = findViewById<TextView>(R.id.repo_name_textview)
        val repoUrl = findViewById<TextView>(R.id.repo_url_textview)

//        val repoUrl = findViewById<WebView>(R.id.repo_url_textview)

        val avatarUrl: String = intent.getStringExtra("avatar")
        repoName.text = intent.getStringExtra("name")
        repoUrl.text = intent.getStringExtra("url")
//        repoUrl.loadUrl(intent.getStringExtra("url"))

        repoUrl.setOnClickListener {
            val intent = Intent(this, RepositoryWeb::class.java)
            intent.putExtra("url",repoUrl.text.toString())
            startActivity(intent)
        }
//        repoUrl.movementMethod(LinkMovementMethod.getInstance())

        Glide.with(this)
            .load(avatarUrl)
            .into(avatar_imageview)

    }
}


