//
// Created by leeyangy on 2023/11/8.
//

#ifndef SERVER_LINE_H
#define SERVER_LINE_H

#include <iostream>

using namespace std;

class Line {
public:
    double length;

    void setLength(double len) {
        length = len;
    }

    double getLength() {
        return length;
    }
//private:
//protected:
};

// 成员函数定义
//获取绳长度
//double Line::getLength() {
//    return length;
//}

//void Line::setLength(double len) {
//    length = len;
//}


#endif //SERVER_LINE_H
