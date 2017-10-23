package com.kun.baselib.base

import android.content.Context
import android.os.Bundle
import com.trello.rxlifecycle2.components.RxActivity

/**
 * @author kun
 * @date 2017/10/20
 */
abstract class BaseActivity : RxActivity(),
BaseActivityView{
    protected var mActivity : BaseActivity? = null
    protected var mContext : Context? = null
    abstract fun daggerInit()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = this
        mContext = this
        daggerInit()
    }

    override fun getContext() : Context? = mContext
}