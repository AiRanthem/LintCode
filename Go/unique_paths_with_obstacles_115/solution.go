package main

/**
有一个机器人的位于一个 m × n 个网格左上角。
机器人每一时刻只能向下或者向右移动一步。机器人试图达到网格的右下角。
现在考虑网格中有障碍物，那样将会有多少条不同的路径？
网格中的障碍和空位置分别用 1 和 0 来表示。
 * @param obstacleGrid: A list of lists of integers
 * @return: An integer
*/
func uniquePathsWithObstacles(obstacleGrid [][]int) int {
	var (
		m = len(obstacleGrid)
		n = len(obstacleGrid[0])
	)

	var dp = make([][]int, m)
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, n)
	}
	dp[m-1][n-1] = 1
	for i := m - 1; i >= 0; i-- {
		for j := n - 1; j >= 0; j-- {
			if obstacleGrid[i][j] == 1 {
				continue
			}
			if i < m-1 && obstacleGrid[i+1][j] != 1 {
				dp[i][j] += dp[i+1][j]
			}
			if j < n-1 && obstacleGrid[i][j+1] != 1 {
				dp[i][j] += dp[i][j+1]
			}
		}
	}
	return dp[0][0]
}
