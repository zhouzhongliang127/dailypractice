package com.exerproject02;

/**
 * @author zzl
 * @Description
 * @date 2021/9/29 - 23:48
 */

public class GeometricTest {

    public static void main(String[] args) {
        GeometricTest v = new GeometricTest();
        GeometricObject circle = new Circle("blue",0,3);
        GeometricObject myRectangle = new MyRectangle("blue",0,4,3);
        System.out.println("半径为三的圆面积为："
                + v.displayGeometricObject(circle));
        System.out.println("长4高三的矩形面积为"
                +v.displayGeometricObject(myRectangle));
        if(v.equalsArea(circle,myRectangle)){
            System.out.println("circle's Area is bigger");
        }else{
            System.out.println("myRectangle' area is bigger");
        }

        Circle circle1 = new Circle("bule",1,3);
        System.out.println(circle1.equals(circle));

        System.out.println(circle.toString());
        System.out.println(circle1.toString());

    }


    public boolean equalsArea(GeometricObject a,GeometricObject n){
        if(a.findArea() >= n.findArea()) return true;
        else return false;
    }
    public double displayGeometricObject(GeometricObject g){
        return g.findArea();
    }
}
