package com.example.gitapiapp_week6_day1.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gitapiapp_week6_day1.R
import com.example.gitapiapp_week6_day1.adapter.RepositoryAdapter
import com.example.gitapiapp_week6_day1.model.Owner
import com.example.gitapiapp_week6_day1.model.Repository
import com.example.gitapiapp_week6_day1.presenter.GitContract
import com.example.gitapiapp_week6_day1.presenter.GitPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), GitContract.View {

    private lateinit var gitPresenter: GitPresenter


    private lateinit var owner: Owner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gitPresenter = GitPresenter()
        gitPresenter.setView(this)
        gitPresenter.getRepositories()

    }

    override fun displayRepositories(repositories: List<Repository>) {
        Log.d("tag", "dpr")

        username_textview.text = repositories[0].owner.login + " 's Repositories"
        val adapter = RepositoryAdapter(repositories)
        repository_recyclerview.adapter = adapter
        val linear = LinearLayoutManager(this)
        repository_recyclerview.layoutManager = linear

        Toast.makeText(this, repositories.size.toString(), Toast.LENGTH_SHORT).show()
    }

    override fun displayError() {
        Log.d("tag", "de")
        Toast.makeText(this, "Failed to retrieve", Toast.LENGTH_SHORT).show()
    }
}
