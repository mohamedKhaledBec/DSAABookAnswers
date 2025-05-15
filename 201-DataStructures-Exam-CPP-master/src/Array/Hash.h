//
// Created by Olcay Taner YILDIZ on 17.04.2023.
//

#ifndef DATASTRUCTURES_CPP_HASH_H
#define DATASTRUCTURES_CPP_HASH_H


#include "Element.h"

namespace array {

    class Hash {
    private:
        Element **table;
        bool *deleted;
        int N;
        int hashFunction(int value);
    public:
        explicit Hash(int N);
        ~Hash();
        Element* search(int value);
        void insert(int value);
    };

}
#endif //DATASTRUCTURES_CPP_HASH_H
