package com.example.practice_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class TableLayoutPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table_layout_pager)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewpager = findViewById<ViewPager>(R.id.viewPager)

        //탭 레이아웃에 탭을 추가하는 방법
        tabLayout.addTab(tabLayout.newTab().setText("1번째"))
        tabLayout.addTab(tabLayout.newTab().setText("2번째"))
        tabLayout.addTab(tabLayout.newTab().setText("3번째"))

        //Pager에 adapter를 장착하는 방법
        viewpager.adapter = FragmentPagerAdapter(supportFragmentManager, 3)

        //tab과 pager을 연결시키는 방법
        tabLayout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewpager.setCurrentItem(tab!!.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

    }
}



class FragmentPagerAdapter(
    fragmentManager: FragmentManager,
    val tabCount: Int
):FragmentStatePagerAdapter(fragmentManager) {
    override fun getCount(): Int {
        return tabCount

    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return FragmentFirst()
            1 -> return FragmentFirst()
            else -> return FragmentFirst()
        }
    }
}