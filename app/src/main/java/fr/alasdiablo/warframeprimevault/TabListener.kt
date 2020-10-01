package fr.alasdiablo.warframeprimevault

import com.google.android.material.tabs.TabLayout

class TabListener(private val mainActivity: MainActivity): TabLayout.OnTabSelectedListener {

    override fun onTabReselected(p0: TabLayout.Tab?) {}

    override fun onTabUnselected(p0: TabLayout.Tab?) {}

    override fun onTabSelected(p0: TabLayout.Tab?) {
        if (p0 != null) {
            when(p0.position) {
                0 -> mainActivity.setRecyclerView("lith.json")
                1 -> mainActivity.setRecyclerView("meso.json")
                2 -> mainActivity.setRecyclerView("neo.json")
                3 -> mainActivity.setRecyclerView("axi.json")
            }
        }
    }
}