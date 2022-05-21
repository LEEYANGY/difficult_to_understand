//
// Created by LEEYANGY on 2022/5/20.
//
#ifndef COMMON_H_
#define COMMON_H_
//char filename[100]="/tmp/tmp.XScG2EA2hw/out/test.txt";
//常用头文件引入
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
typedef struct student{
//    ---数据域---start---
//    学生类姓名，长度限制在20个字符以内，以英文输入
    char name[20];
//    学生类id
    int id;
//    c和web课成绩
    double score_c;
    double score_web;
//    ---数据域---end---
//    链表指向下一个目标 ---指针域
    struct student *next;
}stu;
/* 函数原型 */

/* 操作：      显示用户操作菜单     */
void display_menu();

/* 操作：*/
void searchID(struct student *head,int sID);

/* 操作：   释放已分配的内存（如果有的话）            */
/*         current指向一个已经初始化的链表         */
/* 后置条件：释放已分配的所有内存，链表设置为空       */

void freeLinkList(struct student *head);

/* 操作：*/
void printLinkList(struct student *head);

/* 操作：*/
//include writerFile.c
//int saveFile(struct student *head);
void saveFile(struct student *head);

void readFile();

/* 操作：*/
//include writerFile.c
//int saveFile(struct student *head);
//int checkfile(char filename[]);
int checkfile();

/* 操作：初始化一个空链表                         */
/* 前提条件：head指向一个空链表                    */
/* 后置条件：链表初始化为空                        */
struct student *creatLinkList();

/* 操作：向已存在的链表中在指定位置插入数据          */
/* 前置条件：                                  */
/* 后置条件：                                  */
struct student *insert(struct student *head,int insertData,int site);

/* 操作：*/
struct student *del(struct student *head,int delID);

/* 操作：*/
struct student *modify(struct student *head,int modifyID,int modifyAfterID);

/* 操作：*/
//include readFile
struct student *loadFIle(struct student *head);

#endif
