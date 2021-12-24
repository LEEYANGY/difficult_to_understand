/**
 * 语法使用c11进行学习。
 * 数组-二维数组
 */
#include <stdio.h>
#define Mouths 4
#define Years 3

int findArray(int find);

int main(void) {
//    二维数组
//    第一种写法
//    int rain[Years][Mouths]={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
//    第二种写法
    int rain[Years][Mouths]={1,2,3,4,5,6,7,8,9,10,11,12};
//    外层循环
    for (int i = 0; i < Years; ++i) {
//        内层循环
        for (int j = 0; j < Mouths; ++j) {
//            打印数组
            printf("%d    ",rain[i][j]);
//            printf("%d",rain[j]);
        }
        printf("\n");
    }
    printf("\n\n\n");

//    查找元素是否存在
    int search=6;
    findArray(search);
//    printf("%d",findArray(search));
    printf("%d",search);
    return 0;
}

//查找数组元素
int findArray(int finding){
    int rain[Years][Mouths]={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
//    外层循环
    for (int i = 0; i < Years; ++i) {
        //    内层循环
        for (int j = 0; j < Mouths; ++j) {
            if(finding==rain[i][j]){
                printf("finding: ",rain[i][j]);
                break;
            } else{

                break;
            }
        }
    }


    return finding;
}
