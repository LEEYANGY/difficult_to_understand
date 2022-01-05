//
// Created by LEEYANGY on 2022/1/1.
//
#include "stdio.h"
#include "math.h"
#include "stdlib.h"
#include "string.h"
/**
 *
 *  C对文件的定义：
 *      C把文件看作一个字符(或字节）的序列，即一个个字符（字节）的顺序组成，一个输入流和输出流就是一个字符流或字节流（内容是二进制数据）
 *  C的数据文件 在 行之间不会自动换行，对文件的存取是以字符（字节）为单位。
 *
 *  数据文件分类：
 *      分为 ASCII 和 二进制文件
 *
 *          数据在内存中是以二进制形式存储，如果不加以转换地输出到外存，就是二进制文件
 *          可以认为它就是存储在内存的数据映像，所以也称之为 映像文件 （Image file）
 *
 *          如果要求存在外村上以ASCII代码形式存储，则需要进行转换，ASCII文件又称文本文件(Text File)
 *          每个字节文件放一个字符的ASCII代码
 *
 *      怎么存储？
 *          字符一律以ASCII形式存储，数值型数据既可以用ASCII形式存储，也可以使用二进制形式存储
 *
 *
 *
 *  FILE *fp;
 *  fopen 参数
 *  "r"	打开一个用于读取的文件。该文件必须存在。
 *  "w"	创建一个用于写入的空文件。如果文件名称与已存在的文件相同，则会删除已有文件的内容，文件被视为一个新的空文件。
 *  "a"	追加到一个文件。写操作向文件末尾追加数据。如果文件不存在，则创建文件。
 *  "r+"	打开一个用于更新的文件，可读取也可写入。该文件必须存在。
 *  "w+"	创建一个用于读写的空文件。
 *  "a+"	打开一个用于读取和追加的文件。
 *
 * @return
 */
int main(void){

//    定义文件指针
    FILE *fIn;
    FILE *fOut;

    //文件名
    char fInName[100];
    char fOutName[100];
//    等待用户输入的字符串
    char fContext;

//    判断文件是否存在，如果不存在，则手动创建
    printf("Please input file name:\n");
    scanf("%99s",fInName);
//    打开文件，如果为NULL，表示失败
    if ( ( fIn = fopen(fInName,"r") ) == NULL ){
        printf("Open failed\n");
        if ( ( fOut = fopen(strcpy(fOutName,fInName),"w") ) == NULL ){
            printf("Creation failed\n");
        } else{
            printf("Working for you create file\n");
            printf("Please input char , if you want exit please in put #  to end write:");
//    第一次读入用户从键盘输入的字符串
            fContext=getchar();
//    写入一个文件
            while (fContext != '#'){
//        向磁盘写入一个文件
                fputc(fContext,fOut);
//        从键盘获取用户输入的内容
                fContext=getchar();
            }
            printf("File created successfully\n");
        }
    } else{
        printf("This file already exists,open success ! \n");
    }
    //    关闭文件,相当于刷新文件
    fclose(fIn);
    fclose(fOut);

//    查询文件是否写入成功
//    printf("Please in put file name:\n");
//    scanf("%99s",fInName);
//    打开文件，如果为NULL，表示失败
    if ( ( fIn = fopen(fInName,"r") ) ==NULL ){
        printf("Open failed,file does not exist");
//        终止程序
//        exit(0);
    } else{
        printf("Open successfully!\n");
//      从指定文件中读取内容
        fContext=fgetc(fIn);
//      文件读取不是eof的话
        while ( !feof(fIn) ){
//            将文件中的内容分输出到屏幕上
            fputc(fContext,fOut);
//          再从指定文件中读取内容
            putchar(fContext);
//          从指定文件中读取内容
            fContext=fgetc(fIn);
        }
    }

//    关闭文件
    fclose(fIn);
    fclose(fOut);
    return 0;
}
