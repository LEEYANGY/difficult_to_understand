//
// Created by leeyangy on 2023/11/8.
//

#ifndef SERVER_SHAPE_H
#define SERVER_SHAPE_H


class Shape {
public:
    void setWidth(int w) {
        width = w;
    }

    void setHeight(int h) {
        height = h;
    }

protected:
//    宽
    int width;
//    高
    int height;
};


#endif //SERVER_SHAPE_H
