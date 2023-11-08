/**
******************************************************************************  
* File Name      : Animal.h  
* Author         : leeyangy  
* E-mail         : liyangyang0713@foxmail.com  
* Create         : 2023/11/8 11:35  
******************************************************************************  
*/

#ifndef SERVER_ANIMAL_H
#define SERVER_ANIMAL_H
#include <iostream>

using namespace std;

class Animal{
public:
    static void eat(string s);
    static void sleep(string s);
};

void Animal::sleep(string s) {
    cout << s << "Ë¯¾õ" << endl;
}

void Animal::eat(string s) {
    cout << s << "³Ô¶«Î÷" << endl;
}

#endif //SERVER_ANIMAL_H
