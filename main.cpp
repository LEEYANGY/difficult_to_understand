#include <iostream>
#include <algorithm>

//#include "class/Box.h"
#include "class/SmailBox.h"
#include "class/animal/Animal.h"
#include "class/animal/Dog.h"
#include "class/shape/Rectangle.h"
#include "class/Line.h"

using namespace std;

//���ֲ���
int binSearch() {

    return 0;
}

int main() {
    int num[4] = {4, 2, 3, 1};
    //�� a �����е�Ԫ�ؽ�������
    sort(num, num + 4, [=](int x, int y) -> bool { return x < y; });
    for (int n: num) {
        cout << n << " ";
    }
    auto display = [](int a, int b) -> void { cout << a << " " << b; };
    //���� lambda ����
    display(10, 20);
    cout << endl;
//    ����
    int nums = 10;   // ����һ���������� num����ʼֵΪ 10
    cout << "�޸�ǰ:" << nums << endl;
    int &ref = nums; // ����һ���������� ref���󶨵� num
    ref = 20;       // �޸����õ�ֵ��ʵ�����޸��� num ��ֵ
    cout << "�޸ĺ�:" << nums << endl;  // �����20

    Box Box1;        // ���� Box1������Ϊ Box
    Box Box2;        // ���� Box2������Ϊ Box
    Box Box3;        // ���� Box3������Ϊ Box
    double volume = 0.0;     // ���ڴ洢���

    // box 1 ����
    Box1.height = 5.0;
    Box1.length = 6.0;
    Box1.breadth = 7.0;

    // box 2 ����
    Box2.height = 10.0;
    Box2.length = 12.0;
    Box2.breadth = 13.0;

    // box 1 �����
    volume = Box1.height * Box1.length * Box1.breadth;
    cout << "Box1 �������" << volume << endl;

    // box 2 �����
    volume = Box2.height * Box2.length * Box2.breadth;
    cout << "Box2 �������" << volume << endl;


    // box 3 ����
    Box3.set(16.0, 8.0, 12.0);
    volume = Box3.get();
    cout << "Box3 �������" << volume << endl;

    Box box4;
    box4.setBreadth(10);
    box4.setHeight(10);
    box4.setLength(10);
    cout << "Box4 �������" << box4.get() << endl;
    cout << "Box4 �������" << box4.getVolume() << endl;

    Animal a;
    a.eat("����");
    a.sleep("����");
    Dog d;
    d.sleep("��");
    d.eat("��");
    d.bark();

    Rectangle r;
    int area = 0;
    r.setHeight(10);
    r.setWidth(10);
    area = r.getArea();
    cout << "���������" << area << endl;

    int cost = 0;
    cost = r.getCost(area);
    // ����ܻ���
    cout << "Total paint cost: $" << r.getCost(area) << endl;
    cout << "Total paint cost: $" << cost << endl;

    Line l;
    double len = 10.0;
    cout << "Line length = " << len << endl;
//    l.setLength(len);
//    len = l.getLength();
    l.length=100.0;
    cout << "Line length = " << l.getLength() << endl;

    Box box5;
    box5.setWidth(11.11);
    cout << "get Box5 width = " << box5.getWidth() << endl;

    SmailBox box6;
    box6.setPrice(10000);
    cout << "get box6 price = " << box6.getPrice() << endl;

    return 0;
}
