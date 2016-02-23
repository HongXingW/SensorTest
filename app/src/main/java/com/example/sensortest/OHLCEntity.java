package com.example.sensortest;

/**
 * Created by whx on 2016/2/20.
 */
public class OHLCEntity implements IStickEntity {

    /**
     * <p>
     * Open Value
     * </p>
     * <p>
     * 始値
     * </p>
     * <p>
     * 开盘价
     * </p>
     */
    private double open;

    /**
     * <p>
     * High Value
     * </p>
     * <p>
     * 高値
     * </p>
     * <p>
     * 最高价
     * </p>
     *
     */
    private double high;

    /**
     * <p>
     * Low Value
     * </p>
     * <p>
     * 低値
     * </p>
     * <p>
     * 最低价
     * </p>
     *
     */
    private double low;

    /**
     * <p>
     * Close Value
     * </p>
     * <p>
     * 終値
     * </p>
     * <p>
     * 收盘价
     * </p>
     *
     */
    private double close;

    /**
     * <p>
     * Date
     * </p>
     * <p>
     * 日付
     * </p>
     * <p>
     * 日期
     * </p>
     *
     */
    private int date;

    /**
     *
     * <p>
     * Constructor of OHLCEntity
     * </p>
     * <p>
     * OHLCEntity类对象的构造函数
     * </p>
     * <p>
     * OHLCEntityのコンストラクター
     * </p>
     *
     * @param open
     *            <p>
     *            Open Value
     *            </p>
     *            <p>
     *            始値
     *            </p>
     *            <p>
     *            开盘价
     *            </p>
     * @param high
     *            <p>
     *            High Value
     *            </p>
     *            <p>
     *            高値
     *            </p>
     *            <p>
     *            最高价
     *            </p>
     * @param low
     *            <p>
     *            Low Value
     *            </p>
     *            <p>
     *            低値
     *            </p>
     *            <p>
     *            最低价
     *            </p>
     * @param close
     *            <p>
     *            Close Value
     *            </p>
     *            <p>
     *            終値
     *            </p>
     *            <p>
     *            收盘价
     *            </p>
     * @param date
     *            <p>
     *            Date
     *            </p>
     *            <p>
     *            日付
     *            </p>
     *            <p>
     *            日期
     *            </p>
     */
    public OHLCEntity(double open, double high, double low, double close,
                      int date) {
        super();
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.date = date;
    }

    /**
     * <p>
     * Constructor of OHLCEntity
     * </p>
     * <p>
     * OHLCEntity类对象的构造函数
     * </p>
     * <p>
     * OHLCEntityのコンストラクター
     * </p>
     *
     */
    public OHLCEntity() {
        super();
    }

    /**
     * @return the open
     */
    public double getOpen() {
        return open;
    }

    /**
     * @param open
     *            the open to set
     */
    public void setOpen(double open) {
        this.open = open;
    }

    /**
     * @return the high
     */
    public double getHigh() {
        return high;
    }

    /**
     * @param high
     *            the high to set
     */
    public void setHigh(double high) {
        this.high = high;
    }

    /**
     * @return the low
     */
    public double getLow() {
        return low;
    }

    /**
     * @param low
     *            the low to set
     */
    public void setLow(double low) {
        this.low = low;
    }

    /**
     * @return the close
     */
    public double getClose() {
        return close;
    }

    /**
     * @param close
     *            the close to set
     */
    public void setClose(double close) {
        this.close = close;
    }

    /**
     * @return the date
     */
    public int getDate() {
        return date;
    }

    /**
     * @param date
     *            the date to set
     */
    public void setDate(int date) {
        this.date = date;
    }
}
