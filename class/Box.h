#include <iostream>

using namespace std;

class Box {
public:
    double length;   // 长度
    double breadth;  // 宽度
    double height;   // 高度
    // 成员函数声明
    double get(void);

    void set(double len, double bre, double hei);

    Box(double length, double breadth, double height);
};

// 成员函数定义
double Box::get(void) {
    return length * breadth * height;
}

void Box::set(double len, double bre, double hei) {
    length = len;
    breadth = bre;
    height = hei;
}
