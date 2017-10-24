package com.kun.basekotlin.demo

import com.kun.basekotlin.bean.WeatherResponse
import com.kun.basekotlin.net.AppNetApi
import com.kun.baselib.base.BaseResponse
import com.kun.baselib.utils.RxHelper
import com.kun.baselib.utils.RxSubscriber
import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.android.ActivityEvent
import javax.inject.Inject

/**
 * @author kun
 * @date 2017/10/20
 */
class DemoPresenter
@Inject constructor(val mView: DemoContract.View,
                    val mlifecycleProvider: LifecycleProvider<ActivityEvent>,
                    val mAppNetApi: AppNetApi) : DemoContract.Present {
    override fun getWeather(city: String) {
        mAppNetApi.getWeather(city).compose(mlifecycleProvider.bindToLifecycle())
                .compose(RxHelper.io_main())
                .subscribe(object : RxSubscriber<BaseResponse<WeatherResponse>>() {
                    override fun onSuccess(t: BaseResponse<WeatherResponse>) {
                        mView.getWeatherSuccess(t.data!!)
                    }
                })
    }

    @Inject
    fun setPresenter(){
        mView.setPresenter(this)
    }
    override fun send() {
        mView.success()
    }
}