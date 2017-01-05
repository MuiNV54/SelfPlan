package com.fernandocejas.android10.sample.data.cache.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by FRAMGIA\nguyen.van.mui on 04/01/2017.
 */

@Table(name = "Categories")
public class Category extends Model {
    @Column(name = "Unit")
    public String unit;
    @Column(name = "Content")
    public String content;
    @Column(name = "Icon")
    public String icon;
    @Column(name = "Color")
    public String color;

    public Category() {
        super();
    }

    public Category(String unit, String content, String icon, String color) {
        super();
        this.unit = unit;
        this.content = content;
        this.icon = icon;
        this.color = color;
    }
}
