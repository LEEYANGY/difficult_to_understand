#include <iostream>
#include <algorithm>

//#include "class/Box.h"
#include "class/SmailBox.h"
#include "class/animal/Animal.h"
#include "class/animal/Dog.h"
#include "class/shape/Rectangle.h"
#include "class/shape/Triangle.h"
//#include "class/Line.h"
#include "exception/MyException.h"

using namespace std;

// 初始化类 Box 的静态成员
int Box::objectCount = 0;

int main() {
    int num[4] = {4, 2, 3, 1};
    //对 a 数组中的元素进行排序
    sort(num, num + 4, [=](int x, int y) -> bool { return x < y; });
    for (int n: num) {
        cout << n << " ";
    }
    auto displays = [](int a, int b) -> void { cout << a << " " << b; };
    //调用 lambda 函数
    displays(10, 20);
    cout << endl;
//    引用
    int nums = 10;   // 创建一个整数变量 num，初始值为 10
    cout << "修改前:" << nums << endl;
    int &ref = nums; // 创建一个整数引用 ref，绑定到 num
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

    Animal a;
    a.eat("动物");
    a.sleep("动物");
    Dog d;
    d.sleep("狗");
    d.eat("狗");
    d.bark();

    Rectangle r;
    int area = 0;
    r.setHeight(10);
    r.setWidth(10);
    area = r.getArea();
    cout << "矩形面积：" << area << endl;

    int cost = 0;
    cost = r.getCost(area);
    // 输出总花费
    cout << "Total paint cost: $" << r.getCost(area) << endl;
    cout << "Total paint cost: $" << cost << endl;

//    Line l;
//    double len = 10.0;
//    cout << "Line length = " << len << endl;
//    l.setLength(len);
//    len = l.getLength();
//    l.length=100.0;
//    cout << "Line length = " << l.getLength() << endl;

    Box box5;
    box5.setWidth(11.11);
    cout << "get Box5 width = " << box5.getWidth() << endl;

    SmailBox box6;
    box6.setPrice(10000);
    cout << "get box6 price = " << box6.getPrice() << endl;
    SmailBox box7 = *new SmailBox(70);
    cout << "get box7 price = " << box7.getPrice() << endl;

//    Line l(10);
//    display(l);
    //    指向类的指针
    // Declare pointer to a class.
    Box *ptrBox = new Box();
    Box box8;
    box8.setWidth(100);
    ptrBox = &box8;
    cout << ptrBox->getWidth() << " " << endl;
//    静态成员变量和静态方法
    box8.objectCount++;
    // 输出对象的总数
    cout << "Total objects: " << Box::objectCount << endl;
    box8.objectCount++;
    // 在创建对象之后输出对象的总数
    cout << "Final Stage Count: " << Box::getCount() << endl;
    ++box7.objectCount;
    cout << "Final Stage Count: " << box8.getCount() << endl;

    //    多态按字面的意思就是多种形态。当类之间存在层次结构，并且类之间是通过继承关联时，就会用到多态。
    //    C++ 多态意味着调用成员函数时，会根据调用函数的对象的类型来执行不同的函数
    //    虚函数 是在基类中使用关键字 virtual 声明的函数。在派生类中重新定义基类中定义的虚函数时，会告诉编译器不要静态链接到该函数。
    //    我们想要的是在程序中任意点可以根据所调用的对象类型来选择调用的函数，这种操作被称为动态链接，或后期绑定。
    Shape *shape = new Shape();
    Rectangle rec(10, 7);
    Triangle tri(10, 5);
    // 存储矩形的地址
    shape = &rec;
    // 调用矩形的求面积函数 area
    shape->area();

    // 存储三角形的地址
    shape = &tri;
    // 调用三角形的求面积函数 area
    shape->area();
    // 输出对象的面积
    cout << "Total Rectangle area: " << rec.getArea() << endl;
    cout << "Total Triangle area: " << tri.getArea() << endl;

//     自定义异常
    cout << "异常发生前" << endl;
    try {
        cout << "异常发生前 try" << endl;
        throw MyException();
    } catch (MyException e) {
        cout << "异常发生中catch1" << endl;
        cout << "MyException caught" << endl;
        cout << "异常发生中catch2" << endl;
        cout << e.what() << endl;
        cout << "异常发生中catch3" << endl;
    } catch (std::exception &e) {
        //其他的错误
        cout << "其它异常";
    }

    return 0;
}
