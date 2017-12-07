package com.kun.basekotlin.dagger

import com.kun.basekotlin.activities.test.TestActivity
import com.kun.baselib.dagger.AppComponent
import com.kun.baselib.dagger.PerView
import dagger.Component

/**
 * @author 坤
 * @date 2017/12/6
 */
@PerView
@Component(dependencies = [AppComponent::class],
        modules = [AppBaseModule::class])
interface AppBaseComponent {
    fun inject(testActivity: TestActivity)
}