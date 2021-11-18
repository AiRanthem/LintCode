//
// Created by AiRanthem on 2020/12/22.
//

#ifndef CPP_UTILS_H
#define CPP_UTILS_H

#include "vector"
#include "map"
#include "string"
#include "iostream"
#include "initializer_list"

using namespace std;

template<typename K, typename V>
void printMap(map<K, V> &m) {
    for (auto iter = m.begin(); iter != m.end(); ++iter) {
        cout << iter->first << " : " << iter->second << endl;
    }
}

template<typename T>
void printVector(vector<T> &v) {
    for (auto iter = v.begin(); iter != v.end(); ++iter) {
        cout << *iter << endl;
    }
}

template<typename T>
vector<T> asVector(initializer_list<T> params) {
    vector<T> v;
    for (auto iter = params.begin(); iter != params.end(); ++iter) {
        v.push_back(*iter);
    }
    return v;
}

#endif //CPP_UTILS_H
