package com.example.sensortest;

import android.graphics.Color;

/**
 * Created by whx on 2016/2/19.
 */
public interface ICrossLines {
    static final int BIND_TO_TYPE_NONE = 0;
    static final int BIND_TO_TYPE_HIRIZIONAL = 1;
    static final int BIND_TO_TYPE_VERTICAL = 2;
    static final int BIND_TO_TYPE_BOTH = 3;

    static final int DISPLAY_NONE = 0;
    static final int DISPLAY_HIRIZIONAL = 1;
    static final int DISPLAY_VERTICAL = 2;
    static final int DISPLAY_BOTH = 3;

    static final int DEFAULT_CROSS_LINES_COLOR = Color.CYAN;
    static final int DEFAULT_CROSS_LINES_FONT_COLOR = Color.CYAN;

    /**
     * <p>
     * Should display the Y cross line if grid is touched?
     * </p>
     * <p>
     * タッチしたポイントがある場合、十字線の垂直線を表示するか?
     * </p>
     * <p>
     * 默认在控件被点击时，显示十字竖线线
     * </p>
     */
    public static final boolean DEFAULT_DISPLAY_CROSS_X_ON_TOUCH = true;

    /**
     * <p>
     * Should display the Y cross line if grid is touched?
     * </p>
     * <p>
     * タッチしたポイントがある場合、十字線の水平線を表示するか?
     * </p>
     * <p>
     * 默认在控件被点击时，显示十字横线线
     * </p>
     */
    public static final boolean DEFAULT_DISPLAY_CROSS_Y_ON_TOUCH = true;

}
