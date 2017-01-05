package com.fernandocejas.android10.sample.domain;

/**
 * Created by FRAMGIA\nguyen.van.mui on 27/12/2016.
 */

public class Category {
    private long id;
    private String unit;
    private String content;
    private String icon;
    private String color;

    public Category(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
