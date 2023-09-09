#include <iostream>

using namespace std;

struct loopbacklinklist {
    int data;
    struct loopbacklinklist *next;
};

loopbacklinklist *initloopbacklinklist() {
    loopbacklinklist *init = new loopbacklinklist;
    init->data = 0;
//    下一节点指向自己
    init->next = init;
    return init;
};

//头插
void headInsertLoop(loopbacklinklist *node, int value) {
//    初始化一个节点
    loopbacklinklist *insert = (loopbacklinklist *) malloc(sizeof(loopbacklinklist));
    insert->data = value;
//    头节点保存节点数量+1
    ++node->data;
    insert->next = node->next;
    node->next = insert;
}

//尾插
void tailInsertLoop(loopbacklinklist *node, int value) {
    //    初始化一个节点
    loopbacklinklist *insert = (loopbacklinklist *) malloc(sizeof(loopbacklinklist));
//    保存头节点
    loopbacklinklist *head = node;

//    移动节点
    node = node->next;
    while (node->next != head) {
        node=node->next;
    }
//    对节点进行赋值
    insert->data = value;
    insert->next = node->next;
    node->next = insert;
    ++head->data;
}

void printloopbacklinklist(loopbacklinklist *head) {
    loopbacklinklist *node = head->next;
    while (node != head) {
        cout << node->data << " ";
        node = node->next;
    }
}
