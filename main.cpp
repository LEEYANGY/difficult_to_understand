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
#include "alg/ShellSort.h"

// 第一个命名空间
namespace first_space {
    void func() {
        cout << "Inside first_space" << endl;
    }
}

// 第二个命名空间
namespace second_space {
    void func() {
        cout << "Inside second_space" << endl;
    }
}

// 第三个命名空间
namespace third_space {
    void func() {
        cout << "Inside second_space" << endl;
    }

    namespace first_space {
        void func() {
            cout << "Inside first_space" << endl;
        }
    }
    namespace second_space {
        void func() {
            cout << "Inside second_space" << endl;
        }
    }
}

using namespace first_space;

using namespace std;

//函数模板
//template <typename type> ret-type func-name(parameter list)
//{
//// 函数的主体
//}
//type 是函数所使用的数据类型的占位符名称

//返回两个数中的最大值
template<typename T>
inline T const &Max(T const &a, T const &b) {
    return a < b ? b : a;
}

//类模板 正如定义函数模板一样，也可以定义类模板。泛型类声明的一般形式如下
//template <class type> class class-name {
//...
//}
//在这里，type 是占位符类型名称，可以在类被实例化的时候进行指定。可以使用一个逗号分隔的列表来定义多个泛型数据类型
//定义类 Stack<>，并实现了泛型方法来对元素进行入栈出栈操作
template<class T>
class Stack {
private:
    vector<T> elems;     // 元素

public:
    void push(T const &);  // 入栈
    void pop();               // 出栈
    T top() const;            // 返回栈顶元素
    bool empty() const {       // 如果为空则返回真。
        return elems.empty();
    }
};

template<class T>
void Stack<T>::push(T const &elem) {
    // 追加传入元素的副本
    elems.push_back(elem);
}

template<class T>
void Stack<T>::pop() {
    if (elems.empty()) {
        throw out_of_range("Stack<>::pop(): empty stack");
    }
    // 删除最后一个元素
    elems.pop_back();
}

template<class T>
T Stack<T>::top() const {
    if (elems.empty()) {
        throw out_of_range("Stack<>::top(): empty stack");
    }
    // 返回最后一个元素的副本
    return elems.back();
}

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

//    c++动态内存
//    栈：在函数内部声明的所有变量都将占用栈内存。
//    堆：这是程序中未使用的内存，在程序运行时可用于动态分配内存。
//    操作动态内存要有始有终 new了要delete
//    ........
    cout << "调用第一个命名空间中的函数" << endl;
    first_space::func();
    cout << "调用第二个命名空间中的函数" << endl;
    second_space::func();
    cout << "测试自定义命名空间" << endl;
    func();
    cout << "测试自定义嵌套命名空间" << endl;
    third_space::first_space::func();

//    预定义宏
    cout << "Value of __LINE__ : " << __LINE__ << endl;
    cout << "Value of __FILE__ : " << __FILE__ << endl;
    cout << "Value of __DATE__ : " << __DATE__ << endl;
    cout << "Value of __TIME__ : " << __TIME__ << endl;

    cout << "使用自定义函数模板" << endl;
    cout << "Max(100, 200): " << Max(100, 200) << endl;
    cout << "Max(Hello, World): " << Max("Hello", "World") << endl;

//    template <typename type> ret-type func-name(parameter list)
//    {
//        // 函数的主体
//    }

//    template <class type> class class-name {
//        ...
//    }

    try {
        Stack<int> intStack;  // int 类型的栈
        Stack<string> stringStack;    // string 类型的栈

        // 操作 int 类型的栈
        intStack.push(7);
        cout << intStack.top() << endl;

        // 操作 string 类型的栈
        stringStack.push("hello");
        cout << stringStack.top() << std::endl;
        stringStack.pop();
        stringStack.pop();
    }
    catch (exception const &ex) {
        cerr << "Exception: " << ex.what() << endl;
//        return -1;
    }

    vector<int> arr = {1, 11, 2, 21, 2222, 9, 3, 4, 5, 6, 7, 8, 9};
    cout << "排序前" << endl;
    for (auto a: arr) cout << a << " ";
    shellSort(arr);
    cout << "排序后" << endl;
    for (auto a: arr) cout << a << " ";
    cout << endl;
    return 0;
}
