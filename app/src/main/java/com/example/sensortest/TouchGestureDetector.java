package com.example.sensortest;

import android.graphics.PointF;
import android.view.MotionEvent;

/**
 * Created by whx on 2016/2/19.
 */
public class TouchGestureDetector<T extends ITouchable> implements IGestureDetector{

    protected PointF touchPoint;
    static final int TOUCH_MOVE_MIN_DISTANCE = 6;

    protected T instance;
    protected OnTouchGestureListener onTouchGestureListener;

    /**
     * <p>Constructor of TouchGestureDetector</p>
     * <p>TouchGestureDetector类对象的构造函数</p>
     * <p>TouchGestureDetectorのコンストラクター</p>
     *
     */
    public TouchGestureDetector(T touchable) {
        instance = touchable;
        if (touchable != null) {
            this.onTouchGestureListener = touchable.getOnTouchGestureListener();
        }
    }

    /**
     *
     * <p>Constructor of TouchGestureDetector</p>
     * <p>TouchGestureDetector类对象的构造函数</p>
     * <p>TouchGestureDetectorのコンストラクター</p>
     *
     * @param touchGestureListener
     */
    public TouchGestureDetector(OnTouchGestureListener touchListener) {
        super();
        this.onTouchGestureListener = touchListener;
    }

    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                if (event.getPointerCount() == 1) {
                    touchPoint = new PointF(event.getX(),event.getY());
                    if (onTouchGestureListener != null) {
                        onTouchGestureListener.onTouchDown(instance,event);
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                if (event.getPointerCount() == 1) {
                    touchPoint = new PointF(event.getX(),event.getY());
                    if (onTouchGestureListener != null) {
                        onTouchGestureListener.onTouchUp(instance,event);
                    }
                }
                break;
            case MotionEvent.ACTION_POINTER_UP:
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                // single touch point moved
                if (event.getPointerCount() == 1) {
                    float moveXdistance = Math.abs(event.getX() - touchPoint.x);
                    float moveYdistance = Math.abs(event.getY() - touchPoint.y);
                    if (moveXdistance > TOUCH_MOVE_MIN_DISTANCE ||
                            moveYdistance > TOUCH_MOVE_MIN_DISTANCE) {
                        //reset touchPoint
                        touchPoint = new PointF(event.getX(),event.getY());
                        // call back to listener
                        if (onTouchGestureListener != null) {
                            onTouchGestureListener.onTouchMoved(instance,event);
                        }
                    }
                }
                break;
        }
        return true;
    }

    /**
     * @return the onTouchGestureListener
     */
    public OnTouchGestureListener getOnTouchGestureListener() {
        return onTouchGestureListener;
    }

    /**
     * @param onTouchGestureListener the onTouchGestureListener to set
     */
    public void setOnTouchGestureListener(
            OnTouchGestureListener onTouchGestureListener) {
        this.onTouchGestureListener = onTouchGestureListener;
    }
}