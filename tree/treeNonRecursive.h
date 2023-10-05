/**
******************************************************************************  
* File Name      : treeNonRecursive.h  
* Author         : leeyangy  
* E-mail         : liyangyang0713@foxmail.com  
* Create         : 2023/10/5 23:58  
******************************************************************************  
*/

#ifndef DATASTRUCT_TREENONRECURSIVE_H
#define DATASTRUCT_TREENONRECURSIVE_H

#include <iostream>
#include "tree.h"

//treeNode����

//��ջʵ��
typedef struct StackNode {
    TreeNode *data;
    struct StackNode *next;
} StackNode;

/**
* @Param: [ TreeNode **T, char *data, int *index ]
* @return: null
* @Author: liyangyang
* @Date: 2023/10/6 0:02
* @Description: ������
*/
void createNonTree(TreeNode **T, char *data, int *index) {
    char ch;
    ch = data[(*index)++];
    if (ch == '#') *T = nullptr;
    else {
//        �����ڴ�ռ�
        *T = (TreeNode *) malloc(sizeof(TreeNode));
        (*T)->data = ch;
        createNonTree(&((*T)->lchild), data, index);
        createNonTree(&((*T)->rchild), data, index);
    }
}

/**
* @Param:
* @return:
* @Author: liyangyang
* @Date: 2023/10/6 0:06
* @Description: ��ʼ��ջ�ĺ���
*/
StackNode *initStack() {
    auto *S = (StackNode *) malloc(sizeof(StackNode));
    S->data = nullptr;
    S->next = nullptr;
    return S;
}

/**
* @Param: [ TreeNode *data, StackNode *S ]
* @return: null
* @Author: liyangyang
* @Date: 2023/10/6 0:08
* @Description: ��ջ
*/
void push(TreeNode *data, StackNode *S) {
    auto *node = (StackNode *) malloc(sizeof(StackNode));
    node->data = data;
    node->next = S->next;
    S->next = node;
}

int isEmpty(StackNode *S) {
    if (S->next == nullptr) return 1;
    else return 0;
}

/**
* @Param: [ StackNode *S  ]
* @return:
* @Author: liyangyang
* @Date: 2023/10/6 0:10
* @Description: ��ջ
*/
StackNode *pop(StackNode *S) {
    if (isEmpty(S)) return nullptr;
    else {
        StackNode *node = S->next;
        S->next = node->next;
        return node;
    }
}

/**
* @Param: [ TreeNode *T ]
* @return: null
* @Author: liyangyang
* @Date: 2023/10/6 0:31
* @Description: �������
*/
void preNonOrder(TreeNode *T) {
    cout << "�������" << endl;
    TreeNode *node = T;
    StackNode *S = initStack();
    while (node || !isEmpty(S)) {
        if (node) {
            cout << node->data << " ";
            push(node, S);
            node = node->lchild;
        } else {
            node = pop(S)->data;
            node = node->rchild;
        }
    }
    cout << endl;
}

/**
* @Param: [ TreeNode *T ]
* @return: null
* @Author: liyangyang
* @Date: 2023/10/6 0:31
* @Description: �������
*/
void inNonOrder(TreeNode *T) {
    cout << "�������" << endl;
    TreeNode *node = T;
    StackNode *S = initStack();
    while (node || !isEmpty(S)) {
        if (node) {
            push(node, S);
            node = node->lchild;
        } else {
            node = pop(S)->data;
            cout << node->data << " ";
            node = node->rchild;
        }
    }
    cout << endl;
}

//  �������

typedef struct TreeNodePost {
    char data;
    struct TreeNodePost *lchild;
    struct TreeNodePost *rchild;
//    ��ʼ״̬
    int flag = 0;
} TreeNodePost;

typedef struct StackNodePost {
    TreeNodePost *data;
    struct StackNodePost *next;
} StackNodePost;

/**
* @Param:
* @return:
* @Author: liyangyang
* @Date: 2023/10/6 0:06
* @Description: ��ʼ��ջ�ĺ���
*/
StackNodePost *initStackPost() {
    auto *S = (StackNodePost *) malloc(sizeof(StackNodePost));
    S->data = nullptr;
    S->next = nullptr;
    return S;
}

/**
* @Param: [ TreeNode **T, char *data, int *index ]
* @return: null
* @Author: liyangyang
* @Date: 2023/10/6 0:02
* @Description: ������ --> �������
*/
void createNonTreePost(TreeNodePost **T, char *data, int *index) {
    char ch;
    ch = data[(*index)++];
    if (ch == '#') *T = nullptr;
    else {
//        �����ڴ�ռ�
        *T = (TreeNodePost *) malloc(sizeof(TreeNodePost));
        (*T)->data = ch;
        (*T)->flag = 0;
        createNonTreePost(&((*T)->lchild), data, index);
        createNonTreePost(&((*T)->rchild), data, index);
    }
}

int isEmptyPost(StackNodePost *S) {
    if (S->next == nullptr) return 1;
    else return 0;
}


/**
* @Param: [ TreeNode *data, StackNode *S ]
* @return: null
* @Author: liyangyang
* @Date: 2023/10/6 0:08
* @Description: ��ջ
*/
void pushPost(TreeNodePost *data, StackNodePost *S) {
    auto *node = (StackNodePost *) malloc(sizeof(StackNodePost));
    node->data = data;
    node->next = S->next;
    S->next = node;
}

/**
* @Param: [ StackNode *S  ]
* @return:
* @Author: liyangyang
* @Date: 2023/10/6 0:10
* @Description: ��ջ
*/
StackNodePost *popPost(StackNodePost *S) {
    if (isEmptyPost(S)) return nullptr;
    else {
        StackNodePost *node = S->next;
        S->next = node->next;
        return node;
    }
}

/**
* @Param: [ StackNode *S  ]
* @return:
* @Author: liyangyang
* @Date: 2023/10/6 0:10
* @Description: ��ջ
*/
StackNodePost *getTopPost(StackNodePost *S) {
    if (isEmptyPost(S)) return nullptr;
    else {
        StackNodePost *node = S->next;
        return node;
    }
}

/**
* @Param: [ TreeNode *T ]
* @return: null
* @Author: liyangyang
* @Date: 2023/10/6 0:31
* @Description: �������
*/
void postNonOrder(TreeNodePost *T) {
    cout << "�������" << endl;
    TreeNodePost *node = T;
    StackNodePost *S = initStackPost();
    while (node || !isEmptyPost(S)) {
        if (node) {
//            ��ջ����
            pushPost(node, S);
//            ������
            node = node->lchild;
        } else {
//            ����Ϊ�պ�
            TreeNodePost *top = getTopPost(S)->data;
            if (top->rchild && top->rchild->flag == 0) {
                top = top->rchild;
                pushPost(top, S);
                node = top->lchild;
            } else {
                top = popPost(S)->data;
                cout << top->data << " ";
//                ������ɺ��޸ı��,��ʾ�Ѿ����ʹ���
                top->flag = 1;
            }
        }
    }
    cout << endl;
}

#endif //DATASTRUCT_TREENONRECURSIVE_H
