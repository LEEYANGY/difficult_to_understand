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
//    ȡ�����׵�ַ
    int const *p1=&rate1[0];//ͨ��ָ�벻���޸�,Ҳ����˵��*p��һ�����������Ǳ���������ͨ��*pȥ�޸�rate1�е�ֵ�����ǣ������޸�*p1��ָ��ĵ�ַ
    printf("\nconst �� * ǰ\n");
    printf("rate1[0]�ĵ�ַ�ǣ�%p\n",&rate1[0]);
    printf("rate1[0]�ĵ�ַ�ǣ�%p\n",&rate1);
    printf("rate1[1]�ĵ�ַ�ǣ�%p\n",&rate1[1]);
    printf("rate1[2]�ĵ�ַ�ǣ�%p\n",&rate1[2]);
    printf("�ı�ǰp1�ĵ�ַ�ǣ�%p\n",p1);
    printf("rate1[0]��ֵ�ǣ�%d\n",rate1[0]);
    printf("rate1[1]��ֵ�ǣ�%d\n",rate1[1]);
    printf("�ı�ǰp1��ֵ�ǣ�%d\n",*p1);
//    *p1++;
    printf("\n�ı�������\n");
    printf("�ı���p1�ĵ�ַ�ǣ�%p\n",p1);
    printf("�ı���p1��ֵ�ǣ�%d\n",*p1);
    rate1[1]=26;
//    *p1=26;//�������޸�ֵ
    p1=&rate1[1];//�����޸�p1ָ��ĵ�ַ
    printf("�ı���p1�ĵ�ַ�ǣ�%p\n",p1);
    printf("�ı���p1��ֵ�ǣ�%d\n",*p1);
    printf("rate1[0]�ĵ�ַ�ǣ�%p\n",&rate1[0]);
    printf("rate1[1]�ĵ�ַ�ǣ�%p\n",&rate1[1]);
    printf("rate1[0]��ֵ�ǣ�%d\n",rate1[0]);
    printf("rate1[1]��ֵ�ǣ�%d\n",rate1[1]);

    printf("\n");
//        p1=rate2;//�����޸�p1ָ��ĵ�ַ
    *p1++;
    printf("�ٴθı���p1��ֵ�ǣ�%d\n",*p1);
    printf("�ٴθı���p1�ĵ�ַ�ǣ�%p\n",p1);




    printf("\nconst �� * ��\n");
    int *const p2=rate2;//ָ�벻���Ա��޸ģ�����˵����p2��һ������������ָ��ĵ�ַ֮�󣬲��������޸�ָ��ĵ�ַ�����ǿ����޸�����ֵ
    printf("�ı�ǰp2�ĵ�ַ�ǣ�%p\n",p2);
    printf("rate2[0]��ֵ�ǣ�%d\n",rate2[0]);
    printf("rate2[0]�ĵ�ַ�ǣ�%p\n",&rate2[0]);
    *p2=26;//���Ըı�ֵ��������ı��ַ
//    *p2+1=28;
    printf("�ı���p2��ֵ�ǣ�%d\n",*p2);
//    p2=rate1;//�������޸�p2�ĵ�ַ
    printf("rate2[0]��ֵ�ǣ�%d\n",rate2[0]);
    printf("rate2[0]�ĵ�ַ�ǣ�%p\n",&rate2[0]);
    printf("");
    return 0;
}