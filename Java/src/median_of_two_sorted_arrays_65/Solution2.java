package src.median_of_two_sorted_arrays_65;

public class Solution2 {
    /**
     * 快速查找思路：
     * <p>
     * 我们把A和B进行分割，A[,i] B[,j]并且使得两个分割总长是 (m+n)/2
     * 首先，如果确定了i，那么j也确定了，所以目标是找到这个i
     * <p>
     * 这个i怎么找？从短串的尾部开始，如果满足条件就找到了，否则二分
     * 如何判断满足条件？自然是 max(A[i],B[j]) <= min(A[i+1],B[j+1]
     * <p>
     * 最后答案就是 max(A[i],B[j])
     *
     * @param A: An integer array
     * @param B: An integer array
     * @return a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        // 确保复杂度是 log(min{m,n})
        if(m > n) return findMedianSortedArrays(B, A);
        // A取i个，B取j个，i+j=p
        int i, j;
        final int p = (m + n) / 2;
        // l r 是 i 取值的左右界
        int l = 0, r = m;
        // A B 两串左右段的最值
        double lmaxa, lmaxb, rmina, rminb;
        while (true){
            // get i, j
            i = (l + r) / 2;
            j = p - i;
            // cacu maxs and mins
            lmaxa = i > 0 ? A[i - 1] : Integer.MIN_VALUE;
            lmaxb = j > 0 ? B[j - 1] : Integer.MIN_VALUE;
            rmina = i < m ? A[i] : Integer.MAX_VALUE;
            rminb = j < n ? B[j] : Integer.MAX_VALUE;
            // update
            if(lmaxa <= rminb && lmaxb <= rmina) break;
            if(lmaxa > rminb) r = i-1;
            else l = i+1;
        }

        if ((m + n) % 2 == 1) return Math.min(rmina, rminb);
        else return (Math.min(rmina, rminb) + Math.max(lmaxa, lmaxb)) / 2;
    }
}
