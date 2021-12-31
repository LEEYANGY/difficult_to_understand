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
/*
 * 定义一个结构体变量，初始化结构体数组
 */
struct Student{
    int num;
    char name[20];
    int age;
}student[3]={
        {1001,"Li Ning",20},
        {1003,"Lee",21},
        {1005,"Blue",22}
};

int main(int argc,char const *argv[]){

//    定义结构类型的变量
    struct date today,today1;

    today = (struct date){2021,12,31};

    today1 = (struct date){.day=21,today.month};

    struct date day;
//    *pDate 取today地址，结构体的地址必须这么取
    struct date *pDate = &today;

    printf("Today's data is %i-%i-%i \n",today.year,today.month,today.day);
    printf("%p\n",pDate);
//    方法一输出  这里要注意   *号和点的运算优先级  .的运算优先级大于*
    printf("%d\n%d\n",(*pDate).month,(*pDate).day);
//    方法二输出  ->称为指向运算   指向结构体变量的指针
    printf("%d\n%d\n",pDate->day,pDate->month);
//    printf("%d\n",pDate);
    printf("\n\n\n");
//    指向结构体数组的指针
    /**
     * 定义一个结构体指针 *pStudent
     * pStudent 是指向struct Student结构体类型数据的指针变量
     */
    struct Student *pStudent;
    printf("No.   Name      Age\n");
    /**
     * pStudent=student表明将student首元素地址给pStudent
     * pStudent++表示 pStudent 的地址向后挪一位
     */
    for(pStudent=student;pStudent<student+3;pStudent++){
//        遍历结果             分别将pStudent指向结构体中 num,name,age
        printf("%6d %10s %6d\n",pStudent->num,pStudent->name,pStudent->age);
    }


    /**
     * 用结构体变量和结构体变量的指针作函数的参数
     *
     *
     */
    return 0;
}
