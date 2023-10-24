/**
******************************************************************************  
* File Name      : bstTree.h  
* Author         : leeyangy  
* E-mail         : liyangyang0713@foxmail.com  
* Create         : 2023/10/24 19:20  
******************************************************************************  
*/
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
#ifndef DATASTRUCT_BSTTREE_H
#define DATASTRUCT_BSTTREE_H

#include <iostream>

using namespace std;

typedef struct BSTNode {
    int val;
    struct BSTNode *left;
    struct BSTNode *right;

    BSTNode() : val(0), left(nullptr), right(nullptr) {}

    BSTNode(int x) : val(x), left(nullptr), right(nullptr) {}

    BSTNode(int x, BSTNode *left, BSTNode *right) : val(x), left(left), right(right) {}
} BSTNode;

/**
* @Param: [ BSTNode* root, int val ]
* @return: BSTNode
* @Author: liyangyang
* @Date: 2023/10/24 19:49
* @Description: bst Tree
*/
BSTNode *bstSearch(BSTNode *root, int val) {
    if (root) {
        if (root->val == val) return root;
//      找key可以插入位置
        else if (val < root->val) return bstSearch(root->left, val);
        else return bstSearch(root->right, val);
    } else return nullptr;
}

void bstInsert(BSTNode **root, int val) {
//    判断当前树是否有值
    if (*root == nullptr) {
//        开辟一个存空间
        *root = (BSTNode *) malloc(sizeof(BSTNode));
        (*root)->val = val;
        (*root)->left = nullptr;
        (*root)->right = nullptr;
    } else if (val == (*root)->val) {
        return;
    } else if (val < (*root)->val) {
//        左边插
        bstInsert(&((*root)->left), val);
    } else {
//        大于根节点，往右边插
        bstInsert(&((*root)->right), val);
    }
}

/**
* @Param: [ BSTNode *root ]
* @return: nullptr
* @Author: liyangyang
* @Date: 2023/10/24 20:31
* @Description:
*/
void bstPreOrder(BSTNode *root) {
    if (root) {
        cout << root->val << " ";
        bstPreOrder(root->left);
        bstPreOrder(root->right);
    }

}

#endif //DATASTRUCT_BSTTREE_H
