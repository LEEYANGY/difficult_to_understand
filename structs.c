//
// Created by LEEYANGY on 2021/12/31.
//
/**
 * 结构体
 *
 *
 */

#include "stdio.h"
//申明一种类型
struct date{
    int year;
    int month;
    int day;
};

int main(int argc,char const *argv[]){

//    定义结构类型的变量
//    赋值的第一种方法
    struct date today1;
    today1.year=2021;
    today1.month=12;
    today1.day=31;

//    赋值的第二种方法
    struct date today2={2021,12,31};
//    赋值的第三种方法
    struct date thistoday3={.year=2021,.month=12,.day=31};

    printf("Today's date is %i-%i-%i",today2.year,today2.month,today2.day);
    return 0;
}
