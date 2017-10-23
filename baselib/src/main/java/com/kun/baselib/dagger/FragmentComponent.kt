package com.kun.baselib.dagger

import android.support.v4.app.Fragment
import dagger.Component

/**
 * @author kun
 * @date 2017/10/18
 */
@PerView
@Component(dependencies = arrayOf(AppComponent:: class),modules = arrayOf(FragmentModule:: class))
interface FragmentComponent {
    fun provideFragment() : Fragment
}