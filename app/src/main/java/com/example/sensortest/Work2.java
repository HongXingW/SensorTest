package com.example.sensortest;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

/**
 * Created by whx on 2016/2/29.
 */
public class Work2 extends TimerTask implements SensorEventListener {

    private SensorManager sensorManager;
    public static List<DateValueEntity> datas = new ArrayList<>();
    private Context mContext;
    private DateValueEntity dateValueEntityX;
    private DateValueEntity dateValueEntityY;
    private DateValueEntity dateValueEntityZ;

    private float[] accs = new float[2];
    private long[] times = new long[2];
    private long time;

    private boolean isSleep;
    private int initAcc = 1;

    public Work2(Context context){

        this.mContext = context;

    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                sensorManager.unregisterListener(Work2.this);
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
//        Calendar calendar = Calendar.getInstance();

//        List<DateValueEntity> datas_x = new ArrayList<>();
//        List<DateValueEntity> datas_y = new ArrayList<>();
//        List<DateValueEntity> datas_z = new ArrayList<>();

//        int h = calendar.get(Calendar.HOUR_OF_DAY);
//        int m = calendar.get(Calendar.MINUTE);
//        int s = calendar.get(Calendar.SECOND);
//        String datet = h +""+ m+s;
//        int date = Integer.parseInt(datet);


        if(1 == initAcc){
            accs[0] = values[0];
            initAcc = 0;

            Date curDate = new Date(System.currentTimeMillis());
            times[0] = curDate.getTime();
        }else {

            accs[1] = values[0];

            Date endDate = new Date(System.currentTimeMillis());
            times[1] = endDate.getTime();

            Log.d("--------------","accs[0]="+accs[0]+" accs[1]="+accs[1]);

            if(Math.abs(accs[1] - accs[0]) < 0.15f){
                Log.d("--------------","times[0]="+times[0]+" times[1]="+times[1]);

                if(Math.abs(times[1] - times[0]) < 60000){
                    isSleep = false;
                    Log.d("----------","user is awaking");
                }else{
                    isSleep = true;
                    time = times[0]+300000;
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日    HH:mm:ss     ");
                    Date d = new Date(time);
                    String t = formatter.format(d);

                    Log.d("----------","user is sleeping and time is "+t);
                }
            }else{


                Log.d("--------------","times[0]="+times[0]+" times[1]="+times[1]);

                if(Math.abs(times[1] - times[0]) < 60000){
                    isSleep = false;
                    Log.d("----------","user is awaking");
                }else{
                    isSleep = true;
                    time = times[0]+300000;

                    Log.d("----------","user is sleeping and time is "+time);
                }

                times[0] = times[1];
            }

            accs[0] = accs[1];

        }

//        if(dateValueEntityX.getDate() != date){
//            dateValueEntityX.setDate(date);
//            dateValueEntityX.setValue(values[0]);

//            dateValueEntityY.setDate(date);
//            dateValueEntityY.setValue(values[1]);
//
//            dateValueEntityZ.setDate(date);
//            dateValueEntityZ.setValue(values[2]);

            handler.sendEmptyMessage(1);
//        }

//        datas_x.add(dateValueEntityX);
//        datas_y.add(dateValueEntityY);
//        datas_z.add(dateValueEntityZ);

//        datas.add(dateValueEntityX);
//        datas.add(datas_y);
//        datas.add(datas_z);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
