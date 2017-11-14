package com.kun.basekotlin.demo

import com.kun.basekotlin.bean.WeatherResponse
import com.kun.basekotlin.net.AppNetApi
import com.kun.baselib.base.BaseResponse
import com.kun.baselib.utils.HttpSubscriber
import com.kun.baselib.utils.RxHelper
import javax.inject.Inject

/**
 * @author kun
 * @date 2017/10/20
 */
class DemoPresenter
@Inject constructor(private var mView: DemoContract.View,
                    private val mAppNetApi: AppNetApi) : DemoContract.Present {

    override fun getWeather(city: String) {
        mAppNetApi.getWeather(city).compose(mView.getLifecycleProvider().bindToLifecycle())
                .compose(RxHelper.io_main())
                .subscribe(object : HttpSubscriber<BaseResponse<WeatherResponse>>() {
                    override fun onSuccess(t: BaseResponse<WeatherResponse>) {
                        mView.getWeatherSuccess(t.data!!)
                    }
                })
    }

    override fun send() {
        mView.success()
    }
}