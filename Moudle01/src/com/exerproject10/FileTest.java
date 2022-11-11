package com.exerproject10;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author zzl
 * @Description
 * @date 2021/10/11 - 16:48
 */
public class FileTest {
    @Test
    public void test1() throws IOException {
        File file1 = new File("D:\\FileTest");
        File file2 = new File("D:\\FileTest\\hello1.txt");
        File file3 = new File("D:\\FileTest\\hello2.txt");
        File file4 = new File("D:\\FileTest\\he");


        file1.mkdir();
        file2.createNewFile();
        file3.createNewFile();
        file4.mkdir();
        File[] list = file1.listFiles();
        for (File file : list) {

            if (file.isFile()){
                System.out.println(file.getName());
            }else {
                File f = new File(file.getPath());
                f.list();
            }
        }

        String[] list1 = file1.list();
        for (String s : list1) {
            String[] strings = s.split("\\.");
            for (String string : strings) {
                System.out.println(string);
            }
            if(strings.length == 2){
                if(strings[1].equals("jpg")){
                    System.out.println(s);
                }
            }
        }

//        System.out.println("-----------------------");
//
//        File f = new File("D:\\我的下载");
//        printFiles(f);
    }
//递归遍历一个文件夹下面的所有文件和文件夹
    public static void printFiles(File dir){
        File[] subFiles = dir.listFiles();

        for (File subFile : subFiles) {
            if(subFile.isDirectory()){
                printFiles(subFile);
            }
            else{
                System.out.println(subFile.getAbsolutePath());
            }

        }
    }
    //删除指定文件夹和下面的文件
    public static void deleteFile(File file){
        //如果file为文件，直接删除，
        //为文件夹，递归删除下面的内容
        if(file.isDirectory()){
            File[] file1 =file.listFiles();
            for (File file2 : file1) {
                deleteFile(file2);
            }
        }else {
            file.delete();
        }
    }
}
