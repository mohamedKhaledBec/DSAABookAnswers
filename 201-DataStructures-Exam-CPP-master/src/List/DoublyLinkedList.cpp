//
// Created by Olcay Taner YILDIZ on 14.03.2023.
//

#include "DoublyLinkedList.h"

void DoublyLinkedList::insertFirst(DoublyNode *newNode) {
    if (tail == nullptr) {
        tail = newNode;
    } else {
        ((DoublyNode*) head)->setPrevious(newNode);
    }
    newNode->setNext(head);
    head = newNode;
}

