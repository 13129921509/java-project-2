package com.cai.customer;

import java.io.*;

public class IODay_01_IO_ReaderAndWriter {
    public static void main(String[] args) throws IOException {
        write();
    }

    public static void write() throws IOException {
        File f = new File("D:" + File.separator + "hello.txt");
        char [] chars = new char[100];
        Reader reader = new FileReader(f);
        int count = reader.read(chars);
        reader.close();
        System.out.println("读入的长度为："+count);
        System.out.println("内容为\n"+new String(chars,0,count));
    }
}
