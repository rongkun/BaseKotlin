package com.kun.basekotlin.activities.test

import android.os.Bundle
import com.kun.basekotlin.R
import com.kun.basekotlin.bean.WeatherResponse
import com.kun.basekotlin.dagger.DaggerAppBaseComponent


import com.kun.baselib.base.BaseActivity
import com.kun.baselib.utils.ToastUtil

class TestActivity : BaseActivity<TestPresenter>(), TestContract.View {
    override fun getWeatherSuccess(response: WeatherResponse?) {
        ToastUtil.toastShort(response?.wendu!!)
    }

    override fun show() {
        ToastUtil.toastShort("success")
    }

    override fun daggerInit() {
        DaggerAppBaseComponent.builder()
                .appComponent(getAppComponent())
                .build()
                .inject(this)
        mPresenter.attachView(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        mPresenter.set()
        mPresenter.getWeather()
    }
}
