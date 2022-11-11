package com.exerproject10;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author zzl
 * @Description
 * @date 2021/10/13 - 16:11
 */
public class BufferedStreamTest {
    //实现非文本文件的复制
    @Test
    public void BufferedStreamTest() throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //造文件
            File srcFile = new File("星空.jpg");
            File destFile = new File("星空1.jpg");
            //造流
            //造节点流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //复制的细节：读取，写入
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //close
            //先关外层，再管里层
            bos.close();
            bis.close();
            //说明：外层关闭的同时内层也自动关了
            fos.close();
            fis.close();
        }

    }

    @Test
    public void testBufferedReaderWriter(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader("hello2.txt"));
            bw = new BufferedWriter(new FileWriter("hello3.txt"));
            //读写操作
            char[]  buffer = new char[10];
            int len ;
            while ((len = br.read(buffer)) != -1){
                bw.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //close

            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
