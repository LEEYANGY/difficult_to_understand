/*******************************************************************************
 * File Name      : forceMatch.h
 * Author         : leeyangy
 * E-mail         : liyangyang0713@foxmail.com
 * Create         : 2023/9/10 16:37
  ******************************************************************************/
#ifndef DATASTRUCT_FORCEMATCH_H
#define DATASTRUCT_FORCEMATCH_H

#include <iostream>

using namespace std;

typedef struct String {
//    记录字符串长度
    int length;
//    保存字符串首地址
    char *str;
};

/**
* @Param:
* @return: bool
* @Author: liyangyang
* @Date: 2023/9/10 15:12
* @Description: 判空，空串返回true ,否则返回 false
*/
bool StrEmpty(String *str) {
    return false;
}

/**
* @Param: null
* @return: struct String*
* @Author: liyangyang
* @Date: 2023/9/10 16:47
* @Description: 初始化串
*/
String *initString() {
//    开辟内存空间
    String *s = (String *) malloc(sizeof(String));
//    串的长度
    s->length = 0;
//    串的内容
    s->str = nullptr;
    return s;
}

/**
* @Param: *str,*data
* @return: nu;;
* @Author: liyangyang
* @Date: 2023/9/10 20:03
* @Description: 写入串
*/
void stringAssign(String *str, char *data) {
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
        str->str = (char *) malloc(sizeof(char) * (len + 1));
        for (int i = 0; i < len; ++i, ++tmp) {
            str->str[i] = *tmp;
        }
    }

}


/**
* @Param: [masterString 主串,subString 子串]
* @return: int
* @Author: liyangyang
* @Date: 2023/9/10 15:10
* @Description: 暴力匹配主串
*/
int matchString(String *masterString, String *subString) {
//    下标
    int i = 0;
    int j = 0;

    while (i < masterString->length && j < subString->length) {
//        移动下标
        if (masterString->str[i] == subString->str[j]) {
            ++i;
            ++j;
//            回溯
        } else {
            i = i - j + 1;
            j = 0;
        }
    }

    if (j == subString->length) {
        cout << "force match success." << endl;
//        匹配成功返回找到的下标
        return j;
    } else {
        cout << "force match error." << endl;
//        匹配失败返回0
        return 0;
    }
}

/**
* @Param: *str
* @return: null
* @Author: liyangyang
* @Date: 2023/9/10 19:13
* @Description: 打印串中内容。
*/
void printString(String *str) {
    for (int i = 0; i < str->length; ++i) {
        printf(i == 0 ? "%c" : "-> %c", str->str[i]);
    }
    cout << endl;
}

#endif //DATASTRUCT_FORCEMATCH_H
