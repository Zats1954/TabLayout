package ru.zatsoft.tablayout2

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import ru.zatsoft.tablayout2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Tab1Fragment.OnFragmentInteractionListener,
    Tab2Fragment.OnFragmentInteractionListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureTabLayout()

        val adapter = TabPagerAdapter(this, binding.tabLayout.tabCount)
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager)
        {   tab, position ->
            tab.text = "${(position + 1)} "
        }.attach()
    }

    private fun configureTabLayout() {
        repeat(2) {
            binding.tabLayout.addTab(binding.tabLayout.newTab())
        }
    }



    override fun onFragmentInteraction(uri: Uri) {
    }
}


