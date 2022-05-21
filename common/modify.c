//
// Created by LEEYANGY on 2022/5/20.
//
#include "common.h"

/**
 * 按id查找，并修改id
 * @param head
 * @param modifyID
 * @return head
 */
struct student *modify(struct student *head, int modifyID, int modifyAfterID) {
    struct student *current = head;
    while (current != NULL) {
        if (modifyID == current->id) {
            current->id = modifyAfterID;
            break;
        } else {
//            向后移动
            current = current->next;
        }
    }
    return head;
}