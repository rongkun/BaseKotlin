package com.kun.basekotlin.demo

import dagger.Module
import dagger.Provides

/**
 * @author kun
 * @date 2017/10/20
 */
@Module
class DemoModule(private var mView: DemoContract.View)  {
    @Provides
    fun providesView()  = mView
    @Provides
    fun providesPresent(demoPresenter: DemoPresenter) : DemoContract.Present = demoPresenter
}