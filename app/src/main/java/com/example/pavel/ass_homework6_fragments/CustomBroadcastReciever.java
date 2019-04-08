package com.example.pavel.ass_homework6_fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class CustomBroadcastReciever extends BroadcastReceiver {

    private ViewCallback mViewCallback;

    public CustomBroadcastReciever(ViewCallback mViewCallback) {
        this.mViewCallback = mViewCallback;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        this.mViewCallback.onStatusChanged(intent.getStringExtra("data"));
    }
}
