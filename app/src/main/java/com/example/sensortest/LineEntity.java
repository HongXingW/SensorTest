package com.example.sensortest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by whx on 2016/2/19.
 */
public class LineEntity<T> {

    /**
     * <p>
     * Data for draw this line
     * </p>
     * <p>
     * ラインを表示用データ
     * </p>
     * <p>
     * 线表示数据
     * </p>
     */
    private List<T> lineData;

    /**
     * <p>
     * Title for this line
     * </p>
     * <p>
     * ラインの表示タイトル
     * </p>
     * <p>
     * 线的标题，用于标识别这条线
     * </p>
     */
    private String title;

    /**
     * <p>
     * Line Color
     * </p>
     * <p>
     * ラインの色
     * </p>
     * <p>
     * 线的颜色
     * </p>
     */
    private int lineColor;

    /**
     * <p>
     * Should display this line?
     * </p>
     * <p>
     * ラインをチャードで表面で表示するか?
     * </p>
     * <p>
     * 是否在图表上显示该线
     * </p>
     */
    private boolean display = true;

    /**
     * <p>
     * Constructor of LineEntity
     * </p>
     * <p>
     * LineEntity类对象的构造函数
     * </p>
     * <p>
     * LineEntityのコンストラクター
     * </p>
     *
     */
    public LineEntity() {
        super();
    }

    /**
     * <p>
     * Constructor of LineEntity
     * </p>
     * <p>
     * LineEntity类对象的构造函数
     * </p>
     * <p>
     * LineEntityのコンストラクター
     * </p>
     *
     * @param lineData
     *            <p>
     *            Data for draw this line
     *            </p>
     *            <p>
     *            ラインを表示用データ
     *            </p>
     *            <p>
     *            线表示数据
     *            </p>
     * @param title
     *            <p>
     *            Title for this line
     *            </p>
     *            <p>
     *            ラインの表示タイトル
     *            </p>
     *            <p>
     *            线的标题，用于标识别这条线
     *            </p>
     * @param lineColor
     *            <p>
     *            Line Color
     *            </p>
     *            <p>
     *            ラインの色
     *            </p>
     *            <p>
     *            线的颜色
     *            </p>
     */
    public LineEntity(List<T> lineData, String title, int lineColor) {
        super();
        this.lineData = lineData;
        this.title = title;
        this.lineColor = lineColor;
    }

    /**
     * @param value
     */
    public void put(T value) {
        if (null == lineData) {
            lineData = new ArrayList<T>();
        }
        lineData.add(value);
    }

    /**
     * @return the lineData
     */
    public List<T> getLineData() {
        return lineData;
    }

    /**
     * @param lineData
     *            the lineData to set
     */
    public void setLineData(List<T> lineData) {
        this.lineData = lineData;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the lineColor
     */
    public int getLineColor() {
        return lineColor;
    }

    /**
     * @param lineColor
     *            the lineColor to set
     */
    public void setLineColor(int lineColor) {
        this.lineColor = lineColor;
    }

    /**
     * @return the display
     */
    public boolean isDisplay() {
        return display;
    }

    /**
     * @param display
     *            the display to set
     */
    public void setDisplay(boolean display) {
        this.display = display;
    }
}
