#include <iostream>
#include <algorithm>

using namespace std;

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
    return 0;
}
