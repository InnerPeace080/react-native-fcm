package com.evollu.react.fcm;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import android.content.Context;

public class FIRBroadcastReceiver extends BroadcastReceiver {
    private final static String TAG = FIRMessagingModule.class.getCanonicalName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive");

        Intent newIntent = new Intent(context, BackgroundService.class);
        newIntent.putExtras(intent.getExtras());
//        context.startService(newIntent);
        try{
          context.startService(newIntent);
        }catch(Exception e){
          e.printStackTrace();
        }
        // if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        //     context.startForegroundService(newIntent);
        // } else {
        //     context.startService(newIntent);
        // }
    }
}
