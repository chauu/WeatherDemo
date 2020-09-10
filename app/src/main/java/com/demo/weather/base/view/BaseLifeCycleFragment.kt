package com.demo.weather.base.view

import android.text.TextUtils
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.demo.weather.base.viewmodel.BaseViewModel
import com.demo.weather.common.Utils
import com.demo.weather.common.callback.EmptyCallBack
import com.demo.weather.common.callback.ErrorCallBack
import com.demo.weather.common.callback.LoadingCallBack
import com.demo.weather.common.getAppViewModel
import com.demo.weather.common.state.State
import com.demo.weather.common.state.StateType
import com.demo.weather.module.main.AppViewModel
import com.kingja.loadsir.callback.SuccessCallback

abstract class BaseLifeCycleFragment<VM : BaseViewModel<*>, DB : ViewDataBinding> : BaseFragment<VM, DB>() {

    val appViewModel: AppViewModel by lazy { getAppViewModel() }

    override fun initView() {
        showLoading()
        showSuccess()
        mViewModel.loadState.observe(this, observer)
        initDataObserver()
    }

    open fun initDataObserver() {}

    open fun showLoading() {
        loadService.showCallback(LoadingCallBack::class.java)
    }

    open fun showSuccess() {
        loadService.showCallback(SuccessCallback::class.java)
    }

    open fun showError(msg: String) {
        if (!TextUtils.isEmpty(msg)) {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }
        loadService.showCallback(ErrorCallBack::class.java)
    }


    open fun showEmpty() {
        loadService.showCallback(EmptyCallBack::class.java)
    }

    private val observer by lazy {
        Observer<State> {
            it?.let {
                when (it.code) {
                    StateType.SUCCESS -> showSuccess()
                    StateType.LOADING -> showLoading()
                    StateType.ERROR -> showError("网络异常")
                    StateType.NETWORK_ERROR -> showError("网络异常")
                    StateType.EMPTY -> showEmpty()
                }
            }
        }
    }


    override fun reLoad() {
        showLoading()
        super.reLoad()
    }
}