package com.example.gitapiapp_week6_day1.presenter

//import com.example.Repository
import android.util.Log
import com.example.gitapiapp_week6_day1.model.Repository
import com.example.gitapiapp_week6_day1.network.GitFactory
import retrofit2.Call
import retrofit2.Response

class GitPresenter : GitContract.Presenter {

    private val gitFactory = GitFactory()
    private lateinit var view: GitContract.View

    override fun getRepositories() {
        Log.d("tag", "getRepo")
        gitFactory.getRepositories().enqueue(object : retrofit2.Callback<List<Repository>>{
            override fun onResponse(
                call: Call<List<Repository>>,
                response: Response<List<Repository>>
            )
            {
                Log.d("tag", "onResponse")
                response.body()?.let { repositories ->
                    if(repositories.isNotEmpty())
                        view.displayRepositories(repositories)
                    else
                        view.displayError()
                }
            }

            override fun onFailure(call: Call<List<Repository>>, t: Throwable) {
                Log.d("tag", "onFailure ${t.message.toString()}")
                view.displayError()

            }

        })
    }

    override fun setView(view: GitContract.View) {
        this.view = view
    }
}