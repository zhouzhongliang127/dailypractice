package com.exerproject10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzl
 * @Description
 * @date 2021/10/11 - 16:09
 */
public class DAOTest {

    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();

        dao.save("1001",new User(1001,20,"zzl"));
        dao.save("1002",new User(1002,23,"zk"));
        dao.save("1003",new User(1003,25,"lb"));

        dao.update("1003",new User(1003,25,"fws"));

        List<User> list = new ArrayList<>();
        list = dao.list();
        list.forEach(System.out::println);
    }
}
