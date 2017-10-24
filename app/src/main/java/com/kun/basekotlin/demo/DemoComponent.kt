package com.kun.basekotlin.demo

import com.kun.basekotlin.base.AppBaseModule
import com.kun.baselib.dagger.AppComponent
import com.kun.baselib.dagger.PerView
import dagger.Component

/**
 * @author kun
 * @date 2017/10/20
 */

@PerView
@Component (dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(AppBaseModule::class,DemoModule::class))
interface DemoComponent{
    fun inject(demoActivity: DemoActivity)
}