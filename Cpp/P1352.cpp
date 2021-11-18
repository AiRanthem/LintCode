//
// Created by AiRanthem on 2020/12/23.
//

#include "utils.h"
#define MAX_SIZ 6005
/*
 * 题目地址 https://www.luogu.com.cn/problem/P1352
 * dp[i][1/0] = i号去/不去的最大分数; 设 x 是 i 的子节点; alpha[i]是对应人去的话获得的"快乐值"
 * dp[i][0] = sum(max(dp[x][0], dp[x][1]))
 * dp[i][1] = alpha[i] + sum(dp[x][0])
 *
 * 树的存储套路：点链接，通过两个数组entry和link。对于某一个节点i，通过 x = entry[i] -> while(x) x = link[x] 就可以获取到所有的直接子节点，对于子节点的子节点就继续entry。
 * 构造方式：
 * 如何找到最终的root？记录出现过的作为子节点的id即可
 */
int n; // 人数
int dp[MAX_SIZ][2];
int ent[MAX_SIZ], lnk[MAX_SIZ];
bool isChild[MAX_SIZ]; // 如果是true则作为child出现过

void dfs(int root){
    int i = ent[root];
    while (i){
        dfs(i);
        dp[root][1] += dp[i][0];
        dp[root][0] += max(dp[i][0], dp[i][1]);
        i = lnk[i];
    }
}

int main(int argc, char *argv[]) {
    cin >> n;
    // 输入默认的快乐值
    for (int i = 1; i <= n; ++i) {
        cin >> dp[i][1];
    }
    // 点链接构造树
    int child, parent;
    for (int i = 0; i < n; ++i) {
        cin >> child >> parent;
        lnk[child] = ent[parent];
        ent[parent] = child;
        isChild[child] = true;
    }
    // 找到root
    int root;
    for (int i = 1; i <= n; ++i) {
        if (!isChild[i]) {
            root = i;
        }
    }
    dfs(root);
    cout << max(dp[root][0], dp[root][1]) << endl;
}