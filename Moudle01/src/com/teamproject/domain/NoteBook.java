package com.teamproject.domain;

/**
 * @author zzl
 * @Description
 * @date 2021/10/3 - 8:45
 */
public class NoteBook implements Equipment{

    private String model;//笔记本型号
    private double price;//价格

    public NoteBook(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getDescription() {
        return model+"("+price+")";
    }
}
