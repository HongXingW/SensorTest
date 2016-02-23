package com.example.sensortest;

/**
 * Created by whx on 2016/2/19.
 */
public class HorizontalAxis extends Axis {
    protected float height;
    /**
     * <p>Constructor of HorizontalAxis</p>
     * <p>HorizontalAxis类对象的构造函数</p>
     * <p>HorizontalAxisのコンストラクター</p>
     *
     * @param inChart
     * @param position
     */
    public HorizontalAxis(GridChart inChart, int position , float height) {
        super(inChart, position);
        this.height = height;
    }

    /* (non-Javadoc)
     *
     * @return
     * @see cn.limc.androidcharts.common.IQuadrant#getQuadrantWidth()
     */
    public float getQuadrantWidth() {
        return inChart.getWidth() - 2 * inChart.getBorderWidth();
    }

    /* (non-Javadoc)
     *
     * @return
     * @see cn.limc.androidcharts.common.IQuadrant#getQuadrantHeight()
     */
    public float getQuadrantHeight() {
        return height;
    }

}
