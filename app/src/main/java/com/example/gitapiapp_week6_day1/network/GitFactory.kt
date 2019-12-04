package com.example.gitapiapp_week6_day1.network

import com.example.gitapiapp_week6_day1.model.Repository
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GitFactory {

    private val BASE_URL = "https://api.github.com"

    private var gitService: GitService

    init {
        gitService = createService(getRetroFitInstance())

    }

    private fun getRetroFitInstance() : Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun createService(retrofit: Retrofit): GitService{
        return retrofit.create(GitService::class.java)
    }

    fun getRepositories(/*TODO make this dynamic*/): Call<List<Repository>> {
        return gitService.getUsers("ShamarcusW-MAC", "repos")
    }

}