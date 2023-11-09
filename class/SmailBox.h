/**
******************************************************************************  
* File Name      : SmailBox.h  
* Author         : leeyangy  
* E-mail         : liyangyang0713@foxmail.com  
* Create         : 2023/11/9 10:36  
******************************************************************************  
*/

#ifndef SERVER_SMAILBOX_H
#define SERVER_SMAILBOX_H

#include "Box.h"

class SmailBox : public Box {
public:
    double getPrice();
    void setPrice(double price);
//    这是无参构造方法
    SmailBox();
//    这是析构函数声明
    ~SmailBox();
    explicit SmailBox(double price);

private:
protected:
};

double SmailBox::getPrice() {
    return this->price;
}

void SmailBox::setPrice(double price) {
    this->price = price;
}

SmailBox::SmailBox() {
    cout << "无参构造方法被初始化了" << endl;
}

SmailBox::SmailBox(double price) {
    cout << "有参构造方法被初始化了" << endl;
    this->price = price;
}

SmailBox::~SmailBox() {
    cout << "析构造方法结束了" << endl;
}


#endif //SERVER_SMAILBOX_H
