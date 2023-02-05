package xyz.leeyangy.hdfs.demo;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import xyz.leeyangy.hdfs.util.HdfsHelper;

import java.io.IOException;

//操作hdfs对象
public class HdfsOperator {

//    在hdfs上创建文件夹
    public static void mkdir2HDFS(String remotePath){
//        获取FIleSystem对象
        FileSystem fs = HdfsHelper.getFS();
        if (fs !=null){
           Path path= new Path(remotePath);
//            检查远端目录是否存在
            try {
                boolean exists = fs.exists(path);
                if(!exists){
//                    不存在
                    boolean mkdirs = fs.mkdirs(path);
                    System.out.println("创建结果："+mkdirs);
                }else {
                    System.out.println("创建失败，文件已存在");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }


//    上传文件
    public static void uploadFule(String localPath,String remotePath){
        FileSystem fs=HdfsHelper.getFS();
        if(fs!=null){
//            使用fs的copy向hdfs上传
            try {
                fs.copyFromLocalFile(new Path(localPath),new Path(remotePath));
                System.out.println("本地文件"+localPath+" 上传到 Hdfs文件"+remotePath+"成功");
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    fs.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
//        HdfsOperator.mkdir2HDFS("/aaa");
        HdfsOperator.uploadFule("D:/test.txt","/aaa/test.txt");
    }


}
