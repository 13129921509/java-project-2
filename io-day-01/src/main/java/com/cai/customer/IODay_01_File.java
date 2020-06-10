package com.cai.customer;

import java.io.File;
import java.util.Arrays;

public class IODay_01_File {
    public static void main(String[] args) {
        File file = new File("d:\\hello.txt");
        try {
            file.createNewFile(); //创建新文件，核心为native方法
            System.out.println(File.pathSeparator);
            System.out.println(File.separator);
//            showDirListPath();
            deleteFile();
            deepSearchDir("D:" + File.separator + "flutter_project");
        }catch (Throwable e){
            e.printStackTrace();
        }
    }

    /**
     * 列出指定目录的全部文件命名（包括隐藏文件）：
     */
    public static void showDirListName(){
        String path = "d:" + File.separator;
        File file = new File(path);
        String [] list = file.list();
        Arrays.asList(list).forEach((String str)->{
            System.out.println(str);
        });
    }

    /**
     * 列出指定目录的全部文件命名（包括隐藏文件）：
     */
    public static void showDirListPath(){
        String path = "d:" + File.separator;
        File file = new File(path);
        File [] list = file.listFiles();
        Arrays.asList(list).forEach((File str)->{
            System.out.println(str);
        });
    }

    /**
     * 删除某个文件
     */
    public static void deleteFile(){
        File path = new File("D:" + File.separator +"hello.txt");
        if (!path.isDirectory()){
            if (path.exists()){
                path.delete();
            }else {
                System.out.println("不存在");
            }
        }
    }

    /**
     *
     */
    public static void deepSearchDir(String path){
        File [] files = new File(path).listFiles();
        Arrays.asList(files).forEach((File name)->{
            if (name.isDirectory()){
                System.out.println(name);
                deepSearchDir(name.toString());
            }
        });
    }
}
