/**
******************************************************************************  
* File Name      : tree.h  
* Author         : leeyangy  
* E-mail         : liyangyang0713@foxmail.com  
* Create         : 2023/10/4 16:57
* Description    : 递归遍历二叉树
******************************************************************************  
*/

#ifndef DATASTRUCT_TREE_H
#define DATASTRUCT_TREE_H

#include <iostream>

using namespace std;

typedef struct TreeNode {
    char data;
//    左子树
    struct TreeNode *lchild;
//    右子树
    struct TreeNode *rchild;
} TreeNode;

/**
* @Param: [ TreeNode **T, char *data, int *index ]
* @return: null
* @Author: liyangyang
* @Date: 2023/10/4 17:06
* @Description: 创建二叉树
*/
void createTree(TreeNode **T, char *data, int *index) {
    // 创建二叉树
    char ch;
    // 读入数据
    ch = data[*index];
//    索引向下走
    *index += 1;
    if (ch == '#') {
//        此时为空节点
        *T = nullptr;
    } else {
//        此时不为空，开辟内存空间
        *T = (TreeNode *) malloc(sizeof(TreeNode));
        (*T)->data = ch;
//        创建左子树
        createTree(&((*T)->lchild), data, index);
//        创建右子树
        createTree(&((*T)->rchild), data, index);
    }
}

/**
* @Param: [ TreeNode *T ]
* @return: null
* @Author: liyangyang
* @Date: 2023/10/4 17:31
* @Description: 先序遍历二叉树
*/
void preOrder(TreeNode *T) {
//    T == null 为空树
    if (T == nullptr) {
//        跳出递归
        return;
    } else {
//        否则遍历树
//      先办事，在处理左右孩子
        cout << T->data;
//        遍历左子树
        preOrder(T->lchild);
//        遍历右子树
        preOrder(T->rchild);
    }
}

/**
* @Param: [ TreeNode *T ]
* @return: null
* @Author: liyangyang
* @Date: 2023/10/4 17:35
* @Description: 中序遍历
*/
void midOrder(TreeNode *T) {
//    T == null 为空树
    if (T == nullptr) {
//        跳出递归
        return;
    } else {
//        否则遍历树
//      先办事，在处理左右孩子
//        遍历左子树
        midOrder(T->lchild);
        cout << T->data;
//        遍历右子树
        midOrder(T->rchild);
    }
}

/**
* @Param: [ TreeNode *T ]
* @return: null
* @Author: liyangyang
* @Date: 2023/10/4 17:35
* @Description: 后序遍历
*/
void postOrder(TreeNode *T) {
//    T == null 为空树
    if (T == nullptr) {
//        跳出递归
        return;
    } else {
//        否则遍历树
//      先处理左右孩子
//        遍历左子树
        postOrder(T->lchild);
//        遍历右子树
        postOrder(T->rchild);
//        后输出
        cout << T->data;
    }
}

#endif //DATASTRUCT_TREE_H
