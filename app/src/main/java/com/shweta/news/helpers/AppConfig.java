package com.shweta.news.helpers;

import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class AppConfig extends Application implements Application.ActivityLifecycleCallbacks {
    public static ProgressDialog progressDialog;
    private static AppConfig mContext;
    private static AppCompatActivity mCurrentActivity;

    public static synchronized AppConfig getInstance() {
        if (mContext == null) {
            mContext = new AppConfig();
        }
        return mContext;
    }

    public static AppCompatActivity getCurrentActivity() {
        return mCurrentActivity;
    }

    public static ProgressDialog getLoadingDialog() {
        return progressDialog;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        SharedPrefs.getInstance().initSharedPrefs();
     //  Common.setDarkMode(com.omega.rupayindia_distributor.SharedPrefs.getBoolean(com.omega.omegapay.SharedPrefs.ISINDARK));
        registerActivityLifecycleCallbacks(this);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }

    @Override
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
/*
        if(activity instanceof LoginActivity || activity instanceof FullScreeenVideoActivity || activity instanceof MainActivity || activity instanceof LoginActivity || activity instanceof SignUpActivity || activity instanceof SpalshActivity) {
            mCurrentActivity = (AppCompatActivity) activity;
            createLoadingDialog();
        }
*/

    }

    @Override
    public void onActivityStarted(@NonNull Activity activity) {
    }

    @Override
    public void onActivityResumed(@NonNull Activity activity) {
    }

    @Override
    public void onActivityPaused(@NonNull Activity activity) {
    }

    @Override
    public void onActivityStopped(@NonNull Activity activity) {
    }

    @Override
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override
    public void onActivityDestroyed(@NonNull Activity activity) {
    }

//    private void createLoadingDialog() {
//        progressDialog = new ProgressDialog(mCurrentActivity, R.style.ProgressDialogStyle);
//        progressDialog.setCancelable(false);
//        progressDialog.setMessage("Loading");
//        progressDialog.create();
//    }
}
