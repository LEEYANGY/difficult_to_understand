#include <iostream>
#include <algorithm>

#include "class/Box.h"

using namespace std;

//二分查找
int binSearch(){

    return 0;
}

int main() {
    int num[4] = {4, 2, 3, 1};
    //对 a 数组中的元素进行排序
    sort(num, num + 4, [=](int x, int y) -> bool { return x < y; });
    for (int n: num) {
        cout << n << " ";
    }
    auto display = [](int a,int b) -> void{cout << a << " " << b;};
    //调用 lambda 函数
    display(10,20);
    cout << endl;
//    引用
    int nums = 10;   // 创建一个整数变量 num，初始值为 10
    cout << "修改前:" << nums << endl;
    int& ref = nums; // 创建一个整数引用 ref，绑定到 num
    ref = 20;       // 修改引用的值，实际上修改了 num 的值
    cout << "修改后:" << nums << endl;  // 输出：20

    Box Box1;        // 声明 Box1，类型为 Box
    Box Box2;        // 声明 Box2，类型为 Box
    Box Box3;        // 声明 Box3，类型为 Box
    double volume = 0.0;     // 用于存储体积

    // box 1 详述
    Box1.height = 5.0;
    Box1.length = 6.0;
    Box1.breadth = 7.0;

    // box 2 详述
    Box2.height = 10.0;
    Box2.length = 12.0;
    Box2.breadth = 13.0;

    // box 1 的体积
    volume = Box1.height * Box1.length * Box1.breadth;
    cout << "Box1 的体积：" << volume << endl;

    // box 2 的体积
    volume = Box2.height * Box2.length * Box2.breadth;
    cout << "Box2 的体积：" << volume << endl;


    // box 3 详述
    Box3.set(16.0, 8.0, 12.0);
    volume = Box3.get();
    cout << "Box3 的体积：" << volume << endl;

    Box box4;
    box4.setBreadth(10);
    box4.setHeight(10);
    box4.setLength(10);
    cout << "Box4 的体积：" << box4.get() << endl;
    cout << "Box4 的体积：" << box4.getVolume() << endl;

    return 0;
}
