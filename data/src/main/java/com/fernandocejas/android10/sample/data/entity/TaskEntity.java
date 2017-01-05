package com.fernandocejas.android10.sample.data.entity;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by FRAMGIA\nguyen.van.mui on 30/12/2016.
 */

@Table(name = "Tasks")
public class TaskEntity extends Model {
    @Column(name = "Amount")
    public int amount;
    @Column(name = "Description")
    public String description;
    @Column(name = "Descrease")
    public boolean descrease;
    @Column(name = "Category")
    public CategoryEntity category;

    public TaskEntity() {
        super();
    }

    public TaskEntity(int amount, String description, boolean descrease, CategoryEntity category) {
        super();
        this.amount = amount;
        this.description = description;
        this.descrease = descrease;
        this.category = category;
    }
}
