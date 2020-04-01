package com.example.myproj.util

import android.content.Context
import android.content.Intent
import android.view.MenuItem
import com.example.myproj.R
import com.example.myproj.ui.accepted.AcceptedActivity
import com.example.myproj.ui.profil.ProfilActivity
import com.example.myproj.ui.requst.RequstActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx
import java.text.FieldPosition

class BottomNavigationViewExHelper {


    companion object{
         fun setupBottomNavigation(navigation:BottomNavigationViewEx){
            navigation.enableAnimation(false);
            navigation.enableShiftingMode(false);
            navigation.enableItemShiftingMode(false);
            navigation.setTextVisibility(false);
        }
         fun enableButtom(navigation: BottomNavigationViewEx,context:Context, position:Int ){
                navigation.setOnNavigationItemSelectedListener { item ->
                    when(item.itemId){
                        R.id.icon_requst -> {
                                            if(position!=0) {
                                                val intent = Intent(context, RequstActivity::class.java)
                                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                                                context.startActivity(intent)
                                              }
                                            }
                        R.id.icon_activate -> {
                                                if (position != 1) {
                                                    val intent = Intent(context, AcceptedActivity::class.java)
                                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                                                    context.startActivity(intent)
                                                 }
                                                }
                        R.id.ic_profil -> {
                                                if (position != 2) {
                                                    val intent = Intent(context, ProfilActivity::class.java)
                                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                                                    context.startActivity(intent)
                                                }
                                            }
                }
                    false
             }
         }
    }
}