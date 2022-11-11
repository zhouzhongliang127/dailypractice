package com.exerproject11;

import java.io.Serializable;

/**
 * @author zzl
 * @Description
 * @date 2021/10/13 - 22:41
 */
public class Person implements Serializable {

    public static final long serialVersionUID = 42L;
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
