package com.cai.customer;

import java.io.*;

public class IODay_01_IO_stream {
    public static void main(String[] args) throws IOException {
        read();
        readNoEnter();
        readThrift();
        readUnknown();
    }

    public static void write() throws IOException {
        File file = new File("D:" + File.separator + "hello.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        OutputStream os = new FileOutputStream(file);
        byte [] bytes = "你好".getBytes();
        os.write(bytes);

        os.write("\r\nIO".getBytes());
        os.close();
    }

    /**
     * 字节流
     * 读文件内容
     * 读取出来会有大量的空格
     * @throws IOException
     */
    public static void read() throws IOException {
        File file = new File("D:" + File.separator + "hello.txt");
        InputStream in = new FileInputStream(file);
        byte [] bytes = new byte[1000];
        in.read(bytes);
        System.out.println(new String(bytes));
        in.close();
    }

    /**
     * 字节流
     * 读文件内容
     * 不会有空格
     * @throws IOException
     */
    public static void readNoEnter() throws IOException {
        File file = new File("D:" + File.separator + "hello.txt");
        InputStream in = new FileInputStream(file);
        byte [] bytes = new byte[1000];
        int len = in.read(bytes);
        System.out.println(new String(bytes,0 ,len));
        System.out.println("memory:" + bytes.length);
        in.close();
    }

    /**
     * 字节流
     * 读文件内容
     * 不会有空格
     * 更节约空间
     * @throws IOException
     */
    public static void readThrift() throws IOException {
        File file = new File("D:" + File.separator + "hello.txt");
        InputStream in = new FileInputStream(file);
        byte[] bytes = new byte[(int) file.length()];
        in.read(bytes);
        System.out.println(new String(bytes));
        System.out.println("memory:" + bytes.length);
        in.close();
    }


    /**
     * 字节流
     * 读文件内容
     * 不会有空格
     * 一个字节一个字节读
     * 当独到文件末尾的时候会返回-1.正常情况下是不会返回-1的
     * @throws IOException
     */
    public static void readUnknown() throws IOException {
        File file = new File("D:" + File.separator + "hello.txt");
        InputStream in = new FileInputStream(file);
        byte[] b=new byte[(int) file.length()];
        int count =0;
        int temp=0;
        while ((temp = in.read()) != -1){
            b[count++] = (byte) temp;
        }
        in.close();
        System.out.println(new String(b));
    }
}
