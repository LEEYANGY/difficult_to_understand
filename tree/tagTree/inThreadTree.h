/**
******************************************************************************  
* File Name      : inThreadTree.h  
* Author         : leeyangy  
* E-mail         : liyangyang0713@foxmail.com  
* Create         : 2023/10/7 23:02  
* Description    : 索引二叉树
******************************************************************************
*/

#ifndef DATASTRUCT_INTHREADTREE_H
#define DATASTRUCT_INTHREADTREE_H

#include <iostream>

using namespace std;

//定义树
typedef struct inThreadTreeNode {
    char data;
    struct inThreadTreeNode *lchild;
    struct inThreadTreeNode *rchild;
//    左右遍历标记
    int ltag;
    int rtag;
} inThreadTreeNode;

/**
* @Param: [ inThreadTreeNode **T, char *data, int *index ]
* @return: null
* @Author: liyangyang
* @Date: 2023/10/7 23:05
* @Description: 创建索引二叉树
*/
void createInThreadTree(inThreadTreeNode **T, char *data, int *index) {
//    char变量
    char ch;
//    移动指针，并赋值
    ch = data[(*index)++];
    if (ch == '#') *T = nullptr;
    else {
//        开辟内存空间
        *T = (inThreadTreeNode *) malloc(sizeof(inThreadTreeNode));
//        赋值
        (*T)->data = ch;
//        初始化标记
        (*T)->ltag = 0;
        (*T)->rtag = 0;
//        创建左右子树
        createInThreadTree(&(*T)->lchild, data, index);
        createInThreadTree(&(*T)->rchild, data, index);
    }
}

/**
* @Param: [ inThreadTreeNode *T 原来的树,inThreadTreeNode **pre 记录前驱节点 ]
* @return: 
* @Author: liyangyang
* @Date: 2023/10/7 23:14
* @Description: 
*/
void inThreadTree(inThreadTreeNode *T, inThreadTreeNode **pre) {
    if (T) {
//        处理左右子树遍历
        inThreadTree(T->lchild, pre);
//        判断是否有左孩子
        if (T->lchild == nullptr) {
//            修改左孩子标记
            T->ltag = 1;
            T->lchild = *pre;
        }
//        有孩子为空可以指向后继
        if (*pre != nullptr && (*pre)->rchild == nullptr) {
            (*pre)->rtag = 1;
            (*pre)->rchild = T;
        }
//        改变pre
        *pre = T;
        inThreadTree(T->rchild, pre);
    }
}

/**
* @Param: [ inThreadTreeNode *T 树 ]
* @return:
* @Author: liyangyang
* @Date: 2023/10/7 23:43
* @Description: 获取第一个节点
*/
inThreadTreeNode *getFirst(inThreadTreeNode *T) {
//    访问元素
    while (T->ltag == 0) T = T->lchild;
    return T;
}

/**
* @Param: [ inThreadTreeNode *T ]
* @return: null
* @Author: liyangyang
* @Date: 2023/10/7 23:49
* @Description: 获取下一个元素
*/
inThreadTreeNode *getNext(inThreadTreeNode *T) {
//    ==1 一直指向后继
    if (T->rtag == 1) return T->rchild;
    else return getNext(T);
}

#endif //DATASTRUCT_INTHREADTREE_H
