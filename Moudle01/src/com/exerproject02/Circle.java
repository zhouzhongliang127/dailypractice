package com.exerproject02;

/**
 * @author zzl
 * @Description
 * @date 2021/9/29 - 23:39
 */
public class Circle extends GeometricObject {
    private double radius;

    public Circle(String color, double weight,double radius) {
        super(color, weight);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if( o == this) return true;
        if(o instanceof Circle){
            //能否点出来看左边，circle指向堆中的一个Circle对象
            Circle circle = (Circle)o;
            return radius == circle.radius;
        }
        return false;
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Circle circle = (Circle) o;
//        return Double.compare(circle.radius, radius) == 0;
    }



    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double findArea(){
        return Math.PI * radius * radius;
    }
}
