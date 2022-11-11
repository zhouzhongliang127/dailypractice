package com.exerproject10;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author zzl
 * @Description
 * @date 2021/10/12 - 15:49
 */
public class FileInputOutStreamTest {
    @Test
    public void testFileInputStream(){
        //对于字节流，如果直接对读出来的字节数组进行转化成字符，中文可能被截断出现乱码
        //所以可以将字节输入流转化为字符输入流在进行操作，或者用ByteArrayOutputStream
        //将所有字节先缓冲在转换
        FileInputStream fis = null;
        InputStreamReader isr = null;
        try {
            fis = new FileInputStream(new File("hello.txt"));
            isr = new InputStreamReader(fis);
            char[] buffer = new char[5];
//            byte[] buffer = new byte[5];
            int len ;
            //fis.read
            while ((len = isr.read(buffer)) != -1){
                String str = new String(buffer,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //close
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testFileInputStream1(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File("4.jpg");
            File destFile = new File("5.jpg");

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //复制的过程
            byte[] buffer = new byte[5];
            int len;
            while((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //close
            try {
                if (fis != null)
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    //指定路径下文件复制操作
    public void copyFile(String srcPath, String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //复制的过程
            byte[] buffer = new byte[5];
            int len;
            while((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //close
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
