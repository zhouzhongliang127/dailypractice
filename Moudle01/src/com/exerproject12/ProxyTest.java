package com.exerproject12;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zzl
 * @Description
 * @date 2021/10/14 - 21:40
 */
interface Human{
    String getBelief();
    void eat(String food);
}

class Superman implements Human{
    @Override
    public String getBelief() {
        return "I believe i can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("I like eat "+food);
    }
}

class ProxyFactory{
    //调用此方法，根据不同的被代理类返回一个代理类的对象。解决问题一
    public static Object getProxyInstance(Object obj){

        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),handler);
    }
}

class MyInvocationHandler implements InvocationHandler{

    private Object obj;//使用被代理类的对象进行赋值

    public void bind(Object obj){
        this.obj = obj;
    }
    //当我们通过代理类的对象调用方法a时，就会自动调用以下方法
    //将被代理类要执行的方法a写在invoke中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //method：为代理类对象所调用的方法，所以也作为被代理类要调用的方法
        //obj:被代理类的对象
        Object returnVal = method.invoke(obj,args);
        //上述方法的返回值作为invoke的返回值
        return returnVal;
    }
}
public class ProxyTest {

    public static void main(String[] args) {
        Superman superman = new Superman();
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superman);
        //会自动执行被代理类中同名的方法
        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("四川麻辣烫");


    }
}
