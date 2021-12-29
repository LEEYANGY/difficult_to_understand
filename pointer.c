////
//// Created by LEEYANGY on 2021/12/25.
////
///**
// * 指针学习
// */
//#include "stdio.h"
//
//int main(void){
//    int address_1;
//    int address_2;
////    打印初始地址
//    printf("普通变量的地址\n");
//    printf("address_1地址为：%p\n",&address_1);
//    printf("address_2地址为：%p\n",&address_2);
//
//    int array[10];
//    printf("数组的地址\n");
////    取地址符
//    printf("1.  %p\n",&array);
////    没有取地址符，输出的是数组第一个元素的地址
//    printf("2.  %p\n",array);
////    数组第一个元素
//    printf("3.  %p\n",&array[0]);
////    数组第二个元素
//    printf("4.  %p\n",&array[1]);
//
//    //    指针变量就是记录地址的变量
////    指针变量的值是指具有实际值的变量的地址
//    int i=11;
//    //    定义一个整型变量指针
//    int *p;
////    保存i的地址到p中
//    p=&i;
//    printf("指针的地址\n");
////    打印i的地址和p的地址
////    打印地址常量的地址必须要有取址符号
//    printf("i的地址是：%p\n",&i);
////    printf("i的地址是：%d\n",&i);
////    printf("i的地址是：%p\n",i);
//    printf("i的值是：%d\n",i);
//    printf("\n");
//    printf("p的值是：%d\n",*p);    //实际上拿到的是一个整体
////    printf("p的地址是：%p\n",&p);
//    printf("p的地址是：%p\n",p);
////    printf("p的地址是：%d\n",p);
//    printf("\n");
////    如果p已经指向了i，*p=26，则是间接的将26赋值给i，即i=26
//    *p=26;
//
//    printf("i的值是：%d\n",i);
//    printf("p的值是：%d\n\n\n结束",*p);
//    printf("指针数组\n");
//
//    int a[10]={1,2,3,4,5,6,7,8,9,0};
//    printf("%p\n",&a[0]);
//    printf("%p\n",&a[10]);
//    int *pp;
//    pp=a;
//    printf("%p\n",(pp+5));
//    printf("%d\n",*(pp+5));
//
//    return 0;
//}
