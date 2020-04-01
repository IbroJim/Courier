package com.example.myproj.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myproj.R
import com.example.myproj.model.Request

class RequstAdapter(var list:MutableList<Request>, val listenner: OnLanguageListenner): RecyclerView.Adapter<RequstAdapter.RequstHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RequstHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view:View =layoutInflater.inflate(R.layout.order_item, parent, false)
        return RequstHolder(view,listenner)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RequstHolder, position: Int) {
        holder.price.setText(list.get(position).price.toString())
        holder.addres.setText(list.get(position).addres)
        holder.title.setText(list.get(position).title)
    }

    inner class RequstHolder(itemView: View, listenner: OnLanguageListenner):RecyclerView.ViewHolder(itemView), View.OnClickListener{
        var imgInfo: ImageView
        var addres: TextView
        var title:TextView
        var price:TextView
        var listenner: OnLanguageListenner
        init {
            val view = itemView
            price = view.findViewById(R.id.price)
            imgInfo = view.findViewById(R.id.info)
            addres=view.findViewById(R.id.addres)
            title =view.findViewById(R.id.title)
            this.listenner = listenner
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            listenner.myClickListenner()
        }

    }
    interface OnLanguageListenner{
        fun myClickListenner()
    }
}