//
// Created by LEEYANGY on 2022/5/20.
//

//#include "../header/creatLinkList.h"

#include "common.h"
struct student *creatLinkList(){
    int count=1;
    struct student *head,*prev,*current;
//    ���䶯̬�ڴ�
//    head=(struct student*) malloc(sizeof (struct student));
//    prev=(struct student*) malloc(sizeof (struct student));
    head=NULL;
    current=(struct student*) malloc(sizeof (struct student));
    printf("�������%d��ѧ����ѧ��(��0Ϊ��������):",count);
    scanf("%d",&current->id);
//    id�Ų�Ϊ0,�ͼ�������
    while (current->id!=0){
//        �жϳ�ʼ����
        if(head==NULL){
//            ͷ�ڵ�ΪNULL�Ļ�,����headָ��current
            head=current;
        } else {
//            ���ڲ������ݵĻ�,����prevָ��current
//            ָ����һ���ڵ�
            prev->next=current;
        }
//        printf("������� %d ��ѧ����ѧ��: ",++count);
//        scanf("%d",&current->id);
        printf("�������%d��ѧ������:",count);
        scanf("%s",&current->name);
        printf("�������%d��ѧ��c�ĳɼ�:",count);
        scanf("%f",&current->score_c);
        printf("�������%d��ѧ��web�ĳɼ�:",count);
        scanf("%f",&current->score_web);
//        ��current�ĵ�ַ��prev,����current���������������
        prev=current;
//        �������붯̬�ڴ�
        current=(struct student*) malloc(sizeof (struct student));
        printf("�������%d��ѧ����ѧ��:",++count);
        scanf("%d",&current->id);
    }
//    ����null��ʾ�������
    prev->next=NULL;
    /**
     * �е����Ƶ�һ����ӵ��ļ�,����������ݺ��ֶ����б��浽�ļ���
     */
//    �ͷ��ڴ�
    free(current);
//    ���׵�ַ����,��Ϊ��һ��ʹ��
    return head;
}