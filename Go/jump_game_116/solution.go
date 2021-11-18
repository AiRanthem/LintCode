package jump_game_116

/**
 * @param A: A list of integers
 * @return: A boolean
 */
func canJump(A []int) bool {
	dp := make([]bool, len(A))
	dp[len(dp)-1] = true
	for i := len(dp) - 2; i >= 0; i-- {
		for j := 1; j <= A[i]; j++ {
			if dp[i + j] {
				dp[i] = true
				break
			}
		}
	}
	return dp[0]
}
