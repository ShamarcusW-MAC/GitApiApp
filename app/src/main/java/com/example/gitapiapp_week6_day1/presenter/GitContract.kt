package com.example.gitapiapp_week6_day1.presenter

//import com.example.Repository
import com.example.gitapiapp_week6_day1.model.Repository

interface GitContract {

    interface Presenter{

        fun getRepositories()

        fun setView(view: GitContract.View)
    }

    interface View{

        fun displayRepositories(repositories: List<Repository>)
        fun displayError()
    }

}

