package com.kun.basekotlin.demo

import android.os.Bundle
import com.kun.basekotlin.bean.WeatherResponse
import com.kun.baselib.base.BaseActivity
import com.kun.baselib.utils.ToastUtil
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import javax.inject.Inject

class DemoActivity : BaseActivity(),DemoContract.View {
    companion object static{
        val ID_TEXT : Int = 1
    }
    override fun getWeatherSuccess(weatherResponse: WeatherResponse) {
        ToastUtil.toastShort("温度："+weatherResponse.wendu)
    }

    @Inject
    internal lateinit var mPresenter : DemoContract.Present

    override fun daggerInit() {
        DaggerDemoComponent.builder()
                .appComponent(getAppComponent())
                .demoModule(DemoModule(this))
                .build()
                .inject(this)
    }
    override fun success() {
        ToastUtil.toastShort("success")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_demo)
//        tvTest.text = "Hello Kotlin"
//        btTest.setOnClickListener { }
        mPresenter.send()
        //anko布局写法
        relativeLayout {
            textView ("hello anko"){
                id = ID_TEXT
                textSize = 16f
            }.lparams(wrapContent){
                centerInParent()
            }
            button("获取温度"){
                textSize = 14f
            }.lparams(wrapContent){
                below(ID_TEXT)
                centerHorizontally()
                topMargin = 10
            }.onClick {
                mPresenter.getWeather("广州")
            }
        }
    }
}
