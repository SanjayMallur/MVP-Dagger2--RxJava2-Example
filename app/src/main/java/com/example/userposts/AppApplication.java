package com.example.userposts;

import android.app.Application;

import com.example.userposts.module.AppModule;
import com.example.userposts.module.DaggerNetComponent;
import com.example.userposts.module.NetComponent;
import com.example.userposts.module.NetModule;

/**
 * @author Sanjay Mallur
 * {@link AppApplication -  Application class for providing Dagger net component}
 */

public class AppApplication extends Application {

    private static NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        netComponent= DaggerNetComponent.builder().appModule(new AppModule(this)) // This also corresponds to the name of your module: %component_name%Module
                .netModule(new NetModule(BuildConfig.BASE_URL))
                .build();
    }

    public static NetComponent getNetComponent(){
        return  netComponent;
    }
}
