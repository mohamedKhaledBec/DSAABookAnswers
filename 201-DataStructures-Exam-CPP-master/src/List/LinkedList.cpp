//
// Created by Olcay Taner YILDIZ on 6.03.2023.
//

#include "LinkedList.h"

LinkedList::LinkedList() {
    head = nullptr;
    tail = nullptr;
}

void LinkedList::insertFirst(Node *newNode) {
    if (isEmpty()) {
        tail = newNode;
    }
    newNode->setNext(head);
    head = newNode;
}

Node *LinkedList::search(int value) {
    Node *tmp = head;
    while (tmp != nullptr) {
        if (value == tmp->getData()) {
            return tmp;
        }
        tmp = tmp->getNext();
    }
    return nullptr;
}

LinkedList::~LinkedList() {
    Node *tmp = head;
    Node *next;
    while (tmp != nullptr) {
        next = tmp->getNext();
        delete tmp;
        tmp = next;
    }
}

string LinkedList::to_string() {
    Node *tmp = head;
    string result;
    while (tmp != nullptr) {
        result += tmp->to_string() + " ";
        tmp = tmp->getNext();
    }
    return result;
}

Node *LinkedList::getPrevious(Node *node) {
    Node *tmp = head;
    Node *previous = nullptr;
    while (tmp != node) {
        previous = tmp;
        tmp = tmp->getNext();
    }
    return previous;
}

bool LinkedList::isEmpty() {
    return head == nullptr;
}

Node *LinkedList::getHead() {
    return head;
}


