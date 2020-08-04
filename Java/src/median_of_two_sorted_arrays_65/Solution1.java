package src.median_of_two_sorted_arrays_65;

public class Solution1 {
    /**
     * 使用二分法。
     * 问题在于，对于ＡＢ两个数组，如果使用二分，切割出一部分的数组，
     * 那么答案的中位数对于剩余的这些数组就不是中位数了
     * 所以要把问题转化成求第ｋ大的元素
     *
     * @param A: An integer array
     * @param B: An integer array
     * @return a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if((m + n) % 2 == 1){
            return getKth(A, 0, m-1, B, 0,n-1,(m+n)/2+1);
        } else {
            return (getKth(A,0,m-1,B,0,n-1,(m+n)/2)+
                    getKth(A,0,m-1,B,0,n-1,(m+n)/2+1))/2;
        }
    }

    // 小技巧：如果AB两个序列可能出现比大小的情况，那么不要用属性，直接传参，比完大小递归就行。
    // 这里设定的前提就是剩余段A比B短。
    public double getKth(int[] A, int la, int ra, int[] B, int lb, int rb, int k) {
        int lena = ra - la + 1;
        int lenb = rb - lb + 1;
        if (lena > lenb)
            return getKth(B, lb, rb, A, la, ra, k); // trick
        // 短串空
        if (lena <= 0) {
            return B[lb + k - 1];
        }
        // 短串飞空且找第一
        if (k == 1) {
            return Math.min(A[la], B[lb]);
        }
        // 否则分治，找到 A B两段分别 k/2
        // 长串一定有k/2个，不然总数都没有k个，找不到第k个。
        int i = la + Math.min(lena, k / 2) - 1;
        int j = lb + k / 2 - 1;
        if (A[i] < B[j]) {
            k = k - (i - la + 1);
            la = i + 1;
        } else {
            k = k - (j - lb + 1);
            lb = j + 1;
        }
        return getKth(A, la, ra, B, lb, rb, k);
    }
}