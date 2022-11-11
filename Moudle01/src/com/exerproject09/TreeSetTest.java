package com.exerproject09;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author zzl
 * @Description
 * @date 2021/10/9 - 20:58
 */
public class TreeSetTest {

    @Test
    public void test2(){
        TreeSet<Employee> set = new TreeSet<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;
                    //此处冗余，底层的compareTo方法以及对日期进行了比较，直接返回compareTo的值即可
//                    if(e1.getBirthday().compareTo(e2.getBirthday()) > 0)
//                        return 1;
//                    else if (e1.getBirthday().compareTo(e2.getBirthday()) < 0)
//                        return -1;
//                    else return 0;
                    return e1.getBirthday().compareTo(e2.getBirthday());
            }
        });
        Employee e1 = new Employee("liudeihua",55,new MyDate(1965,5,4));
        Employee e2 = new Employee("guofucheng",45,new MyDate(1945,5,4));
        Employee e3 = new Employee("zhangxueyou",35,new MyDate(1967,5,4));
        Employee e4 = new Employee("liming",25,new MyDate(1966,5,4));
        Employee e5 = new Employee("liangchaogwei",55,new MyDate(1959,5,4));
        Employee e6 = new Employee("liangchaowei",58,new MyDate(1959,5,4));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        set.add(e6);

//        set.forEach(System.ot::println);
//
//        Iterator iterator = set.iterator();
//        while (iterator.hasNext())
//            System.out.println(iterator.next());u

    }

    @Test
    public void test1(){
        TreeSet<Employee> set = new TreeSet<>();

        Employee e1 = new Employee("刘德华",55,new MyDate(1965,5,4));
        Employee e2 = new Employee("郭富城",45,new MyDate(1945,5,4));
        Employee e3 = new Employee("张学友",35,new MyDate(1967,5,4));
        Employee e4 = new Employee("黎明",25,new MyDate(1966,5,4));
        Employee e5 = new Employee("梁朝伟",55,new MyDate(1959,5,4));
        Employee e6 = new Employee("梁朝伟",58,new MyDate(1959,5,4));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        set.add(e6);

//        set.forEach(System.out::println);

        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());

    }
}
