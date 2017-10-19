package com.kun.baselib.dagger

import android.app.Activity
import dagger.Provides

/**
 * @author kun
 * @date 2017/10/18
 */
class ActivityModule(private var activity: Activity){
    @Provides
    @PerActivity
    fun activity() = activity
}