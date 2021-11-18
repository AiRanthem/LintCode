//
// Created by AiRanthem on 2020/9/20.
//

# include "iostream"
# include "string"
using namespace std;

int numWithLength(int l);
int numStartsWith(char start, int l);
int numStartsBetween(char start, char end, int l);

/**
 *
 * @param l
 * @return 长度为l的所有递增字符串数量
 */
int numWithLength(int l){
    if (l == 0) return 0;
    return numStartsBetween('a', 'z', l);
}

/**
 *
 * @param start
 * @param end
 * @param l
 * @return 开头从start到end的长度为l的字符串数量
 */
int numStartsBetween(char start, char end, int l){
    if(start > end) return 0;
    int cnt = 0;
    for (char i = start; i <= end; ++i){
        cnt += numStartsWith(i, l);
    }
    return cnt;
}

/**
 *
 * @param start
 * @param l
 * @return 以start开头的长度为l的所有字符串数量
 */
int numStartsWith(char start, int l){
    if (l == 1) return 1;
    return numStartsBetween(start+1, 'z', l-1);
}

/**
 * 
 * @param str 
 * @return str 的字典序
 */
int dictOrder(string s, char base = 'a' - 1){
    // 假设字符串s开头是 x ，长度为l。
    int l = s.length();
    int cnt = 0;
    // step1 求出长度小于 l 的字符串数量
    for(int i = 1; i < l; ++i) cnt += numWithLength(i);
    // step2 求出 'a' 到 x - 1 的字符串数量
    cnt += numStartsBetween('a', s[0] - 1, l);
    // step3 按照step2来处理剩下来的进度
    for(int i = 1; i < l; ++i) cnt += numStartsBetween(s[i-1]+1, s[i]-1, l - i);
    // step4 加上自己
    return cnt + 1;
}

int main(){
    int k;
    cin >> k;
    string input;
    for (int i = 0; i < k; ++i) {
        cin >> input;
        cout << dictOrder(input) << endl;
    }
}