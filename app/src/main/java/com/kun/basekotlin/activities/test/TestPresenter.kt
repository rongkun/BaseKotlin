package com.kun.basekotlin.activities.test

import com.kun.basekotlin.bean.WeatherResponse
import com.kun.basekotlin.net.AppNetApi
import com.kun.baselib.base.BasePresenter
import com.kun.baselib.base.BaseResponse
import com.kun.baselib.utils.HttpSubscriber
import com.kun.baselib.utils.RxHelper
import javax.inject.Inject

class TestPresenter
@Inject constructor() : TestContract.Present , BasePresenter<TestContract.View>(){
    @Inject
    lateinit var netApi : AppNetApi
    override fun getWeather() {
        netApi.getWeather("广州")
                .compose(mView?.getLifecycleProvider()?.bindToLifecycle())
                .compose(RxHelper.io_main())
                .subscribe(object : HttpSubscriber<BaseResponse<WeatherResponse>>() {
                    override fun onSuccess(response: BaseResponse<WeatherResponse>) {
                        mView?.getWeatherSuccess(response.data)
                    }
                })
    }

    override fun set() {
        mView?.show()
    }
}