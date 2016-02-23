package com.example.sensortest;

/**
 * Created by whx on 2016/2/19.
 */
public class CrossLines implements ICrossLines {

    /**
     * <p>
     * Color of cross line inside grid when touched
     * </p>
     * <p>
     * タッチしたポイント表示用十字線の色
     * </p>
     * <p>
     * 十字交叉线颜色
     * </p>
     */
    private int crossLinesColor = DEFAULT_CROSS_LINES_COLOR;

    /**
     * <p>
     * Color of cross line degree text when touched
     * </p>
     * <p>
     * タッチしたポイント表示用十字線度数文字の色
     * </p>
     * <p>
     * 十字交叉线坐标轴字体颜色
     * </p>
     */
    private int crossLinesFontColor = DEFAULT_CROSS_LINES_FONT_COLOR;

    /**
     * <p>
     * Should display the Y cross line if grid is touched?
     * </p>
     * <p>
     * タッチしたポイントがある場合、十字線の垂直線を表示するか?
     * </p>
     * <p>
     * 在控件被点击时，显示十字竖线线
     * </p>
     */
    private boolean displayCrossXOnTouch = DEFAULT_DISPLAY_CROSS_X_ON_TOUCH;

    /**
     * <p>
     * Should display the Y cross line if grid is touched?
     * </p>
     * <p>
     * タッチしたポイントがある場合、十字線の水平線を表示するか?
     * </p>
     * <p>
     * 在控件被点击时，显示十字横线线
     * </p>
     */
    private boolean displayCrossYOnTouch = DEFAULT_DISPLAY_CROSS_Y_ON_TOUCH;

    /**
     * @return the displayCrossXOnTouch
     */
    public boolean isDisplayCrossXOnTouch() {
        return displayCrossXOnTouch;
    }

    /**
     * @param displayCrossXOnTouch
     *            the displayCrossXOnTouch to set
     */
    public void setDisplayCrossXOnTouch(boolean displayCrossXOnTouch) {
        this.displayCrossXOnTouch = displayCrossXOnTouch;
    }

    /**
     * @return the displayCrossYOnTouch
     */
    public boolean isDisplayCrossYOnTouch() {
        return displayCrossYOnTouch;
    }

    /**
     * @param displayCrossYOnTouch
     *            the displayCrossYOnTouch to set
     */
    public void setDisplayCrossYOnTouch(boolean displayCrossYOnTouch) {
        this.displayCrossYOnTouch = displayCrossYOnTouch;
    }

    /**
     * @return the crossLinesColor
     */
    public int getCrossLinesColor() {
        return crossLinesColor;
    }

    /**
     * @param crossLinesColor
     *            the crossLinesColor to set
     */
    public void setCrossLinesColor(int crossLinesColor) {
        this.crossLinesColor = crossLinesColor;
    }

    /**
     * @return the crossLinesFontColor
     */
    public int getCrossLinesFontColor() {
        return crossLinesFontColor;
    }

    /**
     * @param crossLinesFontColor
     *            the crossLinesFontColor to set
     */
    public void setCrossLinesFontColor(int crossLinesFontColor) {
        this.crossLinesFontColor = crossLinesFontColor;
    }
}
