package xyz.leeyangy.hdfs.util;

import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.*;

public class ApiDemo {

//    向 hdfs 中创建目录
    public void mkdir(String remotePath) {
//        根据参数指定的路径，在hdfs上创建目录
        FileSystem fs = HdfsHelper.getFS();
        if(fs != null) {
            try {
                //            检查目录是否存在
                boolean exists = fs.exists(new Path(remotePath));
//                若目录不存在，则创建此目录
                if(!exists) {
                    //            开始创建目录
                    boolean mkdirs = fs.mkdirs(new Path(remotePath));
                    System.out.println("hdfs上创建目录" + remotePath + "，结果为：" + mkdirs);
                } else {
                    System.out.println("hdfs上要创建目录" + remotePath + "，已存在。");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        HdfsHelper.closeFS(fs);
    }

//    向 hdfs 上传文件，使用copy方法
    public void copyFile2Hdfs(String localPath, String remotePath) {
//        localPath，本地文件路径；remotePath，hdfs上远端文件的路径
        FileSystem fs = HdfsHelper.getFS();
        if(fs != null) {
//            执行上传
            try {
                fs.copyFromLocalFile(new Path(localPath), new Path(remotePath));
                System.out.println("将本地文件" + localPath + "复制到hdfs路径" + remotePath
                    + "上成功");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("将本地文件" + localPath + "复制到hdfs路径" + remotePath
                        + "上失败");
            }
        }
        HdfsHelper.closeFS(fs);
    }

//    向 hdfs 上传文件，使用文件流的方式
    public void write2HdfsFile(String localPath, String remotePath) {
//        localPath，本地文件路径；remotePath，hdfs上远端文件的路径
        FileSystem fs = HdfsHelper.getFS();
        if(fs != null) {
//            执行上传
//            本地文件开输入流，进行读取
            FileInputStream fis = null;
            FSDataOutputStream append = null;
            byte[] buffer = new byte[1024];
            try {
//                新建一个文件输入流，打开本地文件
                fis = new FileInputStream(new File(localPath));
//            远端文件开输出流
//                append方法，打开一个已存在的文件
                append = fs.append(new Path(remotePath));
//                进行追加写入，如果文件大小超过字节数组，则需要循环读取并写入
                while(true) {
                    //                将文件的内容读出，写入一个byte数组
                    int read = fis.read(buffer);
                    if(read < 0) {
//                        表示未能从文件读取出任何信息，文件已结束，退出循环
                        break;
                    }
//                    如果 read >=0，表示文件未结束，信息已读取到字节数组
                    append.write(buffer, 0, read);
                }
                append.flush();
                System.out.println("本地文件"+localPath+"的内容已写入hdfs文件" + remotePath + "成功");

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if(append != null) {
                    try {
                        append.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        HdfsHelper.closeFS(fs);
    }

    public void write2LocalFile(String remotePath, String localPath) {
//        用文件流的方式，从远端下载文件到本地
//        localPath，本地文件路径；remotePath，hdfs上远端文件的路径
        FileSystem fs = HdfsHelper.getFS();
        if(fs != null) {
//            执行下载
//            远端文件开输入流，进行读取
            FSDataInputStream fsInput = null;
//            本地文件开输出，进行写入
            FileOutputStream fos = null;
//            缓冲区
            byte[] buffer = new byte[1024];
            try {
//                打开远端文件，以便读取
                fsInput = fs.open(new Path(remotePath));
//                打开本地文件，以便输出
                fos = new FileOutputStream(new File(localPath));
//                开始循环读取写入
                while(true) {
//                    本轮循环，读取到内容，返回值为读取的字节数
                    int read = fsInput.read(buffer);
                    if(read < 0) {
//                        read = -1，表示文件已经读取完毕，退出循环
                        break;
                    }
                    System.out.print(new String(buffer));
                    fos.write(buffer, 0, read);
                }
                System.out.println("从远端文件" + remotePath + "下载成本地文件" + localPath + "完毕");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if(fsInput != null) {
                    try {
                        fsInput.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        HdfsHelper.closeFS(fs);

    }

    public static void main(String[] args) {
        ApiDemo demo = new ApiDemo();
//        demo.mkdir("/aaa/bbb");
//        demo.copyFile2Hdfs("d:/abc.txt", "/aaa/abc1.txt");
//        demo.write2HdfsFile("d:/settings.xml", "/aaa/start-dfs.cmd");
        demo.write2LocalFile("/aaa/start-dfs.cmd", "d:/aaa-settings.xml");
    }
}
