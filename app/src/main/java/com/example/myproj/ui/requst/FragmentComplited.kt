package com.example.myproj.ui.requst

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myproj.R
import com.example.myproj.model.Request
import com.example.myproj.util.RequstAdapter

class FragmentComplited : Fragment(), RequstAdapter.OnLanguageListenner {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view:View = inflater.inflate(R.layout.fragment_complited,container, false)
        setupRecyclerView(view)
        return view
    }

    private fun setupRecyclerView(view:View){
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = RequstAdapter(createListData(), this)
        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager=layoutManager
        recyclerView.adapter = adapter

    }

    private fun createListData():MutableList<Request>{
        val list:MutableList<Request> = ArrayList()
        list.add(Request("ул. Проспект Победы дом 19","Sushi White", 670))
        list.add(Request("ул. Жукова дом 26","Kebabster", 890))
        list.add(Request("ул. Пролетарская дом 57","Garris", 1000))
        list.add(Request("ул. Ичкинская дом 11","CFC", 1150))
        list.add(Request("ул. Чкалова дом 67","CFC", 950))
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