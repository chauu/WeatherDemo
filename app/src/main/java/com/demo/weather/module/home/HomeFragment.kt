package com.demo.weather.module.home

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.demo.weather.R
import com.demo.weather.base.view.BaseLifeCycleFragment
import com.demo.weather.common.Utils
import com.demo.weather.databinding.HomeFragmentBinding
import com.demo.weather.module.home.adapter.HourAdapter
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.home_fragment.view.*
import kotlinx.android.synthetic.main.layout_container.*

class HomeFragment : BaseLifeCycleFragment<HomeViewModel, HomeFragmentBinding>() {

    private lateinit var mAdapter: HourAdapter

    private val mPlaceList = arrayListOf(
        "a","b","c","d","e"
    )

    override fun initView() {
        super.initView()
        setHasOptionsMenu(true)
        initToolbar()
        initAdapter()
    }

    override fun getLayoutId(): Int = R.layout.home_fragment

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_city -> {
                Navigation.findNavController(home_container).navigate(R.id.action_homeFragment_to_choosePlaceFragment)
            }
            R.id.action_more -> {
                Utils.showToast(requireContext(), getString(R.string.more))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initToolbar() {
        home_bar.home_title.text = "AAA"
        home_bar.setTitle("")
        (requireActivity() as AppCompatActivity).setSupportActionBar(home_bar)
    }

    private fun initAdapter(){
        mAdapter = HourAdapter(R.layout.hourly_item, mPlaceList)
        home_recycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        home_recycler.adapter = mAdapter
    }
}