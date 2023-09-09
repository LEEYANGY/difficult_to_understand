#include <iostream>

using namespace std;

//引入头文件
#include "linklist/singlelinklist.h"

#include "linklist/doublelinklist.h"

int main() {
    // 单链表的增删改查
    linklist * node = initLinkList();
    insertHeader(node,1);
    insertHeader(node,2);
    insertHeader(node,3);
    cout << "头插: ";
    printNode(node);

    cout << "尾插: ";
    insertTail(node,3);
    insertTail(node,2);
    insertTail(node,1);
    printNode(node);

    cout << "删除指定位置的元素: ";
    deltelinklistpositionnode(node,3);
    printNode(node);

    cout << "移除头节点: ";
    headpush(node);
    printNode(node);

    cout << "修改指定位置的节点元素: ";
    updatenodevalue(node,2,1);
    printNode(node);

    return 0;
}
