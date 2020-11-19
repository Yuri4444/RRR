package com.webanimal.rrr.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.webanimal.rrr.ui.fragmentsERAS.FirstFragment
import com.webanimal.rrr.ui.fragmentsERAS.MainFragment
import com.webanimal.rrr.ui.fragmentsERAS.SecondFragment
import com.webanimal.rrr.ui.fragmentsERAS.ThirdFragment

class ExampleStateAdapterWithFragments(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
        FragmentStateAdapter(fragmentManager, lifecycle) {

    var fragments : ArrayList<Fragment> = arrayListOf(
            MainFragment(),
            FirstFragment(),
            SecondFragment(),
            ThirdFragment()
    )

    override fun getItemCount(): Int {
        return fragments.size
    }



    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}