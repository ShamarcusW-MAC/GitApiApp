package com.example.gitapiapp_week6_day1.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gitapiapp_week6_day1.R
import com.example.gitapiapp_week6_day1.view.RepositoryInfoActivity
import com.example.gitapiapp_week6_day1.model.Repository

class RepositoryAdapter(val repositoryList: List<Repository>):
    RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.repository_item_layout, parent, false)


        return RepositoryViewHolder(view)

    }

    override fun getItemCount(): Int {
        return repositoryList.size
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {

        holder.repoName.text = repositoryList[position].name


        holder.repoName.setOnClickListener {
            val intent = Intent(it.context, RepositoryInfoActivity::class.java)
            intent.putExtra("name", repositoryList[position].name)
            intent.putExtra("url", repositoryList[position].htmlUrl)
            intent.putExtra("avatar", repositoryList[position].owner.avatarUrl)
            it.context.startActivity(intent)
        }
        Glide.with(holder.itemView.context)
            .load(repositoryList[position].owner.avatarUrl)
            .into(holder.repoAvatar)



    }


    inner class RepositoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val repoAvatar: ImageView = itemView.findViewById(R.id.avatar_imageview)
        val repoName: TextView = itemView.findViewById(R.id.repository_textview)


    }
}