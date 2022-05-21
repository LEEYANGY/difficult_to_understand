//
// Created by LEEYANGY on 2022/5/20.
//

#include "common.h"

/**
 * 按id删除
 * @param head
 * @param delID
 * @return head
 */
struct student *del(struct student *head, int delID) {
    struct student *current = head, *prev;

    while (current != NULL) {
        if (delID == current->id) {
            prev->next = current->next;
            break;
        } else {
            prev = current;
            current = current->next;
        }
    }

    return head;
}

