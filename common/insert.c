//
// Created by LEEYANGY on 2022/5/20.
//

#include "common.h"
/**
 *  按Id查询插入
 * @param head
 * @param insertID
 * @param site
 * @return
 */
struct student *insert(struct student *head,int insertID,int site){
    struct student *prev,*current=head;
//    分配一个动态内存
    prev=(struct student*) malloc(sizeof(struct student));
    prev->id=insertID;
    printf("请输入学生的姓名:");
    scanf("%s",&prev->name);
    printf("请输入学生的c语言成绩:");
    scanf("%f",&prev->score_c);
    printf("请输入学生的web成绩:");
    scanf("%f",&prev->score_web);
    if(head==NULL){
        printf("插入失败,没有数据!");
        return head;
    }else{
        while(current->next!=NULL){
//            找到位置插到它的后面
            if(current->id==site){
                prev->next=current->next;
                current->next=prev;
                break;
            } else{
//                current向后移动
                current=current->next;
            }
        }
    }
//    尾插,上面走到头以后就就行尾插
    if(current->next==NULL){
        prev->next=current->next;
        current->next=prev;
    }
    return head;
}