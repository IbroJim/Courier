package com.example.myproj.ui.requst

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.myproj.R
import com.example.myproj.util.BottomNavigationViewExHelper
import com.example.myproj.util.SectionPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx

class RequstActivity : AppCompatActivity(){


     private val ACTIVITY_NUM = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request)
        setupBottomNavigationView()
        setupViewPager()
    }

    private fun setupBottomNavigationView() {
        val bottomNavigationViewEx = findViewById<View>(R.id.bottom_navigation_view_ex) as BottomNavigationViewEx
        BottomNavigationViewExHelper.setupBottomNavigation(bottomNavigationViewEx)
        BottomNavigationViewExHelper.enableButtom(bottomNavigationViewEx,this, ACTIVITY_NUM)
        val menu = bottomNavigationViewEx.menu
        val menuItem = menu.getItem(ACTIVITY_NUM)
        menuItem.isChecked = true
    }

    private fun setupViewPager(){
        val tabLayout:TabLayout = findViewById(R.id.tab_layout)
        val viewPager: ViewPager  = findViewById(R.id.view_pager)
        val adapater = SectionPagerAdapter(supportFragmentManager)
        viewPager.adapter = adapater
        tabLayout.setupWithViewPager(viewPager)
    }



}