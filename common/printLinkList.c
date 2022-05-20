//
// Created by LEEYANGY on 2022/5/20.
//

#include "common.h"
void printLinkList(struct student *head){
    printf("ÐÕÃû         Ñ§ºÅ  c    web\n");
    while(head!=NULL){
        printf("%-10s %5d  %.2f  %.2f\n",head->name,head->id,head->score_c,head->score_web);
        head=head->next;
    }
}