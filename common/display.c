//
// Created by LEEYANGY on 2022/5/20.
//

#include "common.h"
//
// Created by LEEYANGY on 2022/5/20.
//
void display_menu(){
    printf("-------欢迎使用学生管理系统--------\n");
    printf("--------1.添加学生---------------\n");
    /**
     * 正常的尾插数据
     */
    printf("--------2.查看学生---------------\n");
    /**
     * 搜索进行删除
     */
    printf("--------3.删除学生---------------\n");
    /**
     * 读取文件
     * 将文件内容读到链表里
     */
    printf("--------4.打开文件---------------\n");
    /**
     * 文件以乱序形式存储，打开后按需进行排序
     */
    printf("--------5.保存数据---------------\n");
    /**
     * 直接删除整个保存的数据
     */
    printf("--------6.删除数据(不可逆操作，谨慎!)\n");
    printf("--------0.退出------------------\n");
}


