//
// Created by LEEYANGY on 2022/5/20.
//

#include "common.h"
/**
 *  ��Id��ѯ����
 * @param head
 * @param insertID
 * @param site
 * @return
 */
struct student *insert(struct student *head,int insertID,int site){
    struct student *prev,*current=head;
//    ����һ����̬�ڴ�
    prev=(struct student*) malloc(sizeof(struct student));
    prev->id=insertID;
    printf("������ѧ��������:");
    scanf("%s",&prev->name);
    printf("������ѧ����c���Գɼ�:");
    scanf("%f",&prev->score_c);
    printf("������ѧ����web�ɼ�:");
    scanf("%f",&prev->score_web);
    if(head==NULL){
        printf("����ʧ��,û������!");
        return head;
    }else{
        while(current->next!=NULL){
//            �ҵ�λ�ò嵽���ĺ���
            if(current->id==site){
                prev->next=current->next;
                current->next=prev;
                break;
            } else{
//                current����ƶ�
                current=current->next;
            }
        }
    }
//    β��,�����ߵ�ͷ�Ժ�;���β��
    if(current->next==NULL){
        prev->next=current->next;
        current->next=prev;
    }
    return head;
}