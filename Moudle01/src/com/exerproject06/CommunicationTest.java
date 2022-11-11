package com.exerproject06;

/**
 * @author zzl
 * @Description
 * @date 2021/10/5 - 11:15
 */

class Number implements Runnable{


    private int number = 1;
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

        while(true){
            synchronized (this){
                notifyAll();
                if(number <= 100){
                    System.out.println(Thread.currentThread().getName()+":"+number++);

                    try {
                        wait();//wait会释放锁，sleep不会释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }
        }

    }
}
public class CommunicationTest {
    public static void main(String[] args) {
        Number n = new Number();

        Thread t1 = new Thread(n);
        Thread t2 = new Thread(n);


        t1.setName("线程一");
        t2.setName("线程二");

        t1.start();
        t2.start();
    }

}
