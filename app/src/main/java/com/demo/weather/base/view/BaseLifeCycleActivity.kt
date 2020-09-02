package com.demo.weather.base.view

import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.demo.weather.base.viewmodel.BaseViewModel
import com.demo.weather.common.Utils
import com.demo.weather.common.callback.EmptyCallBack
import com.demo.weather.common.callback.ErrorCallBack
import com.demo.weather.common.callback.LoadingCallBack
import com.demo.weather.common.state.State
import com.demo.weather.common.state.StateType
import com.kingja.loadsir.callback.SuccessCallback

abstract class BaseLifeCycleActivity<VM : BaseViewModel<*>> : BaseActivity(){
    protected lateinit var mViewModel: VM

    override fun initView() {
        showLoading()
        mViewModel = ViewModelProvider(this).get(Utils.getClass(this))
        mViewModel.loadState.observe(this, observer)
        initDataObserver()
    }

    abstract fun initDataObserver()

    open fun showLoading() {
        loadService.showCallback(LoadingCallBack::class.java)
    }

    open fun showSuccess() {
        loadService.showCallback(SuccessCallback::class.java)
    }

    open fun showError(msg : String){
        if(!TextUtils.isEmpty(msg)){
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
        loadService.showCallback(ErrorCallBack::class.java)
    }

    open fun showEmpty() {
        loadService.showCallback(EmptyCallBack::class.java)
    }

    /**
     * 分发应用状态
     */
    private val observer by lazy {
        Observer<State> {
            it?.let {
                when (it.code) {
                    StateType.SUCCESS -> showSuccess()
                    StateType.LOADING -> showLoading()
                    StateType.ERROR -> showError("网络出现问题啦")
                    StateType.NETWORK_ERROR -> showError("网络出现问题啦")
                    StateType.EMPTY -> showEmpty()
                }
            }
        }
    }
}