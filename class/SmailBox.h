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

class SmailBox : public Box{
public:
    double getPrice();
    void setPrice(double price);
private:
protected:
};

double SmailBox::getPrice() {
    return this->price;
}

void SmailBox::setPrice(double price) {
    this->price = price;
}


#endif //SERVER_SMAILBOX_H
