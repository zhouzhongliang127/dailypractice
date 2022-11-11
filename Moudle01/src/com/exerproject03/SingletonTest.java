package com.exerproject03;

/**
 * @author zzl
 * @Description
 * @date 2021/9/30 - 20:52
 */
public class SingletonTest {

    public static void main(String[] args) {
        Order o1 = Order.getInstance();
        Order o2 = Order.getInstance();
        System.out.println(o1 == o2);

    }

}

class Order{

    private Order(){

    }

    private static Order o = null;

    public static Order getInstance(){
        if(o == null){
            o = new Order();
            return o;
        }
        return o;
    }
}