//
// Created by LEEYANGY on 2022/5/20.
//

#include "common.h"
void searchID(struct student *head,int sID){
//    flag用来标记是否找到元素
    int flag=0;
    while(head!=NULL){
        if(sID==head->id){
//            找到了就把flag置1
            flag=1;
            break;
        } else{
//            向后移动
            head=head->next;
        }
    }
    if(flag==1){
        printf("%d Found!\n",sID);
    }else{
        printf("%d No Found!\n",sID);
    }
}