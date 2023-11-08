/**
******************************************************************************  
* File Name      : Dog.h  
* Author         : leeyangy  
* E-mail         : liyangyang0713@foxmail.com  
* Create         : 2023/11/8 11:39  
******************************************************************************  
*/

#ifndef SERVER_DOG_H
#define SERVER_DOG_H
#include "Animal.h"

class Dog : public Animal{
public:
    static void bark();
    static void sleep(string s);
};

void Dog::bark() {
    cout << "ÍôÍôÍô" << endl;
}

void Dog::sleep(string s) {
    Animal::sleep(s);
}

#endif //SERVER_DOG_H
