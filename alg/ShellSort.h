/**
******************************************************************************  
* File Name      : ShellSort.h  
* Author         : leeyangy  
* E-mail         : liyangyang0713@foxmail.com  
* Create         : 2023/11/9 20:11  
* Description    : 希尔排序算法实现
 ******************************************************************************
*/

#ifndef SERVER_SHELLSORT_H
#define SERVER_SHELLSORT_H

#include <iostream>
#include <vector>

template<typename T> void shellSort(std::vector<T>& arr){
//    获取vector元素个数
    int n=arr.size();
//    第一层for控制dk增量
    for(int dk=n/2; dk>0; dk/=2){
//        第二层用来查找元素
        for (int i = dk; i < n; ++i) {
            T temp = arr[i];
            int j = i;
            while(j>=dk && arr[j-dk]>temp){
                arr[j] = arr[j-dk];
                j-=dk;
            }
            arr[j] = temp;
        }
    }
}

#endif //SERVER_SHELLSORT_H
