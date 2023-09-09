#include <iostream>

using namespace std;

//引入头文件
#include "linklist/singlelinklist.h"
#include "linklist/doublelinklist.h"
#include "linklist/looplinklist.h"

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
    loopbacklinklist* loop = initloopbacklinklist();
//    头插
    headInsertLoop(loop,1);
    headInsertLoop(loop,2);
    headInsertLoop(loop,3);
    headInsertLoop(loop,4);
    cout << "头插: ";
    printloopbacklinklist(loop);
    cout << endl;

    //    尾插
    tailInsertLoop(loop,8);
    tailInsertLoop(loop,7);
    tailInsertLoop(loop,6);
    tailInsertLoop(loop,5);
    cout << "尾插: ";
    printloopbacklinklist(loop);
    cout << endl;

    return 0;
}
