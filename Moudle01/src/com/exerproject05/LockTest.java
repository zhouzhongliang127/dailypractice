package com.exerproject05;

import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

/**
 * @author zzl
 * @Description
 * @date 2021/10/4 - 20:21
 */
class Window2 implements Runnable{
    private int ticket = 100;
    //创建一把锁
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
           try{
               //调用锁定方法
               lock.lock();
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
           }finally {
               //解锁
               lock.unlock();
           }
        }
    }
}
public class LockTest {
    public static void main(String[] args) {
        Window2 w = new Window2();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.start();
        t2.start();
        t3.start();
    }
}
