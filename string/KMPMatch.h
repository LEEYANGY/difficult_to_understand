/**
******************************************************************************  
* File Name      : KMPMatch.h  
* Author         : leeyangy  
* E-mail         : liyangyang0713@foxmail.com  
* Create         : 2023/9/10 20:49  
******************************************************************************  
*/

#ifndef DATASTRUCT_KMPMATCH_H
#define DATASTRUCT_KMPMATCH_H

#include <iostream>

using namespace std;

typedef struct KMPString {
//    串的长度
    int length;
//    串的首地址
    char *str;
};

KMPString *initKMPString() {
//    开辟内存空间
    KMPString *s = (KMPString *) malloc(sizeof(KMPString));
//    串的长度
    s->length = 0;
//    串的内容
    s->str = nullptr;
    return s;
}

//分配串
void KMPStringAssign(KMPString *str, char *data) {
    if (str->str) free(str);
    int len = 0;
    char *tmp = data;
    while (*tmp) {
        ++len;
        ++tmp;
    }

    if (len == 0) {
        str->str = nullptr;
        str->length = 0;
    } else {
        tmp = data;
        str->length = len;
        str->str = (char *) malloc(sizeof(char) * (len + 1)); // len+1 用来保存 \0
        for (int i = 0; i < len; ++i, ++tmp) {
            str->str[i] = *tmp;
        }
    }
}

/**
* @Param: []
* @return: next
* @Author: liyangyang
* @Date: 2023/9/20 0:29
* @Description: 计算next值
*/
int *getNext(KMPString *str) {
//    开辟内存空间
    int *next = (int *) malloc(sizeof(int) * str->length);
//    串的索引
    int i = 0;
//    next的初始值从 -1 开始
    int j = -1;
    next[i] = j;
    while (i < str->length - 1) {
//        计算next值
        if (j == -1 || str->str[i] == str->str[j]) {
            ++i;
            ++j;
            next[i] = j;
        } else {
            j = next[j];
        }
    }
    return next;
}

/**
* @Param: [ int *next, int length ]
* @return: void
* @Author: liyangyang
* @Date: 2023/9/20 0:56
* @Description: 打印next值
*/
void printNext(int *next, int length) {
//    遍历next
    for (int i = 0; i < length; ++i) {
        printf(i == 0 ? "%d" : " -> %d", next[i]);
    }
    cout << endl;
}

/**
* @Param: [ KMPString str1,KMPString str2,int *next ]
* @return:
* @Author: liyangyang
* @Date: 2023/9/20 0:57
* @Description: kmp匹配算法
*/
void kmpMatch(KMPString *master, KMPString *sub, int *next) {
    int i = 0;
    int j = 0;
    while (i < master->length && j < sub->length) {
//        如果相等，需要移动指针
        if (j == -1 || master->str[i] == sub->str[j]) {
//            移动指针
            ++i;
            ++j;
        } else {
//            字串回溯
            j = next[j];
        }
    }
    if (j == sub->length) {
        cout << " kmp match success " << endl;
    } else {
        cout << " kmp match error " << endl;
    }
}

/**
* @Param: [ KMPString *str ]
* @return: void
* @Author: liyangyang
* @Date: 2023/9/20 0:19
* @Description: 链表遍历
*/
void printKMPString(KMPString *str) {
    for (int i = 0; i < str->length; ++i) {
        printf(i == 0 ? "%c" : " -> %c", str->str[i]);
    }
    cout << endl;
}

#endif //DATASTRUCT_KMPMATCH_H
