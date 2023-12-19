package com.example.practice_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

class TabLayoutPagerNewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout_pager_new)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewpager = findViewById<ViewPager2>(R.id.viewPager)

        //탭 레이아웃에 탭을 추가하는 방법
        tabLayout.addTab(tabLayout.newTab())
        tabLayout.addTab(tabLayout.newTab())
        tabLayout.addTab(tabLayout.newTab())

        //Pager에 adapter를 장착하는 방법
        viewpager.adapter = FragmentAdapter(this, 3)
        //페이저와 탭을 연결
        viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })

        //tab과 pager을 연결시키는 방법
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    viewpager.setCurrentItem(it.position, true)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

    }
}


class FragmentAdapter(
    fragmentActivity: androidx.fragment.app.FragmentActivity,
    val tabCount: Int
) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return tabCount
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return FragmentFirst()
            1 -> return FragmentFirst()
            else -> return FragmentFirst()
        }
    }


}