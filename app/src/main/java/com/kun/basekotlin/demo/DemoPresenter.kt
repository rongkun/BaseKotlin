package com.kun.basekotlin.demo

import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.android.ActivityEvent
import javax.inject.Inject

/**
 * @author kun
 * @date 2017/10/20
 */
class DemoPresenter
@Inject constructor(val mView: DemoContract.View,
                    val mlifecycleProvider: LifecycleProvider<ActivityEvent>) : DemoContract.Present {
    @Inject
    fun setPresenter(){
        mView.setPresenter(this)
    }
    override fun send() {
        mView.success()
    }
}