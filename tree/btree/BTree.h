/**
******************************************************************************  
* File Name      : BTree.h  
* Author         : leeyangy  
* E-mail         : liyangyang0713@foxmail.com  
* Create         : 2023/11/15 19:08  
******************************************************************************  
*/

#ifndef DATASTRUCT_BTREE_H
#define DATASTRUCT_BTREE_H

#include <iostream>

using namespace std;
//b树结构体
typedef struct BTreeNode {
    // 树的阶数
    int level;
//    关键字数量
    int keyNum;
//    孩子数量
    int childNum;
//    关键字数组
    int *keys;
//    孩子数组
    struct BTreeNode **childs;
//    父亲指针
    struct BTreeNode *parent;
} BTreeNode;

/**
* @Param:
* @return:
* @Author: liyangyang
* @Date: 2023/11/15 19:37
* @Description: 初始化b树
*/
BTreeNode *initBTree(int level) {
    auto *bTree = (BTreeNode *) malloc(sizeof(BTreeNode));
    bTree->level = level;
    bTree->keyNum = 0;
    bTree->childNum = 0;
    bTree->keys = (int *) malloc(sizeof(int) * (level + 1));
    bTree->childs = (BTreeNode **) malloc(sizeof(BTreeNode *) * level);
    bTree->parent = nullptr;
    for (int i = 0; i < level; ++i) {
        bTree->keys[i] = 0;
        bTree->childs[i] = nullptr;
    }
    return bTree;
}

/**
* @Param:
* @return:
* @Author: liyangyang
* @Date: 2023/11/15 20:23
* @Description: 找下标
*/
int findSuiteIndex(BTreeNode *bTree, int data) {
    int index;
    for (index = 1; index <= bTree->keyNum; ++index) {
        if (data < bTree->keys[index]) break;
    }
    return index;
}

/**
* @Param: 
* @return: 
* @Author: liyangyang
* @Date: 2023/11/15 20:25
* @Description: 找叶结点
*/
BTreeNode *findSuiteLeafNode(BTreeNode *T, int data) {
    if (T->childNum == 0) return T;
    else {
        int index = findSuiteIndex(T, data);
        return findSuiteLeafNode(T->childs[index - 1], data);
    }
}

void addData(BTreeNode *bTree, int data, BTreeNode **T) {
    int index = findSuiteIndex(bTree, data);
    for (int i = bTree->keyNum; i >= index; --i) {
        bTree->keys[i + 1] = bTree->keys[i];
    }
    bTree->keys[index] = data;
    bTree->keyNum++;
//    判断是否需要分裂(找到分裂位置)
    if (bTree->keyNum == bTree->level) {
        int mid = bTree->level / 2 + bTree->level % 2;
//        生成两个结点
        auto *lchild = initBTree(bTree->level);
        auto *rchild = initBTree(bTree->level);
        for (int i = 1; i < mid; ++i) {
//            lchild->keys[i] = bTree->keys[i];
//            lchild->keyNum++;
            addData(lchild, bTree->keys[i], T);
        }
        for (int i = mid + 1; i <= bTree->keyNum; ++i) {
            addData(rchild, bTree->keys[i], T);
        }
        for (int i = 0; i < mid; ++i) {
            lchild->childs[i] = bTree->childs[i];
            if (bTree->childs[i] != nullptr) {
                bTree->childs[i]->parent = lchild;
                lchild->childNum++;
            }
        }
        index = 0;
        for (int i = mid; i < bTree->childNum; ++i) {
            rchild->childs[index++] = bTree->childs[i];
            if (bTree->childs[i] != nullptr) {
                bTree->childs[i]->parent = rchild;
                rchild->childNum++;
            }
        }
//        对父亲进行判断
        if (bTree->parent == nullptr) {
            BTreeNode *newParent = initBTree(bTree->level);
            addData(newParent, bTree->keys[mid], T);
            newParent->childs[0] = lchild;
            newParent->childs[1] = rchild;
            newParent->childNum = 2;
            lchild->parent = newParent;
            rchild->parent = newParent;
            *T = newParent;
        } else {
            index = findSuiteIndex(bTree->parent, bTree->keys[mid]);
            lchild->parent = bTree->parent;
            rchild->parent = bTree->parent;
            bTree->parent->childs[index - 1] = lchild;
            if (bTree->parent->childs[index] != nullptr) {
                for (int i = bTree->parent->childNum - 1; i >= index; --i) {
                    bTree->parent->childs[i + 1] = bTree->parent->childs[i];
                }
            }
            bTree->parent->childs[index] = rchild;
            bTree->parent->childNum++;
            addData(bTree->parent, bTree->keys[mid], T);
        }
    }
}

/**
* @Param: 
* @return: 
* @Author: liyangyang
* @Date: 2023/11/15 21:07
* @Description: 插入
*/
void insertBTree(BTreeNode **T, int data) {
    auto *node = findSuiteLeafNode(*T, data);
    addData(node, data, T);
}

void printBTree(BTreeNode *T) {
    if (T != nullptr) {
        for (int i = 1; i <= T->keyNum; ++i) {
            cout << T->keys[i] << " ";
        }
        cout << endl;
        for (int i = 0; i < T->childNum; ++i) {
            printBTree(T->childs[i]);
        }
    }
}

#endif //DATASTRUCT_BTREE_H
