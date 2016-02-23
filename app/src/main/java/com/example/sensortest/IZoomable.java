package com.example.sensortest;

/**
 * Created by whx on 2016/2/19.
 */
public interface IZoomable extends ITouchable {

    static final int ZOOM_BASE_LINE_CENTER = 0;
    static final int ZOOM_BASE_LINE_LEFT = 1;
    static final int ZOOM_BASE_LINE_RIGHT = 2;

    static final int ZOOM_NONE = 0;
    static final int ZOOM_IN = 1;
    static final int ZOOM_OUT = 2;

    static final int ZOOM_STEP = 4;

    /**
     * <p>
     * Zoom in the graph
     * </p>
     * <p>
     * 拡大表示する。
     * </p>
     * <p>
     * 放大表示
     * </p>
     */
    void zoomIn();

    /**
     * <p>
     * Zoom out the grid
     * </p>
     * <p>
     * 縮小表示する。
     * </p>
     * <p>
     * 缩小
     * </p>
     */
    void zoomOut();

    void setOnZoomGestureListener(OnZoomGestureListener listener);
    OnZoomGestureListener getOnZoomGestureListener();
}
