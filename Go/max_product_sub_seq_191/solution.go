package max_product_sub_seq_191

/**
 * @param nums: An array of integers
 * @return: An integer
 */
func maxProduct(nums []int) int {
	l := len(nums)
	// p[i] means the max prod of nums[0:i+1]
	p := make([]int, l)
	// n[i] means the min prod of nums[0:i+1]
	n := make([]int, l)
	p[0] = nums[0]
	n[0] = nums[0]
	resl := nums[0]
	for i := 1; i < l; i++ {
		num := nums[i]
		var maxProd = p[i-1] * num
		var minProd = n[i-1] * num
		p[i] = max(num, maxProd, minProd)
		n[i] = min(num, maxProd, minProd)
		resl = bimax(p[i], resl)
	}
	return resl
}

func max(a int, b int, c int) int {
	if a > b {
		return bimax(a, c)
	} else {
		return bimax(b, c)
	}
}

func bimax(a int, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}

func min(a int, b int, c int) int {
	if a > b {
		return bimin(b, c)
	} else {
		return bimin(a, c)
	}
}

func bimin(a int, b int) int {
	if a > b {
		return b
	} else {
		return a
	}
}
