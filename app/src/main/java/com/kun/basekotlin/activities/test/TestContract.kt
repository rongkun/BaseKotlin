package com.kun.basekotlin.activities.test

import com.kun.basekotlin.bean.WeatherResponse
import com.kun.baselib.base.BaseActivityView

class TestContract {
    interface View : BaseActivityView {
        fun show()
        fun getWeatherSuccess(response: WeatherResponse?)
    }

    interface Present{
        fun set()
        fun getWeather()
    }
}