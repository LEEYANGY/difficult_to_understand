package xyz.leeyangy.hdfs.util;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestFileIOStream {
    public static void fileInput(String srcPath) {
//        创建文件对象
        File srcFile = new File(srcPath);
//        文件对象检查
        if(srcFile.exists() && srcFile.canRead()) {
//            开始读取
            FileInputStream fis = null;
            try {
//                打开文件，创建文件输入流对象
                fis = new FileInputStream(srcFile);
//                读取文件内容
//                read() 返回文件指针所指向的字节的值，文件指针向后移动一位
                int num = 0;
                byte[] buff = new byte[8];
                while(true) {
                    num ++;
//                    int read = fis.read();
                    int read = fis.read(buff);
                    System.out.println("第"+num+"次循环，read=" + read);
                    for(int i=0; i<read; i++) {
                        System.out.print("buff["+i+"]=" + Byte.toUnsignedInt(buff[i]) + ", ");
                    }
                    System.out.println("\n");
                    if(read < 0) break;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } else {
            System.out.println("文件" + srcPath + "不存在或没有读取权限。");
        }
    }

    public static void fileOutput(String targetPath) {
//        创建文件对象
        File targetFile = new File(targetPath);
        if(targetFile.getParentFile().exists()) {
//            开始写入文件
            FileOutputStream fos = null;
            try {
//                创建输出流对象
                fos = new FileOutputStream(targetFile);
//                使用输出流对象进行写入
                byte[] buff = new byte[] {
                        106,107,108,109,110,39
//                      j    k   l   m   n   ,
                };
                for(int i=0; i<buff.length; i++) {
//                    fos.write(buff);
                    fos.write(buff, 2,4);
                }
                fos.flush();  //强制将缓冲区的内容写入磁盘文件
                System.out.println("写入磁盘文件" + targetPath + "成功");
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
            }
        } else {
            System.out.println("写入的目标文件无法创建。");
        }
    }

    public static void copyFile(String srcPath, String targetPath) {
//        分别构建源文件与目标文件的对象
        File srcFile = new File(srcPath);
        File targetFile = new File(targetPath);
//        检查文件
        if(srcFile.exists() && srcFile.canRead()) {
            if(targetFile.getParentFile().exists()) {
//                读取文件
                //            开始读取
                FileInputStream fis = null;
                //            开始写入文件
                FileOutputStream fos = null;
                try {
//                打开文件，创建文件输入流对象
                    fis = new FileInputStream(srcFile);
                    //                创建输出流对象
                    fos = new FileOutputStream(targetFile);
//                读取文件内容
//                read() 返回文件指针所指向的字节的值，文件指针向后移动一位
                    int num = 0;
                    byte[] buff = new byte[8192];
                    while(true) {
                        num ++;
//                    int read = fis.read();
                        int read = fis.read(buff);
                        System.out.println("第"+num+"次循环，read=" + read);
                        if(read < 0) break;
//                        开始写入文件
                        fos.write(buff, 0, read);
                        System.out.println("输出文件写入" + read + "个字节");
                    }
//                    fis.transferTo(fos);
                    fos.flush();
                    System.out.println("输出文件写入完毕");
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

                    if(fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            } else {
                System.out.println("输出目标文件的目标不存在");
            }
        } else {
            System.out.println("源文件无法读取");
        }
    }

    public static void main(String[] args) {
//        fileInput("d:/abc.txt");
//        fileOutput("d:/bcd.txt");
        copyFile("d:/fj02.webp", "d:/fj03.webp");
    }
}
