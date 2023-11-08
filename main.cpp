#include <iostream>
#include <algorithm>

#include "class/Box.h"

using namespace std;

//���ֲ���
int binSearch(){

    return 0;
}

int main() {
    int num[4] = {4, 2, 3, 1};
    //�� a �����е�Ԫ�ؽ�������
    sort(num, num + 4, [=](int x, int y) -> bool { return x < y; });
    for (int n: num) {
        cout << n << " ";
    }
    auto display = [](int a,int b) -> void{cout << a << " " << b;};
    //���� lambda ����
    display(10,20);
    cout << endl;
//    ����
    int nums = 10;   // ����һ���������� num����ʼֵΪ 10
    cout << "�޸�ǰ:" << nums << endl;
    int& ref = nums; // ����һ���������� ref���󶨵� num
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

    return 0;
}
