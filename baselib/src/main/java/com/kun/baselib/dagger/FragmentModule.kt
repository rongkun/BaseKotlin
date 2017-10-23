package com.kun.baselib.dagger

import android.support.v4.app.Fragment
import dagger.Module
import dagger.Provides

/**
 * @author kun
 * @date 2017/10/18
 */
@Module
class FragmentModule(private var fragment: Fragment){
    @Provides
    @PerView
    fun fragment() = fragment
}