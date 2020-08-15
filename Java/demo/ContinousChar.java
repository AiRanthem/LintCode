package demo;

public class ContinousChar {
    public int cc(int[] nums){
        int count = 0;
        int max = 0;
        int before = -1;
        for (int num : nums) {
            if (num == before){
                count++;
            } else {
                max = Integer.max(max, count);
                count = 1;
                before = num;
            }
        }
        return max;
    }
}
