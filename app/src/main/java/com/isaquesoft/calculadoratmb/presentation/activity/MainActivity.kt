package com.isaquesoft.calculadoratmb.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.isaquesoft.calculadoratmb.R
import com.isaquesoft.calculadoratmb.databinding.ActivityMainBinding
import com.isaquesoft.calculadoratmb.presentation.adapter.ViewPagerAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewPager()
    }

    private fun setupViewPager() {
        with(binding) {
            val adapter = ViewPagerAdapter(this@MainActivity)
            viewPagerActivity.adapter = adapter

            TabLayoutMediator(tabLayoutMainActivity, viewPagerActivity) { tab, position ->
                tab.text =
                    when (position) {
                        0 -> "Homens"
                        1 -> "Mulheres"
                        else -> {""}
                    }
            }.attach()
        }

    }
}
