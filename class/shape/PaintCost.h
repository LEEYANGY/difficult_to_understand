/**
******************************************************************************  
* File Name      : PaintCost.h  
* Author         : leeyangy  
* E-mail         : liyangyang0713@foxmail.com  
* Create         : 2023/11/8 12:33  
******************************************************************************  
*/

#ifndef SERVER_PAINTCOST_H
#define SERVER_PAINTCOST_H
class PaintCost{
public:
    int getCost(int area){
        return  area * 100;
    }
protected:

};

#endif //SERVER_PAINTCOST_H
