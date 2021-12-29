//
// Created by LEEYANGY on 2021/12/29.
//

#include "stdio.h"
#define Size 4
#define Speed 10

int main(void){

//    int const days1[Size]={1,2,3,4};
//    const int days2[Size]={1,2,3,4};
//    printf("%d\n",days1[2]);
////    days[2]=5;
//    printf("%d",days1[2]);
//
//    printf("%d\n",days2[2]);
////    days2[2]=5;
//    printf("%d",days2[2]);

    int rate1[Speed]={1,2,3,4,5,6,7,8,9,10};
    int rate2[Speed]={9,2,3,4,5,6,7,8,9,10};
//    取数组首地址
    int const *p1=&rate1[0];//通过指针不可修改,也就是说，*p是一个常量，不是变量，不能通过*p去修改rate1中的值，但是，可以修改*p1所指向的地址
    printf("\nconst 在 * 前\n");
    printf("rate1[0]的地址是：%p\n",&rate1[0]);
    printf("rate1[0]的地址是：%p\n",&rate1);
    printf("rate1[1]的地址是：%p\n",&rate1[1]);
    printf("rate1[2]的地址是：%p\n",&rate1[2]);
    printf("改变前p1的地址是：%p\n",p1);
    printf("rate1[0]的值是：%d\n",rate1[0]);
    printf("rate1[1]的值是：%d\n",rate1[1]);
    printf("改变前p1的值是：%d\n",*p1);
//    *p1++;
    printf("\n改变后的内容\n");
    printf("改变后的p1的地址是：%p\n",p1);
    printf("改变后的p1的值是：%d\n",*p1);
    rate1[1]=26;
//    *p1=26;//不允许修改值
    p1=&rate1[1];//允许修改p1指向的地址
    printf("改变后的p1的地址是：%p\n",p1);
    printf("改变后的p1的值是：%d\n",*p1);
    printf("rate1[0]的地址是：%p\n",&rate1[0]);
    printf("rate1[1]的地址是：%p\n",&rate1[1]);
    printf("rate1[0]的值是：%d\n",rate1[0]);
    printf("rate1[1]的值是：%d\n",rate1[1]);

    printf("\n");
//        p1=rate2;//允许修改p1指向的地址
    *p1++;
    printf("再次改变后的p1的值是：%d\n",*p1);
    printf("再次改变后的p1的地址是：%p\n",p1);




    printf("\nconst 在 * 后\n");
    int *const p2=rate2;//指针不可以被修改，这里说的是p2是一个常量，它所指向的地址之后，不允许再修改指向的地址，但是可以修改它的值
    printf("改变前p2的地址是：%p\n",p2);
    printf("rate2[0]的值是：%d\n",rate2[0]);
    printf("rate2[0]的地址是：%p\n",&rate2[0]);
    *p2=26;//可以改变值，不允许改变地址
//    *p2+1=28;
    printf("改变后的p2的值是：%d\n",*p2);
//    p2=rate1;//不允许修改p2的地址
    printf("rate2[0]的值是：%d\n",rate2[0]);
    printf("rate2[0]的地址是：%p\n",&rate2[0]);
    printf("");
    return 0;
}