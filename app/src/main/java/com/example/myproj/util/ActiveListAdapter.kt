package com.example.myproj.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myproj.R
import com.example.myproj.model.Order


class ActiveListAdapter(var list:MutableList<Order>, val listenner: ActiveListAdapter.OnLanguageListenner): RecyclerView.Adapter<ActiveListAdapter.ActiveHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActiveHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view:View =layoutInflater.inflate(R.layout.order_active_item, parent, false)
        return ActiveHolder(view,listenner)
    }

    override fun getItemCount(): Int {
      return list.size
    }

    override fun onBindViewHolder(holder: ActiveHolder, position: Int) {
        holder.price.setText(list.get(position).price.toString())
        holder.addres.setText(list.get(position).addres)
        holder.title.setText(list.get(position).title)
        if(list.get(position).check==true){
            holder.imgAccept.visibility = View.VISIBLE
        }else{
            holder.imgAccept.visibility = View.INVISIBLE
        }
    }


    inner class ActiveHolder(itemView: View, listenner: ActiveListAdapter.OnLanguageListenner):RecyclerView.ViewHolder(itemView), View.OnClickListener{
        var imgAccept: ImageView
        var addres: TextView
        var title:TextView
        var price:TextView
        var listenner: OnLanguageListenner
        init {
            val view = itemView
            price = view.findViewById(R.id.price)
            imgAccept = view.findViewById(R.id.accept_order)
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



