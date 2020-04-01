package com.example.myproj.ui.profil

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myproj.R
import com.example.myproj.util.BottomNavigationViewExHelper
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx

class ProfilActivity : AppCompatActivity(){

    private val ACTIVITY_NUM = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)
        setupBottomNavigationView()

    }
    private fun setupBottomNavigationView() {
        val bottomNavigationViewEx = findViewById<View>(R.id.bottom_navigation_view_ex) as BottomNavigationViewEx
        BottomNavigationViewExHelper.setupBottomNavigation(bottomNavigationViewEx)
        BottomNavigationViewExHelper.enableButtom(bottomNavigationViewEx,this, ACTIVITY_NUM)
        val menu = bottomNavigationViewEx.menu
        val menuItem = menu.getItem(ACTIVITY_NUM)
        menuItem.isChecked = true
    }
}