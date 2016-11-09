package com.tavant.mobile.remoteconfiguration_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.tavant.mobile.remoteconfiguration.RemoteConfiguration;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RemoteConfiguration remoteConfiguration = RemoteConfiguration.getInstance();
        remoteConfiguration.fetch("https://api.myjson.com/bins/3dm8c", this);
    }

    @Override
    public void onClick(View view) {
        RemoteConfiguration remoteConfiguration = RemoteConfiguration.getInstance();

        Person person = (Person) remoteConfiguration.get(this, Person.class, new Person());
//        Person person = (Person) configuration.getLocal(this, Person.class);
        Log.d("here", person.age + "");
    }
}


