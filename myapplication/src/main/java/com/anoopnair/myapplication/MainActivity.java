package com.anoopnair.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.tavant.mobile.remoteconfiguration.RemoteConfiguration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupRemoteConfig();
    }

    private void setupRemoteConfig() {
        RemoteConfiguration remoteConfiguration = RemoteConfiguration.getInstance();
//        remoteConfiguration.fetch("https://api.myjson.com/bins/3dm8c", this);
        Configuration r = (Configuration) remoteConfiguration.get(Configuration.class, this);
        Log.e("value", r.welcomeText);
    }
}
