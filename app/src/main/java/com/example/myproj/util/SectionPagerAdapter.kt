package com.example.myproj.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.myproj.ui.requst.FragmentComplited
import com.example.myproj.ui.requst.FragmentFree


class SectionPagerAdapter ( val  fm: FragmentManager): FragmentPagerAdapter(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {


    override fun getItem(position: Int): Fragment {
        lateinit  var fragment:Fragment
        when(position){
            0 -> fragment = FragmentFree()
            1 -> fragment = FragmentComplited()
        }
        return fragment
    }

    override fun getCount(): Int {
       return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
           when(position){
            0 -> return "Свободные"
            1 -> return "Выполненые"
        }
        return  ""
    }
}