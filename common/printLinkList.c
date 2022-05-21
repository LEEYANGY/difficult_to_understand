//
// Created by LEEYANGY on 2022/5/20.
//

#include "common.h"
void printLinkList(struct student *head){
    printf("姓名       学号  c    web\n");
    while(head!=NULL){
        printf("%-10s %7d  %.2lf  %.2lf\n",head->name,head->id,head->score_c,head->score_web);
        head=head->next;
    }
}