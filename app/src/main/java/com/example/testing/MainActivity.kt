package com.example.testing

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

//Source for fragment and tablayout setup: https://d2dreamdevelopers.blogspot.com/2021/04/tab-layout-with-viewpager-using-fragment.html#google_vignette

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var viewPager = findViewById(R.id.viewPager) as ViewPager
        var tablayout = findViewById(R.id.tablayout) as TabLayout

        val fragmentAdapter = FragmentAdapter(supportFragmentManager)
        fragmentAdapter.addFragment(Tab1(),"Text")
        fragmentAdapter.addFragment(Tab2(),"Choices")
        fragmentAdapter.addFragment(Tab3(),"ToDo")
        fragmentAdapter.addFragment(Tab4(),"Profile")
        fragmentAdapter.addFragment(Tab5(),"Colors")
        fragmentAdapter.addFragment(Tab6(),"LR")

        viewPager.adapter = fragmentAdapter
        tablayout.setupWithViewPager(viewPager)
    }
}