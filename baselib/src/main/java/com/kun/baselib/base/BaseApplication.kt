package com.kun.baselib.base

import android.app.Application
import com.bugtags.library.Bugtags
import com.kun.baselib.BuildConfig
import com.kun.baselib.config.Constants

/**
 * @author kun
 * @date 2017/10/18
 */
class BaseApplication : Application() {

    companion object {
        lateinit var instance: BaseApplication
            private set
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
        if(BuildConfig.DEBUG){
            Bugtags.start(Constants.BUGTAGS_APPKEY_BETA, this, Bugtags.BTGInvocationEventNone)
        } else run {
            //release
            Bugtags.start(Constants.BUGTAGS_APPKEY_LIVE, this, Bugtags.BTGInvocationEventNone)
        }
    }
}