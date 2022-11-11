package com.exerproject12;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author zzl
 * @Description
 * @date 2021/10/14 - 16:55
 */
public class ReflectionTest {
    @Test
    public void test1() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<Person> clazz = Person.class;
        Constructor<Person> cons = clazz.getConstructor(String.class, int.class);

        Person person = cons.newInstance("Tom", 12);

        System.out.println(person);

        Field age = clazz.getDeclaredField("age");
        age.set(person,10);
        System.out.println(person.toString());

    }

    @Test
    public void test2(){
        Class clazz = Person.class;

        try {
            Person obj = (Person) clazz.newInstance();
            System.out.println(obj);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
