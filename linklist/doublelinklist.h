#include <iostream>

//定义一个双向链表
struct doublelinklist {
    int data;
//    保存上一节点
    struct doublelinklist *pre;
//    保存下一节点
    struct doublelinklist *next;
};

// 初始化一个双向链表
doublelinklist *initdoublelinklist() {
    doublelinklist *node = (doublelinklist *) malloc(sizeof(doublelinklist));
    node->pre = nullptr;
    node->next = nullptr;
    node->data = 0;
    return node;
};

//头插
void headInsert(doublelinklist *node, int value) {
//    临时节点
    doublelinklist *tmp = (doublelinklist *) malloc(sizeof(doublelinklist));
//    赋值
    tmp->data = value;
//    头节点记录保存节点数量
    ++node->data;
//    保存原链表中的数据
    tmp->next = node->next;
    tmp->pre = node->pre;
    node->next = tmp;
}

//尾插
void tailInsert(doublelinklist *node, int value) {
    doublelinklist *tmp = (doublelinklist *) malloc(sizeof(doublelinklist));
    ++node->data;
//    移动头节点
    node = node->next;
    while (node->next) {
        node = node->next;
    }

//    对节点进行保存
    tmp->pre = node;
    tmp->next = nullptr;
    tmp->data = value;
//    插入尾部
    node->next = tmp;
}

void printDoubleNode(doublelinklist *node) {
    node = node->next;
    while (node) {
        cout << node->data << " ";
        node = node->next;
    }
}
