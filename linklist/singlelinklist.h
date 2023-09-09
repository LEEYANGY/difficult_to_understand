#include <iostream>

using namespace std;

//定义一个结构体
struct linklist {
    int data;
    struct linklist *next;
};

//初始化
linklist *initLinkList() {
//    初始化一个链表，头节点
    linklist *head = new linklist();
//    头节点记录总结点数量
    head->data = 0;
//    指向空
    head->next = nullptr;
//    返回node
    return head;
}

//头插
linklist *insertHeader(linklist *node, int num) {
//    判断链表是否存在
//    if (node->next != nullptr) {
//        return nullptr;
//    }

//    节点赋值
    linklist *insert = new linklist();
//    insert->next = nullptr;
    insert->data = num;
//    头节点计数
    ++node->data;
//    插入节点记录头节点的下一个节点地址
    insert->next = node->next;
//    头节点指向插入节点，完成头插
    node->next = insert;
    return node;
}

//尾插，类似push操作
linklist *insertTail(linklist *node, int num) {
//    遍历节点到尾部,使用动态内存分配
    linklist *insert = (linklist *) malloc(sizeof(linklist));
//    节点赋值
    insert->data = num;
    insert->next = nullptr;

    ++node->data;
    node = node->next;
//    遍历原链表到尾部,进行插入
    while (node->next != nullptr) {
        node = node->next;
    }
//    原链表指向新节点
    node->next = insert;
    return node;
}

//删除指定位置节点
int deltelinklistpositionnode(linklist *node, int position) {
    if (position >= node->data) return -1;

//    位置标记
    int flag = 1;
    linklist *head = node;
    while (node) {
        node = node->next;
//        如果找到了要删除的指定位置的元素,跳出循环
        if (++flag == position) break;
    }
//    临时节点
    linklist *deletenode = (linklist *) malloc(sizeof(linklist));
    deletenode->next = node->next;
    deletenode->data = node->data;
//    移除节点
    node->next = deletenode->next->next;
//    获取被删除元素的值
    int value = deletenode->next->data;
    --head->data;
//    释放内存
    free(deletenode);
    free(head);
//    返回被移除元素
    return value;
}

//移除头节点
int headpush(linklist *node) {
    if (!node) return -1;
//    保存头节点
    linklist *head = node;
//    被删除元素
    int value = 0;
//    获取头节点
    --node->data;
    node = node->next;
//    记录被移除节点
    value = node->data;
    head->next = node->next;
//    释放内存
    free(node);
    return value;
}


//指定位置元素的值修改 , -1失败 1成功
int updatenodevalue(linklist *node, int position, int value) {
    if (position >= node->data) return -1;
//        头节点向后移动
    node = node->next;
    int flag = 0;
    while (node) {
        if (++flag == position) break;
        node = node->next;
    }
    node ->data = value;
    return 1;
}

//遍历节点
void printNode(linklist *node) {
//    头节点，指向下一个
    node = node->next;
    while (node) {
        cout << node->data << " ";
//        移动节点
        node = node->next;
    }
    cout << endl;
}
