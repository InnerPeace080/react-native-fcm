package com.evollu.react.fcm;

import android.content.Intent;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FIRMessagingPackage implements ReactPackage {
    Intent mIntent;
    public FIRMessagingPackage(){
    }
    public FIRMessagingPackage(Intent intent){
        mIntent = intent;
    }

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();
        if (mIntent==null){
            modules.add(new FIRMessagingModule(reactContext));
        }else{
            modules.add(new FIRMessagingModule(reactContext,mIntent));
        }

        return modules;
    }

    // support rn < 0.47
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Arrays.<ViewManager>asList();
    }
}
