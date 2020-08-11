package src.split_array_largest_sum_1251;

public class SolutionDP {
    /**
     * 问题：最大和最小化
     * max[i][j] = nums[0:i] 分成 j+1 份最大和
     * tail[i][j]  = i结尾j份的最后一组大小
     * max[i][j] = max{
     * nums[i]             // 最后一个数字自成一组且最大
     * max[i-1][j-1]        // 最后一个数字自成一组且不是最大
     * tail[i-1][j] + nums[i]   // 加入最后一组且最后一组最大
     * max[i-1][j]          // 加入最后一组且最后一组不是最大
     * }
     *
     * @param nums: a list of integers
     * @param m:    an integer
     * @return: return a integer
     */
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] max = new int[n][m];
        int[][] tail = new int[n][m];

        // only one part
        int temp_sum = 0;
        for (int i = 0; i < n; i++) {
            temp_sum += nums[i];
            max[i][0] = temp_sum;
            tail[i][0] = temp_sum;
        }

        for (int i = 1; i < n; i++) {
            /*
             * join = 选择加入最后一组的最大和
             * append = 选择添加到最后的最大和
             * 关于 tail 的更新
             * 如果 max[i-1][j] 不存在，join = nums[i]
             *      一定 join <= append, 说明 max[i-1][j-1] > nums[i]，tail[i][j] = join = nums[i]
             *      因为 tail[i-1][j] = 0，所以无所谓
             * 否则
             *      如果 join < append; tail[i][j] = nums[i]
             *      如果 append <= join; tail[i][j] = tail[i-1][j] + nums[i]
             *      如果相等，则尽量扩大tail
             */
            for (int j = 1; j < Math.min(m, n); j++) {
                int append = Math.max(nums[i], max[i-1][j-1]);
                int join = tail[i-1][j]!=0?Math.max(tail[i-1][j] + nums[i], max[i-1][j]):append;
                if (append >= join){
                    max[i][j] = join;
                    tail[i][j] = tail[i-1][j] + nums[i];
                } else {
                    max[i][j] = append;
                    tail[i][j] = nums[i];
                }
            }
        }

        return max[n-1][m-1];
    }
}
