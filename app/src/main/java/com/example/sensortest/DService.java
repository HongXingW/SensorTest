package com.example.sensortest;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;

/**
 * Created by whx on 2016/2/21.
 */
public class DService extends Service{

    //private List<DateValueEntity> datas = new ArrayList<>();
    Timer timer;
    Intent intent = new Intent("com.whx.RECIVER");
    PowerManager.WakeLock mWakeLock;// 电源锁

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        super.onCreate();
        timer = new Timer();
        timer.schedule(new Work1(this),0,5000);

        acquireWakeLock();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("------------", "service start");

        return START_STICKY;
    }

    @Override
    public void onDestroy() {

        //datas = Work.datas;
        timer.cancel();

        sendBroadcast(intent);

//        for(int i = 0;i<datas.size();i++){
//            Log.d("------------",datas.get(i).getDate()+"--"+datas.get(i).getValue());
//        }

        releaseWakeLock();

        super.onDestroy();
    }

    /**
     * 申请电源锁
     */
    private void acquireWakeLock() {
        if (null == mWakeLock) {
            PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
            mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK
                    | PowerManager.ON_AFTER_RELEASE, "DService");
            if (null != mWakeLock) {
                mWakeLock.acquire();
            }
        }
    }

    /**
     * 释放电源锁
     */
    private void releaseWakeLock() {
        if (null != mWakeLock) {
            mWakeLock.release();
            mWakeLock = null;
        }
    }
}
