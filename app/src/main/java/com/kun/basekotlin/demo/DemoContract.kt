package com.kun.basekotlin.demo

import com.kun.baselib.base.BaseView

/**
 * @author kun
 * @date 2017/10/20
 */
class DemoContract{
    interface View : BaseView<DemoPresenter>{
        fun success()
    }
    interface Present{
        fun send()
    }
}