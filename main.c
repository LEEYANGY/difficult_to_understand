/**
 * 语法使用c11进行学习。
 * 如下：程序是十进制转成二进制
 */
#include <stdio.h>

void to_binary(unsigned long number);

int main(void) {
    unsigned long number;
    printf("Enter an integer (q to quit):\n");
    while (scanf("%lu",&number)==1){
        printf("Binary equivalent: ");
        to_binary(number);
        putchar('\n');
        printf("Enter an integer (q to quit):\n");
    }
    printf("Done.\n");
    return 0;
}

void to_binary(unsigned long number) {
    int r;
    r=number%2;
    if(number>=2) {
        to_binary(number / 2);
    }
        putchar(r==0? '0':'1');
    return;
}