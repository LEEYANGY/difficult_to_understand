#include "common/common.h"

int main() {
//    创建链表
    struct student *current = creatLinkList();
//    打印结果
    printLinkList(current);
    printf("创建链表函数执行成功！-----------\n");
//    按id插入，插不进就失败
    current = insert(current, 1004, 1001);
//    打印结果
    printLinkList(current);
    printf("插入元素函数执行成功-------------\n");
//    查找一个学号1004的学生
    searchID(current, 1004);
    printf("查找元素函数执行成功--------------\n");
//    按id修改
    current = modify(current, 1001, 1002);
    printLinkList(current);
    printf("修改元素函数执行成功--------------\n");
//    按id删除元素
    current = del(current, 1004);
    printLinkList(current);
    printf("删除元素函数执行成功--------------\n");
    freeLinkList(current);
    printf("释放内存函数执行成功--------------\n");
//    saveFile();
    readFile();
    printf("读取文件成功！ ");
    return 0;
}
