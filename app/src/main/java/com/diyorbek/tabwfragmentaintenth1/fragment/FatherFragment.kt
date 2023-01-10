package com.diyorbek.tabwfragmentaintenth1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.diyorbek.tabwfragmentaintenth1.R
import com.diyorbek.tabwfragmentaintenth1.adapter.ViewPagerAdapter
import com.diyorbek.tabwfragmentaintenth1.databinding.FragmentFatherBinding
import com.google.android.material.tabs.TabLayout

class FatherFragment : Fragment(R.layout.fragment_father) {
    private var _binding: FragmentFatherBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFatherBinding.bind(view)

        initViews()
    }

    private fun initViews() {
        binding.viewPager.adapter = ViewPagerAdapter(this)
        binding.apply {
            tabs.addTab(binding.tabs.newTab().setText("All"))
            tabs.addTab(binding.tabs.newTab().setText("New"))
            tabs.addTab(binding.tabs.newTab().setText("Animals"))
            tabs.addTab(binding.tabs.newTab().setText("Technology"))
            tabs.addTab(binding.tabs.newTab().setText("Nature"))

            viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.tabs.selectTab(binding.tabs.getTabAt(position))
                }
            })
        }
        binding.tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.viewPager.currentItem = tab?.position!!
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}