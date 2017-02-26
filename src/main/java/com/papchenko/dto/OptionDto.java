package com.papchenko.dto;

/**
 * Created by user on 26.02.2017.
 */
public class OptionDto {
    private int id;
    private String text;
    private double percent;

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public double getPercent() {
        return percent;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
}
