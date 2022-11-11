package com.exerproject11;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zzl
 * @Description
 * @date 2021/10/14 - 14:03
 */
public class TCPTest2 {
    @Test
    public void server(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        OutputStream os = null;
        try {
            ss = new ServerSocket(8899);
            socket = ss.accept();
            is = socket.getInputStream();
            fos = new FileOutputStream("星空2.jpg");
            int len;
            byte[] buffer = new byte[1024];
            //客户端传完之后需要告诉服务器已经传完了，不然服务器会阻塞在这个循环
            while ((len = is.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
            //服务器端反馈接收成功的信息
            os = socket.getOutputStream();
            os.write("接收成功！".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        try {
            InetAddress inet = InetAddress.getByName("localhost");
            socket = new Socket(inet,8899);
            os = socket.getOutputStream();
            fis = new FileInputStream("星空.jpg");
            int len;
            byte[] buffer = new byte[1024];
            while ((len = fis.read(buffer)) != -1){
                os.write(buffer,0,len);
            }
            socket.shutdownOutput();
            //接收服务器反馈
            InputStream is = socket.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] bufferr = new byte[20];
            int len1;
            while ((len1 = is.read(bufferr)) != -1){
                baos.write(bufferr,0,len1);
            }
            System.out.println(baos.toString());

            baos.close();
            is.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (os != null)
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null)
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
