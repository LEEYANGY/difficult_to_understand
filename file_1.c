//
// Created by LEEYANGY on 2022/1/14.
//

#include "stdio.h"
#include "stdlib.h"

int main(int argc , char *argv[]){

    int ch;
    FILE *fp;
    fp = fopen("2","r");
    ch = getc(fp);
    while (ch != EOF){
        putchar(ch);
        ch = getc(fp);
    }
    return 0;
}
