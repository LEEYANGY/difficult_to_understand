#include <iostream>

using namespace std;

//����ͷ�ļ�
#include "linklist/singlelinklist.h"
#include "linklist/doublelinklist.h"
#include "linklist/looplinklist.h"

int main() {
    // ���������ɾ�Ĳ�
    cout << "���������ɾ�Ĳ�" << endl;
    linklist *node = initLinkList();
    insertHeader(node, 1);
    insertHeader(node, 2);
    insertHeader(node, 3);
    cout << "ͷ��: ";
    printNode(node);

    cout << "β��: ";
    insertTail(node, 3);
    insertTail(node, 2);
    insertTail(node, 1);
    printNode(node);

    cout << "ɾ��ָ��λ�õ�Ԫ��: ";
    deltelinklistpositionnode(node, 3);
    printNode(node);

    cout << "�Ƴ�ͷ�ڵ�: ";
    headpush(node);
    printNode(node);

    cout << "�޸�ָ��λ�õĽڵ�Ԫ��: ";
    updatenodevalue(node, 2, 1);
    printNode(node);

//    ˫������
    cout << "˫���������ɾ�Ĳ�" << endl;

    doublelinklist *d = initdoublelinklist();

    headInsert(d, 1);
    headInsert(d, 2);
    headInsert(d, 3);
    headInsert(d, 4);
    headInsert(d, 5);
    headInsert(d, 6);
    cout << "ͷ��: ";
    printDoubleNode(d);
    cout << endl;

    tailInsert(d, 6);
    tailInsert(d, 5);
    tailInsert(d, 4);
    tailInsert(d, 3);
    tailInsert(d, 2);
    tailInsert(d, 1);
    cout << "β��: ";
    printDoubleNode(d);

    cout << endl << "ѭ������" << endl;

//    ��ʼ������
    loopbacklinklist* loop = initloopbacklinklist();
//    ͷ��
    headInsertLoop(loop,1);
    headInsertLoop(loop,2);
    headInsertLoop(loop,3);
    headInsertLoop(loop,4);
    cout << "ͷ��: ";
    printloopbacklinklist(loop);
    cout << endl;

    //    β��
    tailInsertLoop(loop,8);
    tailInsertLoop(loop,7);
    tailInsertLoop(loop,6);
    tailInsertLoop(loop,5);
    cout << "β��: ";
    printloopbacklinklist(loop);
    cout << endl;

    return 0;
}
