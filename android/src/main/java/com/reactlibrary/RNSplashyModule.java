package com.reactlibrary;

import com.facebook.react.ReactActivity;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

class RNSplashy extends ReactContextBaseJavaModule {
    public RNSplashy(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "RNSplashy";
    }

    @ReactMethod
    public void show() {
        SplashScreen.show((ReactActivity)getCurrentActivity(), null);
    }

    @ReactMethod
    public void hide() {
        SplashScreen.hide(getCurrentActivity());
    }
}