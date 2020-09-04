package com.demo.weather.module.chooseplace.view

import android.view.View
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.demo.weather.R
import com.demo.weather.base.view.BaseLifeCycleFragment
import com.demo.weather.databinding.FragmentListBinding
import com.demo.weather.module.chooseplace.adapter.ChoosePlaceAdapter
import com.demo.weather.module.chooseplace.viewmodel.ChoosePlaceViewModel
import kotlinx.android.synthetic.main.custom_bar.view.*
import kotlinx.android.synthetic.main.fragment_list.*

class ChoosePlaceFragment : BaseLifeCycleFragment<ChoosePlaceViewModel, FragmentListBinding>(){

    private lateinit var mAdapter : ChoosePlaceAdapter

    private lateinit var mHeaderView : View

    private val mPlaceList = arrayListOf(
        "a","b","c","d","e"
    )

    override fun initDataObserver() {
    }

    override fun getLayoutId(): Int = R.layout.fragment_list

    override fun initData() {
        super.initData()
        setPlaceList(mPlaceList)
    }

    override fun initView() {
        super.initView()
        showSuccess()
        initAdapter()
        initHeaderView()
        initFab()
    }

    private fun initHeaderView() {
        mHeaderView = View.inflate(requireActivity(), R.layout.custom_bar, null)
        mHeaderView.apply {
            detail_title.text = "添加的城市"
            detail_start.visibility = View.VISIBLE
            detail_end.visibility = View.VISIBLE
            detail_end.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.searchPlaceFragment)
            }
            detail_start.setOnClickListener {  }
        }
        mAdapter.addHeaderView(mHeaderView)
    }

    private fun initAdapter() {
        mAdapter = ChoosePlaceAdapter(R.layout.place_item, mPlaceList)
        mRvArticle?.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        mRvArticle?.adapter = mAdapter
        mAdapter.setEnableLoadMore(true)
    }

    private fun initFab() {
        var fab_add = view?.findViewById<View>(R.id.fab_add)
        fab_add?.visibility = View.VISIBLE
    }

    private fun setPlaceList(placeList: List<String>){
        if(placeList.isEmpty()){
            mAdapter.loadMoreEnd()
            return
        }
        if(mSrlRefresh.isRefreshing){
            mSrlRefresh.isRefreshing = false
            mAdapter.setNewData(placeList)
            mAdapter.loadMoreComplete()
            return
        }
        mAdapter.addData(placeList)
        mAdapter.loadMoreComplete()
    }
}