package com.example.sensortest;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimerTask;

/**
 * Created by whx on 2016/2/21.
 */
public class Work extends TimerTask implements SensorEventListener{

    private SensorManager sensorManager;
    public static List<DateValueEntity> datas = new ArrayList<>();
    private Context mContext;
    private DateValueEntity dateValueEntityX;
    private DateValueEntity dateValueEntityY;
    private DateValueEntity dateValueEntityZ;

    public Work(Context context){

        this.mContext = context;

    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                sensorManager.unregisterListener(Work.this);
            }
        }
    };

    @Override
    public void run() {

        //Log.d("-----------","test");
        dateValueEntityX = new DateValueEntity();
//        dateValueEntityY = new DateValueEntity();
//        dateValueEntityZ = new DateValueEntity();

        sensorManager = (SensorManager)mContext.getSystemService(Context.SENSOR_SERVICE);
        sensorManager.registerListener(this, sensorManager.
                getDefaultSensor(Sensor.TYPE_ACCELEROMETER), sensorManager.SENSOR_DELAY_GAME);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        float[] values = event.values;
        Calendar calendar = Calendar.getInstance();

//        List<DateValueEntity> datas_x = new ArrayList<>();
//        List<DateValueEntity> datas_y = new ArrayList<>();
//        List<DateValueEntity> datas_z = new ArrayList<>();

        int h = calendar.get(Calendar.HOUR_OF_DAY);
        int m = calendar.get(Calendar.MINUTE);
        int s = calendar.get(Calendar.SECOND);
        String datet = h +""+ m+s;
        int date = Integer.parseInt(datet);

        Log.d("------------",""+dateValueEntityX.getDate()+ "="+date);
        if(dateValueEntityX.getDate() != date){
            dateValueEntityX.setDate(date);
            dateValueEntityX.setValue(values[0]);

//            dateValueEntityY.setDate(date);
//            dateValueEntityY.setValue(values[1]);
//
//            dateValueEntityZ.setDate(date);
//            dateValueEntityZ.setValue(values[2]);

            handler.sendEmptyMessage(1);
        }

//        datas_x.add(dateValueEntityX);
//        datas_y.add(dateValueEntityY);
//        datas_z.add(dateValueEntityZ);

        datas.add(dateValueEntityX);
//        datas.add(datas_y);
//        datas.add(datas_z);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
