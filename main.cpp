#include <iostream>

using namespace std;

//����ͷ�ļ�
#include "linklist/singlelinklist.h"

#include "linklist/doublelinklist.h"

int main() {
    // ���������ɾ�Ĳ�
    linklist * node = initLinkList();
    insertHeader(node,1);
    insertHeader(node,2);
    insertHeader(node,3);
    cout << "ͷ��: ";
    printNode(node);

    cout << "β��: ";
    insertTail(node,3);
    insertTail(node,2);
    insertTail(node,1);
    printNode(node);

    cout << "ɾ��ָ��λ�õ�Ԫ��: ";
    deltelinklistpositionnode(node,3);
    printNode(node);

    cout << "�Ƴ�ͷ�ڵ�: ";
    headpush(node);
    printNode(node);

    cout << "�޸�ָ��λ�õĽڵ�Ԫ��: ";
    updatenodevalue(node,2,1);
    printNode(node);

    return 0;
}
