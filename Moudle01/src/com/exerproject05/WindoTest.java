package com.exerproject05;

import static java.lang.Thread.sleep;

/**
 * @author zzl
 * @Description
 * @date 2021/10/4 - 16:25
 */
class Window1 implements Runnable{
    private static int ticket  =100;

    final Object obj = new Object();

    @Override
    public void run() {
        while (true){
            show();
        }
    }

    private synchronized void show(){//默认用this作为锁，这里都为之前的p
        if (ticket > 0 ) {

            try {
                //sleep了其他线程也得等着
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":买票，票号为"+ticket);
            ticket--;
        }else {
            System.exit(0);
        }
    }

}

public class WindoTest {
    public static void main(String[] args) {
        Window1 p = new Window1();

        Thread w1 = new Thread(p);
        Thread w2 = new Thread(p);
        Thread w3 = new Thread(p);

        w1.setName("Window_1");
        w2.setName("Window_2");
        w3.setName("Window_3");
        w1.start();
        w2.start();
        w3.start();

    }
}
