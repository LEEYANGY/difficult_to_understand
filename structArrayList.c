//
// Created by LEEYANGY on 2021/12/31.
//

#include "stdio.h"

//定义结构体类型
struct Student{
    int num;
    float score;

};

int main(void){
//    定义结构体变量数组
    struct Student stu[5]={
            {1001,78},
            {1002,98.5},
            {1003,86},
            {1004,73.5},
            {1005,100}
    };
//    定义一个临时交换变量
    struct Student temp;
//    定义一个常量
    const int n=5;
//    定义循环初始变量
    int i,j,k;
//    提示用户输入信息
    printf("The Order is:\n");
    for(i=0;i<n-1;i++){
        k=i;
        for(j=i+1;j<n;j++){
            if (stu[j].score > stu[i].score) {
                k = j;
            }
        }
//            交换变量
            temp=stu[k];
            stu[k]=stu[i];
            stu[i]=temp;
    }
//        遍历结果
        for (i = 0; i < n; i++) {
            printf("%6d   %6.2f\n",stu[i].num,stu[i].score);
        }
    return 0;
}
