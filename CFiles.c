//
// Created by LEEYANGY on 2022/1/1.
//
#include "stdio.h"
#include "math.h"
#include "stdlib.h"
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

//    定义一个文件指针
    FILE *fp;

//    定义一个指针变量
    char ch;
    char filename[10];

//    将fopen函数返回值赋给指针变量fp
    fp = fopen("1111","r");
    if( (fp = fopen("1111","rb") ) == NULL ){
        printf("打开文件失败");
        exit(0);
    } else{
        printf("打开成功\n");
    }

    printf("请输入文件名");
//    读入文件名
    scanf("%9s",filename);
    getchar();

//    打开c文件
    if ( (fp = fopen(filename,"w")) == NULL  ){
        printf("Can't open file\n");
        exit(0);
    }

//    从键盘获取第一个字符
    ch = getchar();
    while (ch != '#'){
//        向磁盘写入一个文件
        fputc(ch,fp);
//        将输入到磁盘的文字显示出来
        putchar(ch);
//        再从键盘接收输入的字符
        ch = getchar();
    }

//    从键盘获取字符
//    fgetc();
//    用put函数写入到磁盘文件
//    fputc();

//    使用完文件后一定要关闭文件
//    fclose()
    fclose(fp);
    //换行
    putchar(10);
    return 0;
}

