package com.kun.baselib.base

/**
 * @author kun
 * @date 2017/10/19
 */
class BaseResponse<T>{
    var code : Int = 0
    var info : String? = null
    var data : T? = null
}