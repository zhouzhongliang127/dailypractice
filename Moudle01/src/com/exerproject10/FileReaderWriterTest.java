package com.exerproject10;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author zzl
 * @Description
 * @date 2021/10/12 - 14:36
 */
public class FileReaderWriterTest {

    @Test
    public void testFileReader(){
        FileReader reader = null;
        try {
            //实例化File类的对象，指明操作对象
            File file = new File("hello.txt");
            //提供具体的流
            reader = new FileReader(file);
            //数据的读入
            int data = reader.read();
            while (data != -1){
                System.out.print((char) data);
                data = reader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if(reader != null)
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFileReader1(){
        FileReader fr =null;
        try {
            //File类的实例化
            File file = new File("孔乙己.txt");
            //FileReader流的实例化
             fr = new FileReader(file);
            //读入的操作
            char[] cbuf = new char[5];
            int len ;
            while ((len = fr.read(cbuf)) != -1){
                for (int i = 0; i < len; i++) {
                    System.out.print(cbuf[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源的关闭
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void testFileWriter(){
        FileWriter fw = null;
        try {
            //实例化File类的对象，指明到写出的文件
            File file = new File("hello1.txt");
            //提供FileWriter的对象，用于数据的写出
            //append指明是否追加
            fw = new FileWriter(file,true);
            //写出的操作
            fw.write("i have a dream\n");
            fw.write("you also need have a dream");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void testFileReaderFileWriter(){
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //指明读入和写出的对象
            File scrFile = new File("hello1.txt");
            File destFile = new File("hello2.txt");
            //创建输入流和输出流的对象
            fr = new FileReader(scrFile);
            fw  = new FileWriter(destFile,true);
            //数据的读入和写出操作
            char[] c = new char[8];
            int len;
            while ((len = fr.read(c)) != -1){
                fw.write(c,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //资源流的关闭
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
