//
// Created by LEEYANGY on 2022/5/20.
//
#include <stdlib.h>
#include <stdio.h>
struct student{
//    学生类姓名，长度限制在20个字符以内，以英文输入
    char name[20];
//    学生类id
    int id;
//    c和web课成绩
    float score_c;
    float score_web;
//    链表指向下一个目标
    struct student *next;
};
void display_menu();
void searchID(struct student *head,int sID);
void freeLinkList(struct student *head);
void printLinkList(struct student *head);
struct student *creatLinkList();
struct student *insert(struct student *head,int insertData,int site);
struct student *del(struct student *head,int delID);
struct student *modify(struct student *head,int modyfitID,int modifyAfterID);
