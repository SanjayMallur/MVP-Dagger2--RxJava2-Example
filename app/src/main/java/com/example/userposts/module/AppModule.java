package com.example.userposts.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Sanjay Mallur
 * {@link AppModule - Singleton application module}
 */
@Module
public class AppModule {

    Application application;

    public  AppModule(Application application){
        this.application=application;
    }

    @Provides
    @Singleton
    Application providesApplication(){
        return application;
    }

}
