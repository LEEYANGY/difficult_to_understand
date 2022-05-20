//
// Created by LEEYANGY on 2022/5/20.
//

#include "common.h"
/**
 * 这个头文件是用来释放在程序退出后所占用的内存
 *
 */
void freeLinkList(struct student *head){
    struct student *current=head;
    if(head==NULL){
        printf("no need free memory\n");
    }else{
        while(head!=NULL){
            head=current->next;
//            释放内存，free memory
            free(current);
            current=head;
        }
        if(head==NULL){
            printf("free succeed!\n");
        }else{
            printf("erro,please inspect code\n");
        }
    }
}

