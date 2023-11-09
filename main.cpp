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

// ��һ�������ռ�
namespace first_space {
    void func() {
        cout << "Inside first_space" << endl;
    }
}

// �ڶ��������ռ�
namespace second_space {
    void func() {
        cout << "Inside second_space" << endl;
    }
}

// �����������ռ�
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

//����ģ��
//template <typename type> ret-type func-name(parameter list)
//{
//// ����������
//}
//type �Ǻ�����ʹ�õ��������͵�ռλ������

//�����������е����ֵ
template<typename T>
inline T const &Max(T const &a, T const &b) {
    return a < b ? b : a;
}

//��ģ�� ���綨�庯��ģ��һ����Ҳ���Զ�����ģ�塣������������һ����ʽ����
//template <class type> class class-name {
//...
//}
//�����type ��ռλ���������ƣ��������౻ʵ������ʱ�����ָ��������ʹ��һ�����ŷָ����б���������������������
//������ Stack<>����ʵ���˷��ͷ�������Ԫ�ؽ�����ջ��ջ����
template<class T>
class Stack {
private:
    vector<T> elems;     // Ԫ��

public:
    void push(T const &);  // ��ջ
    void pop();               // ��ջ
    T top() const;            // ����ջ��Ԫ��
    bool empty() const {       // ���Ϊ���򷵻��档
        return elems.empty();
    }
};

template<class T>
void Stack<T>::push(T const &elem) {
    // ׷�Ӵ���Ԫ�صĸ���
    elems.push_back(elem);
}

template<class T>
void Stack<T>::pop() {
    if (elems.empty()) {
        throw out_of_range("Stack<>::pop(): empty stack");
    }
    // ɾ�����һ��Ԫ��
    elems.pop_back();
}

template<class T>
T Stack<T>::top() const {
    if (elems.empty()) {
        throw out_of_range("Stack<>::top(): empty stack");
    }
    // �������һ��Ԫ�صĸ���
    return elems.back();
}

// ��ʼ���� Box �ľ�̬��Ա
int Box::objectCount = 0;

int main() {
    int num[4] = {4, 2, 3, 1};
    //�� a �����е�Ԫ�ؽ�������
    sort(num, num + 4, [=](int x, int y) -> bool { return x < y; });
    for (int n: num) {
        cout << n << " ";
    }
    auto displays = [](int a, int b) -> void { cout << a << " " << b; };
    //���� lambda ����
    displays(10, 20);
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
    //    ָ�����ָ��
    // Declare pointer to a class.
    Box *ptrBox = new Box();
    Box box8;
    box8.setWidth(100);
    ptrBox = &box8;
    cout << ptrBox->getWidth() << " " << endl;
//    ��̬��Ա�����;�̬����
    box8.objectCount++;
    // ������������
    cout << "Total objects: " << Box::objectCount << endl;
    box8.objectCount++;
    // �ڴ�������֮��������������
    cout << "Final Stage Count: " << Box::getCount() << endl;
    ++box7.objectCount;
    cout << "Final Stage Count: " << box8.getCount() << endl;

    //    ��̬���������˼���Ƕ�����̬������֮����ڲ�νṹ��������֮����ͨ���̳й���ʱ���ͻ��õ���̬��
    //    C++ ��̬��ζ�ŵ��ó�Ա����ʱ������ݵ��ú����Ķ����������ִ�в�ͬ�ĺ���
    //    �麯�� ���ڻ�����ʹ�ùؼ��� virtual �����ĺ������������������¶�������ж�����麯��ʱ������߱�������Ҫ��̬���ӵ��ú�����
    //    ������Ҫ�����ڳ������������Ը��������õĶ���������ѡ����õĺ��������ֲ�������Ϊ��̬���ӣ�����ڰ󶨡�
    Shape *shape = new Shape();
    Rectangle rec(10, 7);
    Triangle tri(10, 5);
    // �洢���εĵ�ַ
    shape = &rec;
    // ���þ��ε���������� area
    shape->area();

    // �洢�����εĵ�ַ
    shape = &tri;
    // ���������ε���������� area
    shape->area();
    // �����������
    cout << "Total Rectangle area: " << rec.getArea() << endl;
    cout << "Total Triangle area: " << tri.getArea() << endl;

//     �Զ����쳣
    cout << "�쳣����ǰ" << endl;
    try {
        cout << "�쳣����ǰ try" << endl;
        throw MyException();
    } catch (MyException e) {
        cout << "�쳣������catch1" << endl;
        cout << "MyException caught" << endl;
        cout << "�쳣������catch2" << endl;
        cout << e.what() << endl;
        cout << "�쳣������catch3" << endl;
    } catch (std::exception &e) {
        //�����Ĵ���
        cout << "�����쳣";
    }

//    c++��̬�ڴ�
//    ջ���ں����ڲ����������б�������ռ��ջ�ڴ档
//    �ѣ����ǳ�����δʹ�õ��ڴ棬�ڳ�������ʱ�����ڶ�̬�����ڴ档
//    ������̬�ڴ�Ҫ��ʼ���� new��Ҫdelete
//    ........
    cout << "���õ�һ�������ռ��еĺ���" << endl;
    first_space::func();
    cout << "���õڶ��������ռ��еĺ���" << endl;
    second_space::func();
    cout << "�����Զ��������ռ�" << endl;
    func();
    cout << "�����Զ���Ƕ�������ռ�" << endl;
    third_space::first_space::func();

//    Ԥ�����
    cout << "Value of __LINE__ : " << __LINE__ << endl;
    cout << "Value of __FILE__ : " << __FILE__ << endl;
    cout << "Value of __DATE__ : " << __DATE__ << endl;
    cout << "Value of __TIME__ : " << __TIME__ << endl;

    cout << "ʹ���Զ��庯��ģ��" << endl;
    cout << "Max(100, 200): " << Max(100, 200) << endl;
    cout << "Max(Hello, World): " << Max("Hello", "World") << endl;

//    template <typename type> ret-type func-name(parameter list)
//    {
//        // ����������
//    }

//    template <class type> class class-name {
//        ...
//    }

    try {
        Stack<int> intStack;  // int ���͵�ջ
        Stack<string> stringStack;    // string ���͵�ջ

        // ���� int ���͵�ջ
        intStack.push(7);
        cout << intStack.top() << endl;

        // ���� string ���͵�ջ
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
    cout << "����ǰ" << endl;
    for (auto a: arr) cout << a << " ";
    shellSort(arr);
    cout << "�����" << endl;
    for (auto a: arr) cout << a << " ";
    cout << endl;
    return 0;
}
