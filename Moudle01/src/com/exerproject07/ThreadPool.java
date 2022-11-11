package com.exerproject07;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zzl
 * @Description
 * @date 2021/10/5 - 13:59
 */

class NumberThread implements Runnable{

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0)
            System.out.println(Thread.currentThread().getName()+":i = " + i);
        }
    }
}
class NumberThread1 implements Runnable{

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0)
            System.out.println(Thread.currentThread().getName()+":i = " + i);
        }
    }
}
public class ThreadPool {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);


        service.execute(new NumberThread());//适用于Runnable
        service.execute(new NumberThread1());
        //service.submit();//适用于Callable

        service.shutdown();
    }
}
