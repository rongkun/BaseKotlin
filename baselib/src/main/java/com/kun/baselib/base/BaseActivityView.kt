package com.kun.baselib.base

import android.content.Context

/**
 * @author kun
 * @date 2017/10/20
 */
interface BaseActivityView{
    fun getContext() : Context?
    fun finish()
}