package com.kun.baselib.base

/**
 * @author 坤
 * @date 2017/12/6
 */
open class BasePresenter<V : BaseActivityView> : BasePresenterIntfc<V>{
    protected var mView : V? = null

    override fun attachView(mView: V) {
        this.mView = mView
    }

    override fun destroyView() {
        mView = null
    }
}