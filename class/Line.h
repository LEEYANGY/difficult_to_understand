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

    // �򵥵Ĺ��캯��
    Line(double len);

    // �������캯��
    Line(const Line &obj);
    void display();
    ~Line();

private:
    double *ptr;
//protected:
};

Line::Line(double len) {
    cout << "���ù��캯��" << endl;
    // Ϊָ������ڴ�
    ptr = new double;
    *ptr = len;
//    this->length = len;
}

Line::Line(const Line &obj) {
    cout << "���ÿ������캯����Ϊָ�� ptr �����ڴ�" << endl;
    ptr = new double;
    // ����ֵ
    *ptr = *obj.ptr;
}

Line::~Line(void) {
    cout << "�ͷ��ڴ�" << endl;
    delete ptr;
}

// ��Ա��������
//��ȡ������
double Line::getLength() {
//    return length;
    return *ptr;
}

//void Line::setLength(double len) {
//    length = len;
//}

void display(Line obj) {
    cout << "line ��С : " << obj.getLength() << endl;
}

#endif //SERVER_LINE_H
