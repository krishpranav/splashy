package com.reactlibrary;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.ReactContext;

import java.lang.ref.WeakReference;

public class SplashScreen {
    private static Dialog mSplashDialog;
    private static WeakReference<ReactActivity> mActivity;

    public static void show(final ReactActivity activity, final ReactInstanceManager instanceManager) {
        if (activity == null) return;

        mActivity = new WeakReference<ReactActivity>(activity);

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (!activity.isFinishing()) {
                    mSplashDialog = new Dialog(activity, R.style.RNSplashScreen_SplashTheme);
                    mSplashDialog.setCancelable(false);

                    if (!mSplashDialog.isShowing()) {
                        mSplashDialog.show();
                    }

                    if (instanceManager != null) {
                        ReactContext ctx = instanceManager.getCurrentReactContext();
                        if (ctx != null) {
                            activity.getWindow().getDecorView().setBackgroundColor(Color.WHITE);
                        } else {
                            instanceManager.addReactInstanceEventListener(new ReactInstanceManager.ReactInstanceEventListener() {
                                @Override
                                public void onReactContextInitialized(ReactContext context) {

                                    activity.runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            activity.getWindow().getDecorView().setBackgroundColor(Color.WHITE);
                                        }
                                    });
                                }
                            });
                        }
                    }
                }
            }
        });
    }

    public static void hide(Activity activity) {
        if (activity == null) activity = mActivity.get();
        if (activity == null) return;

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mSplashDialog != null && mSplashDialog.isShowing()) {
                    mSplashDialog.dismiss();
                }
            }
        });
    }
}