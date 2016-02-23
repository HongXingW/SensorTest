package com.example.sensortest;

/**
 * Created by whx on 2016/2/19.
 */
public interface IFlexableGrid extends IGrid{
    static final int ALIGN_TYPE_CENTER = 0;
    static final int ALIGN_TYPE_JUSTIFY = 1;

    float longitudePostOffset();
    float longitudeOffset();
}

