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
//    �����޲ι��췽��
    SmailBox();
//    ����������������
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
    cout << "�޲ι��췽������ʼ����" << endl;
}

SmailBox::SmailBox(double price) {
    cout << "�вι��췽������ʼ����" << endl;
    this->price = price;
}

SmailBox::~SmailBox() {
    cout << "�����췽��������" << endl;
}


#endif //SERVER_SMAILBOX_H
