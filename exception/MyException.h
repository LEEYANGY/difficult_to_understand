/**
******************************************************************************  
* File Name      : MyException.h  
* Author         : leeyangy  
* E-mail         : liyangyang0713@foxmail.com  
* Create         : 2023/11/9 16:36  
******************************************************************************  
*/

#include <iostream>

using namespace std;

#ifndef SERVER_MYEXCEPTION_H
#define SERVER_MYEXCEPTION_H

struct MyException : public exception {
    const char *what() const throw() {
        return "C++ Exception";
    }
};

#endif //SERVER_MYEXCEPTION_H
