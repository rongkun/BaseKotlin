package com.kun.basekotlin.demo

import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.android.ActivityEvent
import dagger.Module
import dagger.Provides

/**
 * @author kun
 * @date 2017/10/20
 */
@Module
class DemoModule(private var mView: DemoContract.View,private var lifecycleProvider: LifecycleProvider<ActivityEvent>)  {
    @Provides
    fun providesView()  = mView
    @Provides
    fun provideLifecycleProvider() = lifecycleProvider
}