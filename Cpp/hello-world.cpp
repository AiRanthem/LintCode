//
// Created by airan on 2020/9/19.
//
# include "iostream"
# include "string"
using namespace std;

void test(int &n){
    n += 1;
}

int main(){
    string a;
    cin >> a;
    cout << a.substr(1);
}