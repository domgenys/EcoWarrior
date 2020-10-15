package com.example.Eco_warrior;

import android.app.Application;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;

public class ApplicationClass extends Application {


    public static final String APPLICATION_ID = "50308345-9C71-1BB4-FF98-8341ADE29D00";
    public static final String API_KEY = "0C8E90F3-C1BC-4ADB-975B-5BE75794E3CC";
    public static final String SERVER_URL = "https://api.backendless.com";


    public static BackendlessUser user;



    @Override
    public void onCreate() {
        super.onCreate();


        Backendless.setUrl( SERVER_URL );
        Backendless.initApp( getApplicationContext(),
                APPLICATION_ID,
                API_KEY );


    }
}