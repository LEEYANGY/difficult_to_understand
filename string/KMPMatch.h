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
//    ���ĳ���
    int length;
//    �����׵�ַ
    char *str;
};

KMPString *initKMPString() {
//    �����ڴ�ռ�
    KMPString *s = (KMPString *) malloc(sizeof(KMPString));
//    ���ĳ���
    s->length = 0;
//    ��������
    s->str = nullptr;
    return s;
}

//���䴮
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
        str->str = (char *) malloc(sizeof(char) * (len + 1)); // len+1 �������� \0
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
* @Description: ����nextֵ
*/
int *getNext(KMPString *str) {
//    �����ڴ�ռ�
    int *next = (int *) malloc(sizeof(int) * str->length);
//    ��������
    int i = 0;
//    next�ĳ�ʼֵ�� -1 ��ʼ
    int j = -1;
    next[i] = j;
    while (i < str->length - 1) {
//        ����nextֵ
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
* @Description: ��ӡnextֵ
*/
void printNext(int *next, int length) {
//    ����next
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
* @Description: kmpƥ���㷨
*/
void kmpMatch(KMPString *master, KMPString *sub, int *next) {
    int i = 0;
    int j = 0;
    while (i < master->length && j < sub->length) {
//        �����ȣ���Ҫ�ƶ�ָ��
        if (j == -1 || master->str[i] == sub->str[j]) {
//            �ƶ�ָ��
            ++i;
            ++j;
        } else {
//            �ִ�����
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
* @Description: �������
*/
void printKMPString(KMPString *str) {
    for (int i = 0; i < str->length; ++i) {
        printf(i == 0 ? "%c" : " -> %c", str->str[i]);
    }
    cout << endl;
}

#endif //DATASTRUCT_KMPMATCH_H
