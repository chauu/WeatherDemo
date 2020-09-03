package com.demo.weather.base.view

import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.ColorUtils
import com.demo.weather.R
import com.demo.weather.common.AppManager
import com.demo.weather.common.Utils
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir

abstract class BaseActivity : AppCompatActivity() {
    private var mExitTime : Long = 0

    lateinit var mRootView : View

    open fun initView(){}

    open fun initData(){}

    open fun reLoad(){}

    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        mRootView = (findViewById(android.R.id.content) as ViewGroup).getChildAt(0)
        AppManager.instance.addActivity(this)
        initView()
        initData()
    }

    val loadService : LoadService<*> by lazy {
        LoadSir.getDefault().register(this) {
            reLoad()
        }
    }

    override fun onBackPressed() {
        val time = System.currentTimeMillis()
        if(time - mExitTime > 2000){
            Utils.showToast(this, getString(R.string.exit_app))
            mExitTime = time
        } else {
            AppManager.instance.exitApp(this)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        AppManager.instance.removeActivity(this)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun initStatusColor(color : Int){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.always_white_text)
        }
        if(ColorUtils.calculateLuminance(getColor(R.color.always_white_text)) >= 0.5) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        } else {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        }
    }
}