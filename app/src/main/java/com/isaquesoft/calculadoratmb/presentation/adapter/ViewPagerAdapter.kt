package com.isaquesoft.calculadoratmb.presentation.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.isaquesoft.calculadoratmb.presentation.fragment.CalculatorManFragment
import com.isaquesoft.calculadoratmb.presentation.fragment.CalculatorWomenFragment

class ViewPagerAdapter(
    activity: AppCompatActivity,
) : FragmentStateAdapter(activity) {

    private val fragmentList =
        listOf(
            CalculatorManFragment(),
            CalculatorWomenFragment(),
        )

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment = fragmentList[position]
}
