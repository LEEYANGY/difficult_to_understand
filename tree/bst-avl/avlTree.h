/**
******************************************************************************  
* File Name      : avlTree.h  
* Author         : leeyangy  
* E-mail         : liyangyang0713@foxmail.com  
* Create         : 2023/10/24 23:22  
******************************************************************************  
*/

#ifndef DATASTRUCT_AVLTREE_H
#define DATASTRUCT_AVLTREE_H

#include <iostream>

using namespace std;

// 平衡二叉排序树
typedef struct avlTreeNode {
//    数据域
    int val;
//    记录高度
    int height;
//    左子树和右子树
    avlTreeNode *left;
    avlTreeNode *right;

//    构造方法
    avlTreeNode() : val(0), height(0), left(nullptr), right(nullptr) {}

    avlTreeNode(int x) : val(x), height(0), left(nullptr), right(nullptr) {}

    avlTreeNode(int x, avlTreeNode *left, avlTreeNode *right) : val(x), height(0), left(left), right(right) {}
} avlTreeNode;

/**
* @Param: [ avlTreeNode * node ]
* @return:
* @Author: liyangyang
* @Date: 2023/10/25 0:39
* @Description: 获取树的高度
*/
int getAvlTreeHeight(avlTreeNode *node) {
    return node ? node->height : 0;
}

/**
* @Param: [ (int a, int b ]
* @return: int
* @Author: liyangyang
* @Date: 2023/10/25 19:27
* @Description: 返回最大高度
*/
int avlTreeMaxHeight(int a, int b) {
    return a > b ? a : b;
}

/**
* @Param: [ avlTreeNode *node, avlTreeNode **root ]
* @return: void
* @Author: liyangyang
* @Date: 2023/10/25 0:43
* @Description: LL调整
*/
void llRotation(avlTreeNode *node, avlTreeNode **root) {
//    先取到左孩子
    avlTreeNode *tmp = node->left;
    node->left = tmp->right;
    tmp->right = node;
//    调整树的高度
    node->height = avlTreeMaxHeight(getAvlTreeHeight(node->left), getAvlTreeHeight(node->right)) + 1;
    tmp->height = avlTreeMaxHeight(getAvlTreeHeight(tmp->left), getAvlTreeHeight(tmp->right)) + 1;
    *root = tmp;
}

/**
* @Param: [ avlTreeNode *node, avlTreeNode **root ]
* @return: void
* @Author: liyangyang
* @Date: 2023/10/25 19:23
* @Description: RR调整
*/
void rrRotation(avlTreeNode *node, avlTreeNode **root) {
//    先取到右孩子
    avlTreeNode *tmp = node->right;
    node->right = tmp->left;
    tmp->left = node;
//    调整树的高度
    node->height = avlTreeMaxHeight(getAvlTreeHeight(node->left), getAvlTreeHeight(node->right)) + 1;
    tmp->height = avlTreeMaxHeight(getAvlTreeHeight(tmp->left), getAvlTreeHeight(tmp->right)) + 1;
    *root = tmp;
}

/**
* @Param:
* @return: 
* @Author: liyangyang
* @Date: 2023/10/25 0:20
* @Description: 平衡二叉排序树，插入
*/
void avlTreeInsert(avlTreeNode **node, int val) {
//    初始状态,空的话，为其分配内存空间
    if (*node == nullptr) {
        *node = (avlTreeNode *) malloc(sizeof(avlTreeNode));
        (*node)->val = val;
        (*node)->height = 0;
        (*node)->left = nullptr;
        (*node)->right = nullptr;
    }
//    否则就向左子树插入数据
    else if (val < (*node)->val) {
        avlTreeInsert(&(*node)->left, val);
//        获取高度
        int lh = getAvlTreeHeight((*node)->left);
        int rh = getAvlTreeHeight((*node)->right);
//        判断高度差
        if (lh - rh == 2) {
            if (val < (*node)->left->val) {
//            LL 调整
                llRotation(*node, node);
            } else {
//            LR调整
                rrRotation((*node)->left, &(*node)->left);
                llRotation(*node, node);
            }
        }
    }
//    否则就向右子树插入数据
    else if (val > (*node)->val) {
        avlTreeInsert(&(*node)->right, val);
        //        获取高度
        int lh = getAvlTreeHeight((*node)->left);
        int rh = getAvlTreeHeight((*node)->right);
//        判断高度差
        if (rh - lh == 2) {
            if (val > (*node)->right->val) {
//            RR 调整
                rrRotation(*node, node);
            } else {
//            RL调整
                llRotation((*node)->right, &(*node)->right);
                rrRotation(*node, node);
            }
        }
    }
//    更新高度
    (*node)->height = avlTreeMaxHeight(getAvlTreeHeight((*node)->left), getAvlTreeHeight((*node)->right)) + 1;
}

void avlPreOrder(avlTreeNode *node) {
    if (node != nullptr) {
        cout << node->val << " ";
        avlPreOrder(node->left);
        avlPreOrder(node->right);
    }
}

void avlInOrder(avlTreeNode *node) {
    if (node != nullptr) {
        avlInOrder(node->left);
        cout << node->val << " ";
        avlInOrder(node->right);
    }
}

void avlPostOrder(avlTreeNode *node) {
}

#endif //DATASTRUCT_AVLTREE_H
