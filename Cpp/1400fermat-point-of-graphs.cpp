//
// Created by AiRanthem on 2020/12/22.
//
#include "utils.h"

/**
 * 树形DP
 * dp[i] = 以节点i为根的子树的距离和
 * np[i] = 以节点i为根的子树的节点总数
 * x为i的子节点，有转移方程
 * dp[i] = sigma(np[x] * dist[x, i] + dp[x])
 * np[i] = 1 + sigma(np[x])
 * 对于dp起点root，dp[root]就是root的sum
 *
 * 发现对于每一个节点计算树形DP超时，尝试仅进行一次树形DP，并通过这次的结果推导出其余所有节点的sum值
 * 设X为x的集合，j为i的子节点（因为从root开始treeDp，是有父子关系的），假设sum[i]已知（sum[root] = dp[root]）。
 * 树中去除子树j后，i的sum值记为reduced[i,j]，有
 * sum[i] = dp[j] + np[j] * dist[i, j] + reduced[i,j]
 * sum[j] = dp[j] + reduced[i,j] + (n - np[j]) * dist[i, j] // 主要发生改变的是 j->i 的链路数量替换为 i->j 的链路数量
 *        = dp[j] + (n - np[j]) * dist[i, j] + sum[i] - dp[j] - np[j] * dist[i, j]
 *        = sum[i] + (n - 2 * np[j]) * dist[i, j]
 */
class Solution {
public:
    /**
     * 使用tree dp来计算到某个节点的距离和
     * @param node
     * @param from
     * @param graph
     * @param np
     * @param dp
     */
    void treeDp(int node, int from,
                vector<vector<pair<int, int>>> &graph,
                vector<int> &np,
                vector<long long> &dp) {
        np[node] = 1;
        dp[node] = 0;
        for (const auto &childPair : graph[node]) {
            int next = childPair.first, d = childPair.second;
            if (next == from) {
                continue;
            }
            treeDp(next, node, graph, np, dp);
            np[node] += np[next];
            dp[node] += np[next] * d + dp[next];
        }
    }

    /**
     * 遍历所有节点，通过推倒出的公式计算出每个节点的sum
     * @param node
     * @param from
     * @param sum
     * @param minSum
     * @param ans
     * @param graph
     * @param np
     * @param dp
     */
    void dfs(int node, int from, long long sum, long long& minSum, int& n, int &ans,
             vector<vector<pair<int, int>>> &graph,
             vector<int> &np,
             vector<long long> &dp) {
        for (const auto &childPair : graph[node]) {
            int next = childPair.first, d = childPair.second;
            if (next == from) {
                continue;
            }
            long long nextSum = sum + (n - 2 * (long long)np[next]) * d; // 这里要把np转long long，否则乘法乘出来会被reduce到int
            if (nextSum < minSum || nextSum == minSum && next < ans) {
                minSum = nextSum;
                ans = next;
            }
            dfs(next, node, nextSum, minSum, n, ans, graph, np, dp);
        }
    }

    /**
     * @param x: The end points set of edges
     * @param y: The end points set of edges
     * @param d: The length of edges
     * @return: Return the index of the fermat point
     */
    int getFermatPoint(vector<int> &x, vector<int> &y, vector<int> &d) {
        int n = x.size() + 1; // 题目没有讲清楚怎么获得node总数n，答案里说是size+1。纠结这个意义不大，直接用了。
        vector<int> np(n + 1);
        vector<long long> dp(n + 1);
        vector<vector<pair<int, int>>> graph(n + 1);
        // build graph 双向点邻接。
        for (int i = 0; i < x.size(); ++i) {
            graph[x[i]].push_back(make_pair(y[i], d[i]));
            graph[y[i]].push_back(make_pair(x[i], d[i]));
        }
        // get answer
        treeDp(1, 0, graph, np, dp);
        int ans = 1;
        long long minSum = dp[1];
        dfs(1, 0, dp[1], minSum, n, ans, graph, np, dp);
        return ans;
    }
};

int main(int argc, char *argv[]) {
    Solution solution;
//    vector<int> x = asVector(
//            {1, 2, 2, 2, 2, 6, 7, 8, 8, 7, 11, 12, 12, 1, 15, 15, 17, 17, 17, 20, 21, 21, 23, 23, 15, 26, 27, 27, 29,
//             29, 27, 27, 33, 33, 33, 33, 37, 37, 39, 39, 39}),
//            y = asVector(
//            {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
//             31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42}),
//            d = asVector({1, 1, 1});
    vector<int> x = asVector({1, 2, 2}),
            y = asVector({2, 3, 4}),
            d = asVector({1, 1, 1});

    int i = solution.getFermatPoint(x, y, d);
    cout << i << endl;
}
