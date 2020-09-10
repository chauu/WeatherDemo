package com.demo.weather.module.searchplace.view

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.demo.weather.R
import com.demo.weather.base.view.BaseLifeCycleFragment
import com.demo.weather.common.KeyBoardUtil.hideKeyboard
import com.demo.weather.databinding.SearchPlaceFragmentBinding
import com.demo.weather.model.Place
import com.demo.weather.module.searchplace.adapter.SearchPlaceAdapter
import com.demo.weather.module.searchplace.viewmodel.SearchPlaceViewModel
import kotlinx.android.synthetic.main.custom_bar.view.*
import kotlinx.android.synthetic.main.search_place_fragment.*

class SearchPlaceFragment : BaseLifeCycleFragment<SearchPlaceViewModel, SearchPlaceFragmentBinding>() {

    private lateinit var mAdapter: SearchPlaceAdapter

    override fun getLayoutId(): Int = R.layout.search_place_fragment

    override fun initView() {
        super.initView()
        initAdapter()
        initHeaderView()
    }

    private fun initAdapter(){
        mAdapter = SearchPlaceAdapter(R.layout.search_result_item, null)
        place_recycle.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        place_recycle.visibility = View.VISIBLE
        place_recycle.adapter = mAdapter
        mAdapter.setOnItemClickListener { adapter, view, position ->
            val place = mAdapter.getItem(position)
            place?.let {
                mViewModel.insertPlace(place)
                hideKeyboard()
                Navigation.findNavController(view).navigateUp()
            }
        }
    }

    private fun initHeaderView(){
        search_bar.apply {
            detail_title.text = "搜索城市"
            detail_start.visibility = View.VISIBLE
            detail_end.visibility = View.GONE
            detail_start.setOnClickListener {
                Navigation.findNavController(it).navigateUp()
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initSearch()
    }

    private fun initSearch(){
        search_place_edit.addTextChangedListener { editable ->
            val content = editable.toString()
            if(content.isNotEmpty()){
                mViewModel.searchPlaces(content)
                place_recycle.visibility = View.VISIBLE
            } else {
                place_recycle.visibility = View.GONE
                mViewModel.mSearchPlacesDate.value = null
                setPlaceList(arrayListOf())
                mAdapter.notifyDataSetChanged()
            }
        }
    }

    override fun initDataObserver() {
        super.initDataObserver()
        mViewModel.mSearchPlacesDate.observe(this, Observer {
            it?.let {
                setPlaceList(it.places)
            }
        })
    }

    private fun setPlaceList(placeList: MutableList<Place>) {
        mAdapter.setNewInstance(placeList)
    }
}