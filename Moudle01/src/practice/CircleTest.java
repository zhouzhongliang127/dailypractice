package practice;

/**
 * @author zzl
 * @Description
 * @date 2021/9/27 - 20:41
 */
class Circle{
    double radius;

    public double findArea(){
        return Math.PI*radius*radius;
    }
}

class PassObject{
    public void printAreas(Circle c,int time){
        for (int i = 1; i <= time ; i++) {
            c = new Circle();
            c.radius = i;
            System.out.println(c.radius+"\t"+c.findArea());

        }
    }
}
public class CircleTest {
    public static void main(String[] args) {
        PassObject v = new PassObject();
        Circle c = new Circle();
        v.printAreas(c,5);
    }
}
