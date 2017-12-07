package com.kun.baselib.base

/**
 * @author kun
 * @date 2017/11/16
 */
interface BasePresenterIntfc<in V : BaseActivityView>{
    fun attachView(mView : V)
    fun destroyView()
}