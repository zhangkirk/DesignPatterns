package com.lucene;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/9.
 */
public class FileReader {
    public static List<String> ergdoic(File file,List<String> resultFileName){
        File[] files = file.listFiles();
        if(files==null){
            return resultFileName;
        }
        for(File f:files){
            if(!f.isDirectory()){//如果不是文件夹
                if(f.getName().endsWith(".ktr")){
                    resultFileName.add(f.getPath());
                }
            }else{
                ergdoic(f,resultFileName);//如果是文件夹进行递归
            }
        }
        return resultFileName;//返回文件名的集合
    }

    //运行测试
    public static void main(String[] args) {
        File file = new File("D:\\soft\\elk\\data-integration-yjf-trunk\\repository");
        List<String> list= new ArrayList<>();
        System.out.println(FileReader.ergdoic(file, list));
        System.out.println("12");
    }
}
