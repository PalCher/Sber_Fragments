package com.example.pavel.ass_homework6_fragments;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import java.util.concurrent.TimeUnit;

public class MyService extends IntentService {

    public MyService() {
        super("Name");
    }

    @Override
    protected void onHandleIntent( Intent intent) {
        Intent broadcastIntent = new Intent("com.example.pavel.ass_homework6_fragments");
        for (int i = 0; i < 20; i++) {
            broadcastIntent.putExtra("data", Integer.toString(i));
            sendBroadcast(broadcastIntent);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static final Intent newIntent (Context context){
        Intent intent = new Intent(context, MyService.class);
        return intent;
    }
}
