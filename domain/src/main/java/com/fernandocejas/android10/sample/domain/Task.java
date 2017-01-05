package com.fernandocejas.android10.sample.domain;

/**
 * Created by FRAMGIA\nguyen.van.mui on 27/12/2016.
 */

public class Task {
    private long id;
    private int amount;
    private String description;
    private boolean descrease;
    private Category category;

    public Task(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDescrease() {
        return descrease;
    }

    public void setDescrease(boolean descrease) {
        this.descrease = descrease;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
