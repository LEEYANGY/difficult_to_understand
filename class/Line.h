//
// Created by leeyangy on 2023/11/8.
//

#ifndef SERVER_LINE_H
#define SERVER_LINE_H

#include <iostream>

using namespace std;

class Line {
public:
//    double length;

//    void setLength(double len);

    double getLength();

    // 简单的构造函数
    Line(double len);

    // 拷贝构造函数
    Line(const Line &obj);
    void display();
    ~Line();

private:
    double *ptr;
//protected:
};

Line::Line(double len) {
    cout << "调用构造函数" << endl;
    // 为指针分配内存
    ptr = new double;
    *ptr = len;
//    this->length = len;
}

Line::Line(const Line &obj) {
    cout << "调用拷贝构造函数并为指针 ptr 分配内存" << endl;
    ptr = new double;
    // 拷贝值
    *ptr = *obj.ptr;
}

Line::~Line(void) {
    cout << "释放内存" << endl;
    delete ptr;
}

// 成员函数定义
//获取绳长度
double Line::getLength() {
//    return length;
    return *ptr;
}

//void Line::setLength(double len) {
//    length = len;
//}

void display(Line obj) {
    cout << "line 大小 : " << obj.getLength() << endl;
}

#endif //SERVER_LINE_H
