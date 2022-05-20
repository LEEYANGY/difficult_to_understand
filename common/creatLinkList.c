//
// Created by LEEYANGY on 2022/5/20.
//

//#include "../header/creatLinkList.h"

#include "common.h"
struct student *creatLinkList(){
    int count=1;
    struct student *head,*prev,*current;
//    分配动态内存
//    head=(struct student*) malloc(sizeof (struct student));
//    prev=(struct student*) malloc(sizeof (struct student));
    head=NULL;
    current=(struct student*) malloc(sizeof (struct student));
    printf("请输入第%d个学生的学号(以0为结束输入):",count);
    scanf("%d",&current->id);
//    id号不为0,就继续插入
    while (current->id!=0){
//        判断初始条件
        if(head==NULL){
//            头节点为NULL的话,就让head指向current
            head=current;
        } else {
//            正在插入数据的话,就让prev指向current
//            指向下一个节点
            prev->next=current;
        }
//        printf("请输入第 %d 个学生的学号: ",++count);
//        scanf("%d",&current->id);
        printf("请输入第%d个学生姓名:",count);
        scanf("%s",&current->name);
        printf("请输入第%d个学生c的成绩:",count);
        scanf("%f",&current->score_c);
        printf("请输入第%d个学生web的成绩:",count);
        scanf("%f",&current->score_web);
//        把current的地址给prev,就是current里面所保存的数据
        prev=current;
//        重新申请动态内存
        current=(struct student*) malloc(sizeof (struct student));
        printf("请输入第%d个学生的学号:",++count);
        scanf("%d",&current->id);
    }
//    加上null表示结束标记
    prev->next=NULL;
    /**
     * 有点类似第一次添加的文件,在添加完数据后手动进行保存到文件中
     */
//    释放内存
    free(current);
//    把首地址返回,作为下一次使用
    return head;
}