package com.example.myproj.ui.accepted

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myproj.R
import com.example.myproj.model.Order
import com.example.myproj.util.ActiveListAdapter

class FragmentActiveList : Fragment(),ActiveListAdapter.OnLanguageListenner {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_list_active,container, false)
        val cancel = view.findViewById<TextView>(R.id.hide)
        setupRecyclerView(view)
        cancel.setOnClickListener {  activity!!.supportFragmentManager.popBackStack()}
        return view
    }
    private fun setupRecyclerView(view:View){
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = ActiveListAdapter(createListData(),this)
        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager=layoutManager
        recyclerView.adapter = adapter

    }
    private fun createListData():MutableList<Order>{
        val list:MutableList<Order> = ArrayList()
        list.add(Order("ул. Маркулова дом 56","Garris", 1340, true))
        list.add(Order("ул. Филотова дом 13","CFC", 760,false))
        list.add(Order("ул. Карла Маркса дом 143","Mcdonalds", 1500,false))
        list.add(Order("ул. Мирашниченко дом 23","Garris", 800,false))
        return list
    }

    override fun myClickListenner() {
        showDialog()
    }
    private fun showDialog(){
        val dialog = Dialog(context!!)
        dialog.setContentView(R.layout.info_dialog)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }
}