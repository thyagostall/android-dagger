package com.thyago.dagger;

import android.app.Application;

/**
 * Created by thyago on 17/01/2017.
 */

public class MyApplication extends Application {

    private AppComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mComponent = DaggerAppComponent.create();
    }

    public AppComponent getComponent() {
        return mComponent;
    }
}
