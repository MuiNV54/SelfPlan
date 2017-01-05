package com.fernandocejas.android10.sample.data.cache.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by FRAMGIA\nguyen.van.mui on 04/01/2017.
 */

@Table(name = "Tasks")
public class Task extends Model {
    @Column(name = "Amount")
    private int amount;
    @Column(name = "Description")
    private String description;
    @Column(name = "Descrease")
    private boolean descrease;
    @Column(name = "Category")
    private Category category;

    public Task() {
        super();
    }

    public Task(int amount, String description, boolean descrease, Category category) {
        super();
        this.amount = amount;
        this.description = description;
        this.descrease = descrease;
        this.category = category;
    }
}
