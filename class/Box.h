#include <iostream>

using namespace std;

class Box {
public:
    double length;   // ����
    double breadth;  // ���
    double height;   // �߶�
    // ��Ա��������
    double get(void);

    void set(double len, double bre, double hei);

    Box(double length, double breadth, double height);
};

// ��Ա��������
double Box::get(void) {
    return length * breadth * height;
}

void Box::set(double len, double bre, double hei) {
    length = len;
    breadth = bre;
    height = hei;
}
