package com.kun.baselib.dagger

import android.app.Activity
import dagger.Component

/**
 * @author kun
 * @date 2017/10/18
 */
@PerView
@Component(dependencies = arrayOf(AppComponent :: class),modules = arrayOf(ActivityModule :: class))
interface ActivityComponent{
    fun provideActivity() : Activity
}