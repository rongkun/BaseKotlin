package com.kun.baselib.base

/**
 * @author kun
 * @date 2017/10/20
 */
interface BaseView<T> : BaseActivityView{
    fun setPresenter(mPresenter : T)
}