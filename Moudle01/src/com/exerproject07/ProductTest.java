package com.exerproject07;

/**
 * @author zzl
 * @Description
 * @date 2021/10/5 - 11:36
 */
//生产者消费问题
class Clerk{

    private int product = 0;

    public synchronized void produceProduct() {

        notifyAll();
        if(product < 20){
            System.out.println(Thread.currentThread().getName()+"开始生产第"+(++product)+"个产品");
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumeProduct() {
        notifyAll();
        if(product > 0){
            System.out.println(Thread.currentThread().getName()+"开始消费第"+(product--)+"个产品");
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread{
    private Clerk clerk = new Clerk();

    public Producer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {

        System.out.println(getName()+"开始生产产品");

        while (true){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }
}

class Customer extends Thread{
    private Clerk clerk = new Clerk();

    public Customer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {

        System.out.println(getName()+"开始消费产品");

        while (true){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }

}
public class ProductTest {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);
        p1.setName("生产者—1");

        Customer c1 = new Customer(clerk);
        Customer c2 = new Customer(clerk);

        c1.setName("消费者—1");
        c2.setName("消费者—2");

        p1.start();
        c1.start();
        c2.start();

    }
}
