//
// Created by leeyangy on 2023/11/8.
//

#ifndef SERVER_SHAPE_H
#define SERVER_SHAPE_H

#include <iostream>

using namespace std;

class Shape {
public:
    void setWidth(int w) {
        width = w;
    }

    void setHeight(int h) {
        height = h;
    }

    Shape(int a = 0, int b = 0) {
        width = a;
        height = b;
    }
    // 如果不加虚函数的话，默认就会被静态链接到基类的这里，如果派生类调用了此方法，就会被编译器默认静态链接到此方法上，因为指针都是指向同一个类
    // 如果加了一个virtual关键字，告诉编译器在编译时候不要链接到该函数上
    // 导致错误输出的原因是，调用函数 area() 被编译器设置为基类中的版本，这就是所谓的静态多态，或静态链接 - 函数调用在程序执行前就准备好了。有时候这也被称为早绑定，因为 area() 函数在程序编译期间就已经设置好了。
    virtual int area() {
        cout << "Parent class area :" << endl;
        return 0;
    }
//    = 0 告诉编译器，函数没有主体，上面的虚函数是纯虚函数。
// 提供接口框架的纯虚函数
//    virtual int area() = 0;
protected:
//    宽
    int width;
//    高
    int height;
};


#endif //SERVER_SHAPE_H
