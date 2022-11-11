package com.exerproject02;

/**
 * @author zzl
 * @Description
 * @date 2021/9/29 - 23:40
 */
public class MyRectangle extends GeometricObject {

    private double width;
    private double height;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyRectangle that = (MyRectangle) o;
        return Double.compare(that.width, width) == 0 && Double.compare(that.height, height) == 0;
    }


    public MyRectangle(String color, double weight, double width, double height) {
        super(color, weight);
        this.height = height;
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double findArea(){
        return width * height;
    }
}
