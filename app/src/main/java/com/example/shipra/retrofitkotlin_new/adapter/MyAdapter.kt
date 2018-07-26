package com.example.shipra.retrofitkotlin_new.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.shipra.retrofitkotlin_new.R
import com.example.shipra.retrofitkotlin_new.model.model
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_layout.view.*

class MyAdapter(internal var context: Context, internal var modeList: List<model>):RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {

        return modeList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
     Picasso.get().load(modeList[position].thumbnailUrl).into(holder.thumbnail)
        holder.title.text=modeList[position].title
        holder.url.text=modeList[position].url
    }

    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
         var thumbnail:ImageView
         var title :TextView
         var url:TextView

        init{

            thumbnail = itemView.tumbnail
            title= itemView.title
            url=itemView.url
        }

    }


}