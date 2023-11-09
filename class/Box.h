#include <iostream>

using namespace std;

class Box {
public:
    double length;   // ����
    double breadth;  // ���
    double height;   // �߶�
    // ��Ա��������
    double get();
    double getVolume();
    void setLength(double len);
    void setBreadth(double bre);
    void setHeight(double hei);
    void set(double len, double bre, double hei);
    double getWidth();
    void setWidth( double wid );

private:
    double width;

protected:
    double price;
};

// ��Ա��������
double Box::get() {
    return length * breadth * height;
}

void Box::set(double len, double bre, double hei) {
    length = len;
    breadth = bre;
    height = hei;
}

void Box::setLength(double len) {
    this->length = len;
}

void Box::setBreadth(double bre) {
    this->breadth = bre;
}

void Box::setHeight(double hei) {
    this->height = hei;
}

double Box::getVolume() {
    return length * breadth * height;
}

double Box::getWidth(){
    return width;
}

void Box::setWidth(double wid) {
    this->width = wid;
}
