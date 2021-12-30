//
// Created by LEEYANGY on 2021/12/31.
//

#include "stdio.h"
#include "stdlib.h"
//int argc告诉后面const *argv[]有多大
//argv[0]是命令本身
int main(int argc,char const *argv[]){
    for (int i = 0; i < argc; i++) {
        printf("%d:%s\n",i,argv[i]);
    }
    return 0;
}