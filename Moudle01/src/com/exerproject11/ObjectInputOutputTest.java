package com.exerproject11;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author zzl
 * @Description
 * @date 2021/10/13 - 22:28
 */
public class ObjectInputOutputTest {
    @Test
    public void testObjectStream(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));

            oos.writeObject(new String("i like my family"));

            oos.flush();

            oos.writeObject(new Person("zzl",21));

            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void testObjectInputStream(){

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));
            Object obj = ois.readObject();
            String str = (String) obj;
            System.out.println(str);
            //read后指针下移
            Object o = ois.readObject();
            Person p = (Person) o;
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void RandomAccessFileTest() throws IOException {
        RandomAccessFile rf = new RandomAccessFile("孔乙己.txt","rw");

        //StringBuilder str = new StringBuilder();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len;
        byte[] buffer = new byte[20];
        while ( (len = rf.read(buffer)) != -1){
            //str.append(new String(buffer,0,len));

            baos.write(buffer,0,len);
        }
        System.out.println(baos.toString());
        baos.close();
        rf.close();

    }
}
