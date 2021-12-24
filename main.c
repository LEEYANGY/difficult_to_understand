/**
 * 语法使用c11进行学习。
 * 数组-一维数组
 */
#include <stdio.h>
#define Mouths 12

int main(void) {
//    数组
//    打印每个月的天数
//    方法一，给数组附上初始值
    int days1[Mouths]={31,28,31,30,31,30,31,31,30,31,30,31};
    for(int index=0;index<Mouths;index++){
        printf("Mouths %2d has %2d days.\n",index+1,days1[index]);
    }
    printf("\n");
//    方法二，不赋初始值
    int days2[]={31,28,31,30,31,30,31,31,30,31,30,31};
    for(int index=0;index<Mouths;index++){
        printf("Mouths %2d has %2d days.\n",index+1,days2[index]);
    }
    printf("\n");
    //    方法二，不赋初始值
    int days3[]={31,28,31,30,31,30,31,31,30,31,30,31};
//    sizeof days3是整个数组的大小，sizeof days3[0]是第一个数组的下标,表示第一个数组大小，整个数组的大小除于一个即为数组长度
    for(int index=0;index<(sizeof days3/sizeof days3[0]);index++){
        printf("Mouths %2d has %2d days.\n",index+1,days3[index]);
    }

    return 0;
}
