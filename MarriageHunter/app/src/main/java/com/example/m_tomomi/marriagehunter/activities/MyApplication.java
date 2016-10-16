package com.example.m_tomomi.marriagehunter.activities;

import android.app.Application;
import com.firebase.client.Firebase;

/**
 * Created by mm on 2016/07/11.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }

}
