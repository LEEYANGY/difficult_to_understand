#ifndef DATASTRUCT_DOUBLELOOPLINKLIST_H
#define DATASTRUCT_DOUBLELOOPLINKLIST_H

using namespace std;

#include <iostream>

typedef struct doublelooplinklist {
//    数据域
    int data;
//    指针域
    doublelooplinklist *prev;
//    指针域
    doublelooplinklist *next;
} doublelooplinklist;

//初始化双向循环链表
doublelooplinklist *initdoublelooplinklist() {

//    数据域用来记录节点个数
    doublelooplinklist *init = (doublelooplinklist *) malloc(sizeof(doublelooplinklist));
    init->data = 0;
//    指针域全指向自己
    init->prev = init;
    init->next = init;

//    返回链表
    return init;
}

void headInsertdoublelooplinklist(doublelooplinklist *node, int value) {

//    保存头节点
    doublelooplinklist *head = node;
//    保存数据节点
    doublelooplinklist *insert = (doublelooplinklist*) malloc(sizeof(doublelooplinklist));
    insert->data = value;
    insert->next = node->next;
    insert->prev = node;

    node->next = insert;
//    记录节点数
    ++head->data;
}


//遍历节点
void printdoublelooplinklist(doublelooplinklist *node) {
//    保存头节点
    doublelooplinklist *head = node;
//    指向下一节点
    node = node->next;
    while (node != head) {
        cout << node->data << " ";
//        移动链表
        node = node->next;
    }

}

#endif //DATASTRUCT_DOUBLELOOPLINKLIST_H
