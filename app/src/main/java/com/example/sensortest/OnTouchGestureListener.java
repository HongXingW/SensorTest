package com.example.sensortest;

import android.graphics.PointF;
import android.view.MotionEvent;

/**
 * Created by whx on 2016/2/19.
 */
public class OnTouchGestureListener {
    public void onTouchDown(ITouchable touchable,MotionEvent event){
        if (touchable != null) {
            touchable.touchDown(new PointF(event.getX(),event.getY()));
        }
    }

    public void onTouchMoved(ITouchable touchable,MotionEvent event){
        if (touchable != null) {
            touchable.touchMoved(new PointF(event.getX(),event.getY()));
        }
    }

    public void onTouchUp(ITouchable touchable,MotionEvent event){
        if (touchable != null) {
            touchable.touchUp(new PointF(event.getX(),event.getY()));
        }
    }
}
