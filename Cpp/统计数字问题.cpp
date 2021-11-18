//
// Created by AiRanthem on 2020/9/20.
//

#include "iostream"

using namespace std;

/**
 * @param k
 * @param n
 * @return 数字 n 中 k 出现几次
 */
int singleCounts(int k, int n){
    if(k == 0 && n == 0) return 1;
    int cnt = 0;
    while (n != 0){
        if(n % 10 == k) ++cnt;
        n /= 10;
    }
    return cnt;
}

/**
 * @param k
 * @param n
 * @return k 在 1~n 的数字中出现几次
 */
int digitCounts(int k, int n){
    int cnt = 0;
    for (int i = 1; i <= n; ++i){
        cnt += singleCounts(k, i);
    }
    return cnt;
}

int main() {
    int n;
    cin >> n;

    int cnt[10];
    for (int i = 0; i <= 9; ++i) {
        cnt[i] = digitCounts(i, n);
    }

    for (int i = 0; i < 9; ++i) {
        cout << cnt[i] << endl;
    }

    return 0;
}
