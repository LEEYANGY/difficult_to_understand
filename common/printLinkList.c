//
// Created by LEEYANGY on 2022/5/20.
//

#include "common.h"

void printLinkList(struct student *head) {

//    printf("姓名       学号  c    web\n");
//    while (head != NULL) {
//        printf("%-10s %7d  %.2lf  %.2lf\n", head->name, head->id, head->score_c, head->score_web);
//        saveFile(head);
//        head = head->next;
//    }

//    如果文件能正常打开就把我想要的内容输入到文件里保存
    if (checkfile() == 1) {
        printf("姓名       学号  c    web\n");
        while (head != NULL) {
            printf("%-10s %7d  %.2lf  %.2lf\n", head->name, head->id, head->score_c, head->score_web);
//            加上一个指定的文件写入类型
            saveFile(head);
            head = head->next;
        }
        printf("文件保存成功!\n");
//     打开文件失败就正常输出到屏幕上
    } else {
        printf("姓名       学号  c    web\n");
        while (head != NULL) {
            printf("%-10s %7d  %.2lf  %.2lf\n", head->name, head->id, head->score_c, head->score_web);
            head = head->next;
        }
    }
}