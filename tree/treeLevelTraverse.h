/**
******************************************************************************  
* File Name      : treeLevelTraverse.h  
* Author         : leeyangy  
* E-mail         : liyangyang0713@foxmail.com  
* Create         : 2023/10/5 0:23
* Description    : 层次遍历二叉树
******************************************************************************  
*/

#ifndef DATASTRUCT_TREELEVELTRAVERSE_H
#define DATASTRUCT_TREELEVELTRAVERSE_H

#include <iostream>
#include "tree.h"

using namespace std;



//直接引用之前定义的 TreeNode

//使用指针实现一个队列
typedef struct QueueNode {
    TreeNode *data;
    struct QueueNode *pre;
    struct QueueNode *next;
} QueueNode;

/**
* @Param: [ TreeNode **T, char *data, int *index ]
* @return: null
* @Author: liyangyang
* @Date: 2023/10/5 0:51
* @Description: 创建层次遍历二叉树
*/
void createLevelTree(TreeNode **T, char *data, int *index) {
    char ch;
    ch = data[*index];
    *index += 1;
    if (ch == '#') { *T = nullptr; }
    else {
//        开辟内存空间
        *T = (TreeNode *) malloc(sizeof(TreeNode));
        (*T)->data = ch;
        createLevelTree(&((*T)->lchild), data, index);
        createLevelTree(&((*T)->rchild), data, index);
    }
}

/**
* @Param: [ TreeNode *T ]
* @return: null
* @Author: liyangyang
* @Date: 2023/10/5 0:52
* @Description: 遍历二叉树
*/
void preLevelOrder(TreeNode *T) {
    if (T == nullptr) { return; }
    else {
        cout << T->data;
        preLevelOrder(T->lchild);
        preLevelOrder(T->rchild);
    }
}
// 思路：尾插，头取

/**
* @Param:
* @return: QueueNode Q
* @Author: liyangyang
* @Date: 2023/10/5 1:19
* @Description: 初始化一个队列
*/
QueueNode *initQueue() {
//    开辟内存空间
    auto *Q = (QueueNode *) malloc(sizeof(QueueNode));
    Q->data = nullptr;
    Q->next = Q;
    Q->pre = Q;
    return Q;
}

/**
* @Param: [ TreeNode *data, QueueNode *Q ]
* @return: 
* @Author: liyangyang
* @Date: 2023/10/5 1:20
* @Description: 入队操作
*/
void enQueue(TreeNode *data, QueueNode *Q) {
//    开辟内存空间
    auto *node = (QueueNode *) malloc(sizeof(QueueNode));
//    连接节点
    node->data = data;
    node->pre = Q;
    node->next = Q;
    Q->pre->next = node;
    Q->pre = node;
}

/**
* @Param: [  ]
* @return: int
* @Author: liyangyang
* @Date: 2023/10/5 1:24
* @Description: 队列判空
*/
int isEmpty(QueueNode *Q) {
    if (Q->next == Q) return 1;
    else return 0;
}

/**
* @Param: [ QueueNode *Q ]
* @return: 
* @Author: liyangyang
* @Date: 2023/10/5 1:23
* @Description:  出队操作
*/
QueueNode *deQueue(QueueNode *Q) {
    if (isEmpty(Q)) return nullptr;
    else {
        QueueNode *node = Q->next;
        Q->next->next->pre = Q;
        Q->next = Q->next->next;
        return node;
    }
}

/**
* @Param:
* @return:
* @Author: liyangyang
* @Date: 2023/10/5 1:28
* @Description: 层次遍历
*/
void levelTraverse(QueueNode *Q, TreeNode *T) {
//    先入队操作
    enQueue(T, Q);
//    判断队列是否为空
    while (!isEmpty(Q)) {
//        执行出队操作
        QueueNode *node = deQueue(Q);
//        访问元素
        cout << node->data->data;
//        判断是否有左孩子,有的话,执行入队操作
        if (node->data->lchild) {
            enQueue(node->data->lchild, Q);
        }
//        判断是否有右孩子,有的话,执行入队操作
        if (node->data->rchild) {
            enQueue(node->data->rchild, Q);
        }
//        依次往复遍历
    }

}

#endif //DATASTRUCT_TREELEVELTRAVERSE_H
