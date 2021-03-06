package com.demo.weather.module.addedplace.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.demo.weather.R
import com.demo.weather.base.view.BaseLifeCycleFragment
import com.demo.weather.databinding.FragmentListBinding
import com.demo.weather.model.Place
import com.demo.weather.module.addedplace.adapter.ChoosePlaceAdapter
import com.demo.weather.module.addedplace.viewmodel.ChoosePlaceViewModel
import kotlinx.android.synthetic.main.custom_bar.view.*
import kotlinx.android.synthetic.main.fragment_list.*

class ChoosePlaceFragment : BaseLifeCycleFragment<ChoosePlaceViewModel, FragmentListBinding>(){

    private lateinit var mAdapter : ChoosePlaceAdapter

    private lateinit var mHeaderView : View

    override fun initDataObserver() {
        mViewModel.mPlaceData.observe(this, Observer { response ->
            response?.let {
                setPlaceList(response)
            }
        })
    }

    override fun getLayoutId(): Int = R.layout.fragment_list

    override fun initView() {
        super.initView()
        initAdapter()
        initHeaderView()
    }

    override fun initData() {
        super.initData()
        mViewModel.queryAllPlace()
    }

    private fun initHeaderView() {
        mHeaderView = View.inflate(requireActivity(), R.layout.custom_bar, null)
        mHeaderView.apply {
            detail_title.text = "添加的城市"
            detail_start.visibility = View.VISIBLE
            detail_end.visibility = View.VISIBLE
            detail_end.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.action_choosePlaceFragment_to_searchPlaceFragment)
            }
            detail_start.setOnClickListener {
                Navigation.findNavController(it).navigateUp()
            }
        }
        mAdapter.addHeaderView(mHeaderView)
    }

    private fun initAdapter() {
        mAdapter = ChoosePlaceAdapter(R.layout.place_item, null)
        mRvArticle?.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        mRvArticle?.adapter = mAdapter
        mAdapter.setOnItemLongClickListener { adapter, view, position ->
            val place = mAdapter.getItem(position)
            place?.let {
                mViewModel.deletePlace(place)
                mAdapter.notifyDataSetChanged()
            }
            true
        }
        mAdapter.setOnItemClickListener { adapter, view, position ->
            val bundle = Bundle()
            appViewModel.changeCurrentPlace(mAdapter.getItem(position))
            bundle.putString("lng", mViewModel.mPlaceData.value?.get(position)?.location?.lng)
            bundle.putString("lat", mViewModel.mPlaceData.value?.get(position)?.location?.lat)
            bundle.putString("placeName", mAdapter.getItem(position).name)
            Navigation.findNavController(view).navigateUp()
        }
    }
    
    private fun setPlaceList(placeList: MutableList<Place>){
        mAdapter.setNewInstance(placeList)
    }
}