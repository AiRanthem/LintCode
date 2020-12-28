//
// Created by AiRanthem on 2020/12/28.
//

#include "../utils.h"

class Solution {
public:
    /**
     * @param x: The end points set of edges
     * @param y: The end points set of edges
     * @param d: The length of edges
     * @return: Return the index of the fermat point
     */
    void dfs1(int x, int f, vector<vector<pair<int, int>>> &g, vector<int> &np, vector<long long> &dp) {
        np[x] = 1;
        dp[x] = 0;
        for (int i = 0; i < g[x].size(); i++) {
            int y = g[x][i].first;
            if (y == f) {
                continue;
            }
            dfs1(y, x, g, np, dp);
            np[x] += np[y];
            dp[x] += dp[y] + (long long) g[x][i].second * np[y];
        }
    }

    void dfs2(int x, int f, long long sum, vector<vector<pair<int, int>>> &g, vector<int> &np, vector<long long> &dp,
             long long &ans, int &idx, int n) {
        for (int i = 0; i < g[x].size(); i++) {
            int y = g[x][i].first;
            int d = g[x][i].second;
            if (y == f) {
                continue;
            }
            long long nextSum = sum - (long long) np[y] * d +(long long) (n - np[y]) * d;
            if (nextSum < ans || (nextSum == ans && x < idx)) {
                ans = nextSum;
                idx = y;
            }
            dfs2(y, x, nextSum, g, np, dp, ans, idx, n);
        }
    }

    int getFermatPoint(vector<int> &x, vector<int> &y, vector<int> &d) {
        // Write your code here
        int n = x.size() + 1;
        vector<vector<pair<int, int>>> g(n + 1);
        for (int i = 0; i < x.size(); i++) {
            g[x[i]].push_back(make_pair(y[i], d[i]));
            g[y[i]].push_back(make_pair(x[i], d[i]));
        }
        vector<int> np(n + 1);
        vector<long long> dp(n + 1);
        dfs1(1, 0, g, np, dp);
        long long ans = dp[1];
        int idx = 1;
        dfs2(1, 0, dp[1], g, np, dp, ans, idx, n);
        return idx;
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