package com.kun.basekotlin.demo

import com.kun.basekotlin.bean.WeatherResponse
import com.kun.baselib.base.BaseActivityView

/**
 * @author kun
 * @date 2017/10/20
 */
class DemoContract{
    interface View : BaseActivityView{
        fun success()
        fun getWeatherSuccess(weatherResponse: WeatherResponse)
    }
    interface Present {
        fun send()
        fun getWeather(city : String)
    }
}