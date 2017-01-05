package com.fernandocejas.android10.sample.data.entity;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by FRAMGIA\nguyen.van.mui on 27/12/2016.
 */

@Table(name = "Categories")
public class CategoryEntity extends Model {
    @Column(name = "Unit")
    public String unit;
    @Column(name = "Content")
    public String content;
    @Column(name = "Icon")
    public String icon;
    @Column(name = "Color")
    public String color;

    public CategoryEntity() {
        super();
    }

    public CategoryEntity(String unit, String content, String icon, String color) {
        super();
        this.unit = unit;
        this.content = content;
        this.icon = icon;
        this.color = color;
    }
}
