package max_product_sub_seq_191

/**
 * @param nums: An array of integers
 * @return: An integer
 */
func maxProduct (nums []int) int {
	l := len(nums)
	// dp[i] means the max prod of nums[0:i+1]
	dp := make([]int, l)
	// last[i] indicates the specific sub seq nums[last[i]:i+1]
	last := make([]int, l)
	dp[0] = nums[0]
	for i := 1; i < l; i++ {
		if last[i-1] ==  {

		}
	}
}


