package com.bill.umengtest;

import android.app.Application;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

/**
 * Created by Bill on 2019/11/28.
 * Describe ：
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // https://mobile.umeng.com/platform/config/apps

        UMConfigure.init(this, "5ddf2b4b570df37f510004b3"
                , "umeng", UMConfigure.DEVICE_TYPE_PHONE, "");
        UMConfigure.setLogEnabled(true);

        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        PlatformConfig.setSinaWeibo("2826640716", "51982d89a44abc936a529f2309a48967", "http://www.baidu.com");
        PlatformConfig.setQQZone("1110004657", "78vEFLOwR4jdnp5O");

    }
}
