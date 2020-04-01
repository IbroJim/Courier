package com.example.myproj.ui.accepted

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.myproj.R
import com.example.myproj.util.BottomNavigationViewExHelper
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx

class AcceptedActivity : AppCompatActivity() {

    private val ACTIVITY_NUM = 1
    private var fragmentActiveList: FragmentActiveList?= null
    private lateinit var fm: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accepted)
        setupBottomNavigationView()
        openActiveList()
    }

    private fun setupBottomNavigationView() {
        val bottomNavigationViewEx = findViewById<View>(R.id.bottom_navigation_view_ex) as BottomNavigationViewEx
        BottomNavigationViewExHelper.setupBottomNavigation(bottomNavigationViewEx)
        BottomNavigationViewExHelper.enableButtom(bottomNavigationViewEx,this, ACTIVITY_NUM)
        val menu = bottomNavigationViewEx.menu
        val menuItem = menu.getItem(ACTIVITY_NUM)
        menuItem.isChecked = true
    }

    private fun openActiveList(){
        val img = findViewById<ImageView>(R.id.open_list)
        img.setOnClickListener {
            if(fragmentActiveList !=null ){
                fm.beginTransaction().remove(fragmentActiveList!!).commit()
            }
            fragmentActiveList = FragmentActiveList()
            fm = supportFragmentManager
            fm.beginTransaction().setCustomAnimations(
                R.anim.enter_right_to_left,
                R.anim.exit_right_to_left,
                R.anim.enter_right_to_left,
                R.anim.exit_right_to_left
            ).replace(R.id.fragmentContainer, fragmentActiveList!!).addToBackStack(null).commit()
        }
        }
    }
