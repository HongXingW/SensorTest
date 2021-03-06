package com.example.sensortest;

/**
 * Created by whx on 2016/2/20.
 */
public class DateValueEntity implements IHasDate {

    private int date;
    private float value;

    /**
     * <p>
     * Constructor of DateValueEntity
     * </p>
     * <p>
     * DateValueEntity类对象的构造函数
     * </p>
     * <p>
     * DateValueEntityのコンストラクター
     * </p>
     *
     * @param date
     * @param value
     */
    public DateValueEntity(float value, int date) {
        super();
        this.value = value;
        this.date = date;
    }

    public DateValueEntity(){

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

    /**
     * @return the value
     */
    public float getValue() {
        return value;
    }

    /**
     * @param value
     *            the value to set
     */
    public void setValue(float value) {
        this.value = value;
    }
}
