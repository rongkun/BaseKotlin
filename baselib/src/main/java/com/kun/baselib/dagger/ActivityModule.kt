package com.kun.baselib.dagger

import android.app.Activity
import dagger.Module
import dagger.Provides

/**
 * @author kun
 * @date 2017/10/18
 */
@Module
class ActivityModule(private var activity: Activity){
    @Provides
    @PerView
    fun activity() = activity
}