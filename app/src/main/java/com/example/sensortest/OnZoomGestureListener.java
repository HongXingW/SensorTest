package com.example.sensortest;

import android.view.MotionEvent;

/**
 * Created by whx on 2016/2/19.
 */
public class OnZoomGestureListener {
    public void onZoomIn(IZoomable zoomable, MotionEvent event){
        if (zoomable != null) {
            zoomable.zoomIn();
        }
    }

    public void onZoomOut(IZoomable zoomable, MotionEvent event){
        if (zoomable != null) {
            zoomable.zoomOut();
        }
    }
}

