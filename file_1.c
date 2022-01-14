//
// Created by LEEYANGY on 2022/1/14.
//

#include "stdio.h"
#include "stdlib.h"

int main(int argc , char *argv[]){
//    用int ch接收EOF
    int ch;
//    文件指针
    FILE *fp;
//    打开一个文件
    fp = fopen("2","r");
//    打印文件内容
    while ( (ch = getc(fp) ) != EOF){
//        将文件内容输出到屏幕
        putchar(ch);
    }
    return 0;
}
