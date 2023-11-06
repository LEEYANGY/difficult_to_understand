#include <iostream>

using namespace std;

//引入头文件
#include "linklist/singlelinklist.h"
#include "linklist/doublelinklist.h"
#include "linklist/looplinklist.h"
#include "linklist/doublelooplinklist.h"
#include "string/forceMatch.h"
#include "string/KMPMatch.h"
#include "tree/tree.h"
#include "tree/treeLevelTraverse.h"
#include "tree/treeNonRecursive.h"
#include "tree/tagTree/inThreadTree.h"
#include "tree/bst/bstTree.h"
#include "tree/bst-avl/avlTree.h"
#include "tree/huffman/huffmanTree.h"
#include "graph/graph.h"

int main(int argc, char *argv[]) {
    // 单链表的增删改查
    cout << "单链表的增删改查" << endl;
    linklist *node = initLinkList();
    insertHeader(node, 1);
    insertHeader(node, 2);
    insertHeader(node, 3);
    cout << "头插: ";
    printNode(node);

    cout << "尾插: ";
    insertTail(node, 3);
    insertTail(node, 2);
    insertTail(node, 1);
    printNode(node);

    cout << "删除指定位置的元素: ";
    deltelinklistpositionnode(node, 3);
    printNode(node);

    cout << "移除头节点: ";
    headpush(node);
    printNode(node);

    cout << "修改指定位置的节点元素: ";
    updatenodevalue(node, 2, 1);
    printNode(node);

//    双向链表
    cout << "双向链表的增删改查" << endl;

    doublelinklist *d = initdoublelinklist();

    headInsert(d, 1);
    headInsert(d, 2);
    headInsert(d, 3);
    headInsert(d, 4);
    headInsert(d, 5);
    headInsert(d, 6);
    cout << "头插: ";
    printDoubleNode(d);
    cout << endl;

    tailInsert(d, 6);
    tailInsert(d, 5);
    tailInsert(d, 4);
    tailInsert(d, 3);
    tailInsert(d, 2);
    tailInsert(d, 1);
    cout << "尾插: ";
    printDoubleNode(d);

    cout << endl << "循环链表" << endl;

//    初始化链表
    loopbacklinklist *loop = initloopbacklinklist();
//    头插
    headInsertLoop(loop, 1);
    headInsertLoop(loop, 2);
    headInsertLoop(loop, 3);
    headInsertLoop(loop, 4);
    cout << "头插: ";
    printloopbacklinklist(loop);
    cout << endl;

    //    尾插
    tailInsertLoop(loop, 8);
    tailInsertLoop(loop, 7);
    tailInsertLoop(loop, 6);
    tailInsertLoop(loop, 5);
    cout << "尾插: ";
    printloopbacklinklist(loop);
    cout << endl;

    cout << "双循环链表";
    doublelooplinklist *dl = initdoublelooplinklist();
    headInsertdoublelooplinklist(dl, 1);
    headInsertdoublelooplinklist(dl, 2);
    headInsertdoublelooplinklist(dl, 3);
    headInsertdoublelooplinklist(dl, 4);
    cout << "头插: ";
    printdoublelooplinklist(dl);

    cout << endl << "暴力匹配串" << endl;
    String *str1 = initString();
    String *str2 = initString();
    stringAssign(str1, "HELLo");
    stringAssign(str2, "HELLO,I'm from Liuzhou City, Guangxi Zhuang Autonomous Region,China");
    printString(str1);
    printString(str2);
    matchString(str2, str1);

    cout << "kmp匹配" << endl;
    KMPString *kstr1 = initKMPString();
    KMPString *kstr2 = initKMPString();
    //    master string
    KMPStringAssign(kstr1, "Hello,I'm Good Boy.");
    //    sub string
    KMPStringAssign(kstr2, "Hello");
    printKMPString(kstr1);
    printKMPString(kstr2);

    cout << "获取next[]" << endl;
    int *next = getNext(kstr2);
    printNext(next, kstr2->length);
    cout << "kmp匹配" << endl;
    kmpMatch(kstr1, kstr2, next);

    TreeNode *T;
//    char *data = "AB##C#D#E##";
    char *data = "AB##C#D#E#FGHIJKLMNOPQRSTUVWXYZ######################";
//    索引
    int index = 0;
//    createTree(&T, argv[1], &index);
    createTree(&T, data, &index);
//    先序遍历
    cout << "先序遍历：" << endl;
    preOrder(T);
    cout << endl << "中序遍历：" << endl;
    midOrder(T);
    cout << endl << "后序遍历：" << endl;
    postOrder(T);
    cout << endl << "层次遍历(先序遍历):" << endl;

    TreeNode *TL;
//    char *chl = "AB##C###";
//    char *chl = "AB##C###";
    char *chl = "ABD##E##CF##G##";
    int index_level = 0;
//    createLevelTree(&TL, argv[1], &index_level);
    createLevelTree(&TL, chl, &index_level);
    preLevelOrder(TL);
    cout << endl << "层次遍历:" << endl;
//    初始化一个Queue
    QueueNode *Q = initQueue();
    levelTraverse(Q, TL);

    cout << endl << "非递归算法的二叉树" << endl;
    TreeNode *TN;
    int index_Non = 0;
//    char *chn = "AB##C##";
    char *chn = "ABD##E##CF##G##";
    createNonTree(&TN, chn, &index_Non);
    preNonOrder(TN);
    inNonOrder(TN);

    StackNodePost *SP = initStackPost();
    TreeNodePost *TNP;
    int index_NonPost = 0;
    char *chnp = "ABD#F##E##C##";
    createNonTreePost(&TNP, chnp, &index_NonPost);
    postNonOrder(TNP);
//    postNonOrder(TN);

//    创建线索二叉树
    cout << "线索二叉树中序遍历:" << endl;
    inThreadTreeNode *iTTN;
    inThreadTreeNode *pre = nullptr;
    char *chittn = "ABD##E##CF##G##";
    int index_ittn = 0;
    createInThreadTree(&iTTN, chittn, &index_ittn);
    inThreadTree(iTTN, &pre);
    pre->rtag = 1;
    pre->rchild = nullptr;

    for (inThreadTreeNode *node = getFirst(iTTN); node != nullptr; node = getNext(node))
        cout << node->data << " ";
    cout << endl;

    cout << "二叉排序树" << endl;
    BSTNode *bst = nullptr;
    int nums[6] = {4, 5, 19, 23, 2, 8};
//    int nums[7] = {8, 6, 10, 9, 11, 23, 6};
//    for (int x = 0; x < sizeof(nums) / sizeof(int); ++x) {
//        bstInsert(&bst, nums[x]);
//    }
    for (auto num: nums) {
        bstInsert(&bst, num);
    }
    bstPreOrder(bst);

    cout << endl << "平衡二叉排序树" << endl;
    avlTreeNode *atn = nullptr;
    int avl_nums[5] = {1, 2, 3, 4, 5};
    for (auto avl_num: avl_nums) {
        avlTreeInsert(&atn, avl_num);
    }
    avlPreOrder(atn);

    cout << endl << "哈夫曼树" << endl;
////    初始化哈夫曼树
//    int weight[6] = {1, 2, 3, 6, 4, 5};
//    HFTree *hft = initHFTree(weight, sizeof(weight) / sizeof(weight[0]));
//    createHFTree(hft);
//    preOrderHFTree(hft, hft->length - 1);

    cout << endl;

//    分配一个5个顶点，5条边的图
    Graph *G = initGraph(5);
    int edge[5][5] = {
            0, 1, 1, 1, 0,
            1, 0, 1, 1, 1,
            1, 1, 0, 0, 0,
            1, 1, 0, 0, 1,
            0, 1, 0, 1, 0
    };
    createGraph(G, "ABCDE", (int *) edge);
    cout << "深度优先搜索" << endl;
//    访问表，查询是否被访问了
    int *visited = (int *) malloc(sizeof(int) * G->vertexNum);
    for (int i = 0; i < G->vertexNum; ++i) visited[i] = 0;
    dfs(G, visited, 0);
    cout << endl;
//    重新给数组赋值
    for (int i = 0; i < G->vertexNum; ++i) visited[i] = 0;
    cout << "广度优先搜索" << endl;
    bfs(G, visited, 0);
    cout << endl;
    // 释放图顶点内存
    free(G->vertex);
    // 释放图边内存
    for (int i = 0; i < G->vertexNum; ++i) {
        free(G->edge[i]);
    }
    free(G->edge);
    // 释放图结构内存
    free(G);
    return 0;
}
