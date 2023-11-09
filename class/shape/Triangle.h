//
// Created by leeyangy on 2023/11/9.
//

#ifndef SERVER_TRIANGLE_H
#define SERVER_TRIANGLE_H


#include "Shape.h"

class Triangle : public Shape {
public:
    int getArea() {
        return (width * height / 2);
    }

    Triangle(int a = 0, int b = 0) : Shape(a, b) {}

    int area() {
        cout << "Triangle class area :" << endl;
        return (width * height / 2);
    }
};


#endif //SERVER_TRIANGLE_H
