package com.example.sensortest;

/**
 * Created by whx on 2016/2/19.
 */
public class VerticalAxis extends Axis {

    protected float width;
    /**
     * <p>Constructor of VerticalAxis</p>
     * <p>VerticalAxis类对象的构造函数</p>
     * <p>VerticalAxisのコンストラクター</p>
     *
     * @param position
     */
    public VerticalAxis(GridChart inChart, int position , float width) {
        super(inChart,position);
        this.width = width;
    }
    /* (non-Javadoc)
     *
     * @return
     * @see cn.limc.androidcharts.common.IQuadrant#getQuadrantWidth()
     */
    public float getQuadrantWidth() {
        return width;
    }
    /* (non-Javadoc)
     *
     * @return
     * @see cn.limc.androidcharts.common.IQuadrant#getQuadrantHeight()
     */
    public float getQuadrantHeight() {
        return inChart.getHeight() - 2 * inChart.getBorderWidth();
    }
}
