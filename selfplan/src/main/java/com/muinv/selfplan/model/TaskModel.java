package com.muinv.selfplan.model;

/**
 * Created by FRAMGIA\nguyen.van.mui on 27/12/2016.
 */

public class TaskModel {
    private long id;
    private int amount;
    private String description;
    private boolean descrease;
    private CategoryModel categoryModel;

    public TaskModel(long id) {
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

    public CategoryModel getCategoryModel() {
        return categoryModel;
    }

    public void setCategoryModel(CategoryModel categoryModel) {
        this.categoryModel = categoryModel;
    }
}
