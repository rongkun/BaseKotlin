package com.kun.baselib.utils

import com.kun.baselib.Net.ErrorCode
import com.kun.baselib.base.BaseResponse
import io.reactivex.subscribers.DisposableSubscriber
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * @author kun
 * @date 2017/10/19
 */
abstract class RxSubscriber<T : BaseResponse<*>> : DisposableSubscriber<T>() {

    override fun onNext(t: T?) {
        if (t != null && t.code === 1) {
            onSuccess(t)
        } else {
            onFail(t)
        }
    }

    override fun onError(e: Throwable) {
        e.printStackTrace()
        if (e is UnknownHostException) {
            toast("请检查您的网络设置")
            noNet()
        } else if (e is SocketTimeoutException) {
            toast("连接超时")
        } else if (e is ConnectException) {
            toast("连接出错")
        } else {
            ToastUtil.toastLimit("访问出错")
        }
    }

    override fun onComplete() {

    }

    abstract fun onSuccess(t: T)

    fun onFail(t: T?) {
        if (t == null) {
            toast("服务器访问失败")
        } else {
            val errorMsg = ErrorCode.getErrorMsg(t.code)
            toast(errorMsg ?: t.info?:"")
        }
    }

    fun noNet() {}

    private fun toast(str: String) {
        ToastUtil.toastLimit(str)
    }
}
