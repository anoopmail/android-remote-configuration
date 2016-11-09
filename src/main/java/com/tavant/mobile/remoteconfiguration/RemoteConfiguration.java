package com.tavant.mobile.remoteconfiguration;

import android.content.Context;
import android.content.SharedPreferences;

import com.anoopnair.httpzoid.Http;
import com.anoopnair.httpzoid.HttpFactory;
import com.anoopnair.httpzoid.HttpResponse;
import com.anoopnair.httpzoid.ResponseHandler;
import com.google.gson.Gson;

/**
 * Created by anoop.m on 11/8/2016.
 */
public class RemoteConfiguration {
    private static RemoteConfiguration ourInstance ;



    private RemoteConfiguration() {

    }

    public static RemoteConfiguration getInstance(){
        if (ourInstance == null)
            ourInstance= new RemoteConfiguration();
        return ourInstance;
    }

    public void fetch(String remoteUrl, final Context context){
        Http http = HttpFactory.create(context);
        http.get(remoteUrl).handler(new ResponseHandler(){
            @Override
            public void success(Object data, HttpResponse response) {
                super.success(data, response);
                if(data == null)    return ;
                String jsonString = new Gson().toJson(data);
                write(jsonString, context);
            }
            }

        ).send();

    }

    public Object get(Context context, Class clazz, Object defaultObject){
        return read(context, clazz, defaultObject);
    }
    public Object get(Context context, Class clazz){
        return read(context, clazz, null);
    }

    private Object read(Context context, Class clazz, Object defaultObject) {

        SharedPreferences remote_configuration_preferences = context.getSharedPreferences("remote_configuration", Context.MODE_PRIVATE);
        if (remote_configuration_preferences == null)   return defaultObject ;
        String remote_configuration = remote_configuration_preferences.getString("remote_configuration", null);
        if (remote_configuration == null)   return defaultObject ;
        //    Type type = new TypeToken<T>(){}.getType();
        Object jsonObject = new Gson().fromJson(remote_configuration, clazz);
        return jsonObject;
    }

    private void write(String jsonString, Context context) {
        SharedPreferences remote_configuration = context.getSharedPreferences("remote_configuration", Context.MODE_PRIVATE);
        remote_configuration.edit().putString("remote_configuration", jsonString).commit();
    }
}
