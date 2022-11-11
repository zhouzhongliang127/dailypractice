package com.exerproject05;

import static java.lang.Thread.sleep;

/**
 * @author zzl
 * @Description
 * @date 2021/10/4 - 13:10
 */

class Window implements Runnable{
    private static int ticket  =100;

    Object obj = new Object();

    @Override
    public void run() {
        while (true){
            //一定要公用一把锁，最好是放在公共的地方声明
            synchronized (obj){
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
                break;
            }
        }
        }
    }

}

public class ThreadDemo {
    public static void main(String[] args) {
        Window p = new Window();

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
