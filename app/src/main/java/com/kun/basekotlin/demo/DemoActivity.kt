package com.kun.basekotlin.demo

import android.os.Bundle
import com.kun.basekotlin.R
import com.kun.baselib.base.BaseActivity
import com.kun.baselib.base.BaseApplication
import com.kun.baselib.utils.ToastUtil
import kotlinx.android.synthetic.main.activity_demo.*
import javax.inject.Inject

class DemoActivity : BaseActivity(),DemoContract.View {
    @Inject
    internal lateinit var mPresenter : DemoPresenter
    override fun setPresenter(mPresenter: DemoPresenter) {
        this.mPresenter = mPresenter
    }

    override fun daggerInit() {
        DaggerDemoComponent.builder()
                .appComponent(BaseApplication.appConponent)
                .demoModule(DemoModule(this,this))
                .build()
                .inject(this)
    }
    override fun success() {
        ToastUtil.toastShort("success")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)
        tvTest.text = "Hello World"
        btTest.setOnClickListener { mPresenter.send() }
    }
}
