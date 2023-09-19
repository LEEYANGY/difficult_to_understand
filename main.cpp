#include <iostream>

using namespace std;

//引入头文件
#include "linklist/singlelinklist.h"
#include "linklist/doublelinklist.h"
#include "linklist/looplinklist.h"
#include "linklist/doublelooplinklist.h"
#include "string/forceMatch.h"
#include "string/KMPMatch.h"

int main() {
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
    return 0;
}
