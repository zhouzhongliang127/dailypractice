package com.exerproject03;

/**
 * @author zzl
 * @Description
 * @date 2021/9/30 - 18:42
 */
public class Circle {

    public static void main(String[] args) {

        Circle c1 = new Circle();
        Circle c2 = new Circle();

        System.out.println("c1的id:"+ c1.getId());
        System.out.println("c2的id:"+ c2.getId());

        System.out.println(Circle.total);
    }


    private double radius;
    private int id;

    private static int total;
    private static int init = 1001;


    public Circle(){
        id = init++;
        total++;//每创建一个对象就加一
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getId() {
        return id;
    }



    public double findArea(){
        return Math.PI * radius * radius;
    }
}
