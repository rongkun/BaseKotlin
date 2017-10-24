package com.kun.basekotlin.base

import com.kun.basekotlin.net.AppNetApi
import com.kun.baselib.dagger.PerView
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * @author kun
 * @date 2017/10/24
 */
@Module
class AppBaseModule{
    @PerView
    @Provides
    internal fun providesNetApi(retrofit: Retrofit): AppNetApi {
        return retrofit.create<AppNetApi>(AppNetApi::class.java)
    }
}