package com.evollu.react.fcm;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.facebook.react.HeadlessJsTaskService;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;

import android.util.Log;

public class ActionTaskService extends HeadlessJsTaskService {

    @Override
    protected @Nullable
    HeadlessJsTaskConfig getTaskConfig(Intent intent) {
        Bundle extras = intent.getExtras();
        Log.d("ActionTaskService","extras " + (extras != null));
        if (extras != null) {
            return new HeadlessJsTaskConfig(
                    "ActionTask",
                    Arguments.fromBundle(extras),
                    10000, // timeout for the task
                    true // optional: defines whether or not  the task is allowed in foreground. Default is false
            );
        }
        return null;
    }
}
