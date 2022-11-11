package com.exerproject05;

/**
 * @author zzl
 * @Description
 * @date 2021/10/4 - 12:53
 */

class MyThread extends Thread{
    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     * @see #Thread(ThreadGroup, Runnable, String)
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0) System.out.println(i);
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();

    }

}
